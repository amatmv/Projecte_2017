import java.util.Iterator;
import java.util.List;

/**
 * @class PuntInteres
 * @brief És un lloc visitable o un allotjament.
 * @details 
 *
 * @author 
 * @version 2017.4.5
 */

public abstract class PuntInteres {
    //ATRIBUTS
    List<String> caracteristiques;
    


    private List<PuntInteres> connexionsDirectes; ///< Llista de PuntInteres amb el que està connectat el PuntInteres actual.


    public PuntInteres(String nom, Float latitud, Float longitud, String zonaHoraria) {

    }


    //MÈTODES
    Iterator<PuntInteres> obtenirConnexionsDirectes(){
        return connexionsDirectes.iterator();
    }

    
}
