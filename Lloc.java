import java.time.LocalTime;
import java.util.List;
import java.util.TimeZone;

/**
 * @class Lloc
 * @brief 
 * @details 
 *
 * @author Roger Generoso Masós
 * @version 2017.4.5
 */

public class Lloc{
    String nom;
    Float latitud;
    Float longitud;
    TimeZone zonaHoraria;
    List<Estacio> hubs;

    Lloc(String nomA, Float lat, Float longit, TimeZone zonHoraria){
        nom = nomA;
        latitud = lat;
        longitud = longit;
        zonaHoraria = zonHoraria;
    }

    public void afegirPuntInteres(PuntInteres pi){

    }

    public void afegirEstacio(String nomMitjaTransp, LocalTime duradaTrajecte, Float preu) {
    }
}