
/**
 * @class AlgorismeDijkstra
 * @brief 
 * @details 
 *
 * @author Roger Generoso Masós
 * @version 2017.4.5
 */

public class AlgorismeDijkstra {
    private class InfoDijkstra{
            private PuntInteres PI; ///< És el nom del PuntInteres en questio.
            private double dist; ///< Conté informació respecte la distància acumulada.
            private boolean def; ///< Indica si la informació ja és definitiva.
            private PuntInteres pred; ///< Indica quin és predecessor del PI.

            /**
             * @pre cert
             * @post n és el nom del nou InfoDijkstra.
             */
        InfoDijkstra(PuntInteres n){
            nom = n;
            dist = Double.MAX_VALUE;
            def = false;
            pred = null;
            }
    }


    Ruta obtenirRutaMinima(PuntIteres a, PuntIteres b){
        Map<PuntInteres, InfoDijkstra> dadesAlgorisme;
        InfoDijkstra vertAct = new InfoDijkstra(a);
        vertAct.dist = 0;
        boolean acabar = false;

        while( vertAct!= null && !acabar ){
            vertAct = obtenirPuntInteresDistMin(dadesAlgorisme);
            if(vertAct != null){
                vertAct.def = true;
                if(vertAct.PI == b) acabar = true;
                Iterator<PuntInteres> it = (agencia).obtenirConnexionsDirectesDe(vertAct.PI);
                while(it.hasNext()){
                    PuntInteres vertAdj = it.next();
                    InfoDijkstra adj = buscar(vertAdj);
                    if(adj == null) adj = afegirInfoNode(adj, dadesAlgorisme);

                    double distanciaEntrePI = (agenaia).distanciaEntre(vertAct.PI,vertAdj);
                    if(!adj.def && adj.dist > vertAct.dist + distanciaEntrePI){
                        adj.dist = vertAct.dist + (agenaia).distanciaEntre(vertAct.PI,vertAdj);
                        adj.pred = vertAct.PI;
                    }
                }
            }
        }
        if(acabar) return obtRutaAmbDades(dades, a, b);
        else return null;
    }


    /**
     * @pre dades no és buida.
     * @post Si no existeix retorna null, altrament retorna InfoDijkstra amb el PuntInteres a menor distància (no definitiva) segons dades.
     */
    private InfoDijkstra obtenirPuntInteresDistMin(Map<PuntInteres, InfoDijkstra> dades){
        //Iterar el mapa fins a trobar l'InfoDijkstra amb el menor "dist".
    }


    /**
     * @pre No ha d'existir a dades un InfoDijkstra amb el PuntInteres n
     * @post Crea un nou InfoDijkstra amb el PuntInteres n i l'afegeix a dades.
     */
    private InfoDijkstra afegirInfoNode(PuntInteres n, Map<PuntInteres, InfoDijkstra> dades){
        InfoDijkstra nou = new InfoDijkstra(n);
        dades.put(n, nou);
        return nou;
    }

    /**
     * @pre dades ha de de contenir com a minim dos InfoDijkstra amb els PuntInteres a i b.
     * @post Retorna una ruta entre a i b a partir de les dades.
     */
    private Ruta obtRutaAmbDades(Map<PuntInteres, InfoDijkstra> dades, PuntInteres a, PuntInteres b){
        Ruta cami = new Ruta();
        InfoDijkstra vertAct = buscar(dades, b);
        vertAnt = null;
        while(vertAct != a){
            vertAnt = vertAct;
            vertAct = buscar(dades, vertAct.pred);
            Pair<Double,Transport> parella = (agenaia).obtenirDistanciaTransportEntre(vertAnt.PI, vertAct.PI);
            Desplacament nou = new Desplacament(vertAnt.PI, vertAct.PI, parella);
            cami.afegirARuta(nou);
        }
    }

    /**
     * @pre cert
     * @post Si existeix, retorna la InfoDijkstra de dades que té per PuntInteres act. Altrament null.
     */
    private InfoDijkstra buscar(Map<PuntInteres, InfoDijkstra> dades, PuntInteres act){
        return dades.get(act);
    }

    
}