
/**
 * @class DadesAgencia
 * @brief 
 * @details 
 *
 * @author Roger Generoso Masós
 * @version 2017.4.5
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class DadesAgencia{

    private Scanner fitxerDades;

    private GrupClients clients;
    private Map<String, Lloc> llocs;
    private Map< PuntInteres, Map<PuntInteres,TransportDirecte> > connexionsDirectes;
    private Map< Lloc, Map<Lloc, TransportIndirecte> > connexionsIndirectes;

    private Map<String, PuntInteres> pendents;



    DadesAgencia(String fitxer) throws FileNotFoundException {
        File fitxerD = new File(fitxer);
        fitxerDades = new Scanner(fitxerD);
        clients = new GrupClients();
        llocs = new HashMap<>();
        pendents = new HashMap<>();
    }

    /**
     * @pre 
     * @post 
     */
    public void llegirDadesFitxer(){
        String linAct = fitxerDades.nextLine(); //Ens saltem el comentari.
        Locale.setDefault(Locale.US);
        while(fitxerDades.hasNextLine()){
            linAct = fitxerDades.nextLine();
            if(linAct.equals("client")) crearClient();
            else if(linAct.equals("lloc")) crearLloc();
            else if(linAct.equals("allotjament")) crearAllotjament();
            else if(linAct.equals("lloc visitable")) crearLlocVisitable();
            else if(linAct.equals("visita")) crearVisita();
            else if(linAct.equals("associar lloc")) associarALloc();
            else if(linAct.equals("associar transport")) associarTransALloc();
            else if(linAct.equals("transport directe")) altaTransDirecte(); 
            else if(linAct.equals("transport indirecte")) altaTransIndirecte();
            else if(linAct.equals("viatge")) crearComanda(); 
        }
    }

    private void crearClient(){
        List<String> preferencies = new ArrayList<>();
        String nom = fitxerDades.nextLine();
        String prefAct = "";
        while(!esSeparador(prefAct) && fitxerDades.hasNextLine()){
            prefAct = fitxerDades.nextLine();
            preferencies.add(prefAct);
        }
        Client nou = new Client(nom, preferencies);
        clients.afegirClient(nou);
    }
    private void crearLloc(){
        String nom = fitxerDades.nextLine();
        String strCoord = fitxerDades.nextLine(); String[] coordVec = strCoord.split(",");
        Float latitud = Float.parseFloat(coordVec[0]);
        Float longitud = Float.parseFloat(coordVec[1]);
        String zonaHoraria = fitxerDades.nextLine();
        TimeZone zH = TimeZone.getTimeZone(zonaHoraria);
        fitxerDades.nextLine(); //Saltem separador.
        Lloc nou = new Lloc(nom, latitud, longitud, zH);
        llocs.put(nom, nou);
    }
    private void crearAllotjament(){
        String nom = fitxerDades.nextLine();
        String strCoord = fitxerDades.nextLine(); String[] coordVec = strCoord.split(",");
        Float latitud = Float.parseFloat(coordVec[0]);
        Float longitud = Float.parseFloat(coordVec[1]);
        String zonaHoraria = fitxerDades.nextLine();
        String categoria = fitxerDades.nextLine();
        Float preuHabDoble = Float.parseFloat(fitxerDades.nextLine());
        List<String> caracteristiques = new ArrayList<>();
        String caracAct = fitxerDades.nextLine();
        while(!esSeparador(caracAct) && fitxerDades.hasNextLine()){
            caracteristiques.add(caracAct);
            caracAct = fitxerDades.nextLine();
        }
        PuntInteres nou = new Allotjament(nom, latitud, longitud, zonaHoraria, categoria, preuHabDoble, caracteristiques);
        pendents.put(nom, nou);
    }
    private void crearLlocVisitable(){
        String nom = fitxerDades.nextLine();
        String strCoord = fitxerDades.nextLine(); String[] coordVec = strCoord.split(",");
        Float latitud = Float.parseFloat(coordVec[0]);
        Float longitud = Float.parseFloat(coordVec[1]);
        String zonaHoraria = fitxerDades.nextLine();
        LocalTime tempsVisitaRecomanat = LocalTime.parse(fitxerDades.nextLine());
        Float preu = Float.parseFloat(fitxerDades.nextLine());
        List<String> caracteristiques = new ArrayList<>();
        String caracAct = fitxerDades.nextLine();
        while(!esSeparador(caracAct) && fitxerDades.hasNextLine()){
            caracteristiques.add(caracAct);
            caracAct = fitxerDades.nextLine();
        }
        Locale.setDefault(Locale.US);
        DateTimeFormatter formatData = DateTimeFormatter.ofPattern("MMMM d");
        Horari nouHorari = new Horari();
        String linAct[] = fitxerDades.nextLine().split(": ");
        while(!esSeparador(linAct[0]) && linAct.length == 2 && linAct[0].contains(" - ")){
            String[] periodeAct = linAct[0].split(" - ");
            String[] horariAct = linAct[1].split("-");
            LocalTime horaObertura = LocalTime.parse(horariAct[0]);
            LocalTime horaTancament = LocalTime.parse(horariAct[1]);
            MonthDay dataIni = MonthDay.parse(periodeAct[0], formatData);
            MonthDay dataFi = MonthDay.parse(periodeAct[1], formatData);
            linAct = fitxerDades.nextLine().split(": ");
            nouHorari.afegirAHorariObertura(dataIni,dataFi,horaObertura,horaTancament);
        }
        while(!esSeparador(linAct[0])){
            MonthDay diaExepcio = MonthDay.parse(linAct[0],formatData);
            String[] horariAct = linAct[1].split("-");
            LocalTime horaObertura = LocalTime.parse(horariAct[0]);
            LocalTime horaTancament = LocalTime.parse(horariAct[1]);
            linAct = fitxerDades.nextLine().split(": ");
            nouHorari.afegirExcepio(diaExepcio,horaObertura,horaTancament);
        }
        PuntInteres nou = new LlocVisitable(nom, latitud, longitud, zonaHoraria, tempsVisitaRecomanat, preu, caracteristiques, nouHorari);
        pendents.put(nom, nou);
    }

    private void crearVisita(){
        String nom = fitxerDades.nextLine();
        String llocVisitat = fitxerDades.nextLine();
        String dataStr = fitxerDades.nextLine();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data = LocalDate.parse(dataStr,format);
        clients.assignarVisitaAClient(nom, llocVisitat, data);
    }
    private void associarALloc(){
        String nomLlocVisitable = fitxerDades.nextLine();
        String nomLloc = fitxerDades.nextLine();
        fitxerDades.nextLine();
        Lloc llocActual = llocs.get(nomLloc);
        PuntInteres pIActual = pendents.get(nomLlocVisitable);
        llocActual.afegirPuntInteres(pIActual);
    }   
    private void associarTransALloc(){
        String nomLloc = fitxerDades.nextLine();
        String nomMitjaTransp = fitxerDades.nextLine();
        LocalTime duradaTrajecte = LocalTime.parse(fitxerDades.nextLine());
        Float preu = Float.parseFloat(fitxerDades.nextLine());
        Lloc act = llocs.get(nomLloc);
        act.afegirEstacio(nomMitjaTransp, duradaTrajecte, preu);
    }
    private void altaTransDirecte(){
        String origen = fitxerDades.nextLine();
        String desti = fitxerDades.nextLine();
        String nomTransport = fitxerDades.nextLine();
        LocalTime durada = LocalTime.parse(fitxerDades.nextLine());
        Float preu = Float.parseFloat(fitxerDades.nextLine());
        //TransportDirecte nou = new TransportDirecte(origen, desti, nomTransport, durada, preu);
        //connexionsDirectes.put()
    }
    private void altaTransIndirecte(){
        String origen = fitxerDades.nextLine();
        String desti = fitxerDades.nextLine();
        String nomTransport = fitxerDades.nextLine();
        LocalTime tempsOrigenFinsMitja = LocalTime.parse(fitxerDades.nextLine());
        LocalTime tempsDesDeMitjaADesti = LocalTime.parse(fitxerDades.nextLine());
        String linAct = fitxerDades.nextLine();
        AgendaTransportIndirecte agenda = new AgendaTransportIndirecte();
        while(!esSeparador(linAct)){
            LocalDate data = LocalDate.parse(linAct);
            linAct = fitxerDades.nextLine();
            while(!esSeparador(linAct) && linAct.split("-").length != 3){
                LocalTime hora = LocalTime.parse(linAct);
                LocalTime durada = LocalTime.parse(fitxerDades.nextLine());
                Float preu = Float.parseFloat(fitxerDades.nextLine());
                agenda.afegirNouHorari(data, hora, preu, durada);
                linAct = fitxerDades.nextLine();
            }
        }
        
    }
    private void crearComanda(){

    }

    private boolean esSeparador(String a){
        return a.equals("*");
    }

}