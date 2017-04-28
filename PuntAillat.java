import java.util.TimeZone;

/**
 * @class PuntAillat
 * @brief És un Lloc amb només un PuntInteres
 * @details 
 *
 * @author Roger Generoso Masós
 * @version 2017.4.5
 */

public class PuntAillat extends Lloc {

    PuntInteres puntInt;

    PuntAillat(String nomA, Float lat, Float longit, TimeZone zonHoraria, PuntInteres inter){
        super(nomA,lat,longit,zonHoraria);
        puntInt = inter;
    }
    
}