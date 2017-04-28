import java.time.LocalTime;
import java.util.List;

/**
 * @class LlocVisitable
 * @brief És un PuntInteres amb diverses activitats.
 * @details Podem visitar-lo i coneixem les activitats que s'hi duen a terme. També sabem seu temps de visita estimat i el preu de la visita.
 *
 * @author 
 * @version 2017.4.5
 */

public class LlocVisitable extends PuntInteres{
    LocalTime duradaVisita; ///< És la durada de la visita en minuts.
    float preuVisita; ///< És el preu de realitzar la visita.
    Horari horariObertura; ///<Horari d'obertura del LlocVisitable (s'hi poden fer visites).

    public LlocVisitable(String nom, Float latitud, Float longitud, String zonaHoraria, LocalTime tempsVisitaRecomanat, Float preu, List<String> carac, Horari nouHorari) {
        super(nom, latitud, longitud, zonaHoraria);
        duradaVisita = tempsVisitaRecomanat;
        preuVisita = preu;
        caracteristiques = carac;
        horariObertura = nouHorari;
    }
}