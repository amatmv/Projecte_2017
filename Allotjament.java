import java.util.List;

/**
 * @class Allotjament
 * @brief 
 * @details 
 *
 * @author 
 * @version 2017.4.5
 */

public class Allotjament extends PuntInteres{

    String categoria;
    Float preuHabitacioDoble;
    List<String> caracteristiques;

    Allotjament(String nom, Float latitud, Float longitud, String zonaHoraria, String cat, Float preuHabDoble, List<String> carac){
        super(nom, latitud, longitud, zonaHoraria);
        categoria = cat;
        preuHabitacioDoble = preuHabDoble;
        caracteristiques = carac;
    }

}