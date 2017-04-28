import java.time.LocalDate; //https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
import java.time.LocalTime; //https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html
import java.util.Map;

/**
 * @class Visita
 * @brief 
 * @details 
 *
 * @author Amat Martínez Vilà
 * @version 2017.4.5
 */
public class AgendaTransportIndirecte {

    // És un map de dates, que per cada data saps les hores disponibles i per cada hora saps la durada i el preu.
    Map<LocalDate, Map<LocalTime, Pair<LocalTime, Float> > > horaris;
    
    AgendaTransportIndirecte(){

    }



    void afegirNouHorari(LocalDate data, LocalTime hora, Float preu, LocalTime durada){

    }
}
