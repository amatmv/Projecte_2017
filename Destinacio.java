import java.util.List;
import java.util.TimeZone;

/**
 * @class Destinacio
 * @brief 
 * @details 
 *
 * @author Roger Generoso Masós
 * @version 2017.4.5
 */

public class Destinacio extends Lloc
{
    List<PuntInteres> puntsInteres;
    

    Destinacio(String nomA, Float lat, Float longit, TimeZone zonHoraria, List<PuntInteres> pInt){
        super(nomA,lat,longit,zonHoraria);
        puntsInteres = pInt;
    }



}