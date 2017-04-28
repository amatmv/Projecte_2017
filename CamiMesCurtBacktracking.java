
/**
 * @class CamiMesCurtBacktracking
 * @brief 
 * @details 
 *
 * @author Roger Generoso Masós
 * @version 2017.4.5
 */

public class CamiMesCurtBacktracking{
    private List<PuntInteres> secundaris;
	private Ruta rutaAct;
	private Ruta rutaOpt;
	private boolean camiTrobat = false;

    Ruta obtenirRutaMinimaAmbSecundaris(PuntIteres a, PuntIteres b, List<PuntIteres> sec){
        secundaris = sec;
        iObtenirRutaMinimaAmbSecundaris(a,b);
        return rutOpt;
    }


    void iObtenirRutaMinimaAmbSecundaris(PuntInteres a, PuntIteres b){
        Iterator<PuntInteres> secundNoVisitats = obtenir una sub-llista de secundaris, extraient els PuntInteres que ja pertanyen a la rutaAct.

        while(secundNoVisitats.hasNext()){
            PuntIteres act = secundNoVisitats.next();
            rutaAcst = rutaAct.concatena( algorismeDijkstra(a, act) ); //Enllaça els PI secundaris.
            if(rutaAct.dist > opt.dist) { //Si no pot ser millor, aborta.
                if(secundNoVisitats.hasNext()) { //Si queden secundaris.
                    iObtenirRutaMinimaAmbSecundaris(act, b);
                } else { //No queden secundaris, per tant, s'ha d'enllaçar amb el destí.
                    rutaAct = rutaAct.concatena( algorismeDijkstra(act, b) ); //Enllaça l'ultima PI secundari amb el destí.
                    camiTrobat = true;
                    if(optima.dist < act.dist) //Si la actual és millor que la optima.
                        optima = rutaAct;
                }
                rutaAct.eliminaUltimItem();
            }
        }
    }

}