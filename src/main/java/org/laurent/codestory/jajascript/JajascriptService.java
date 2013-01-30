/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.laurent.codestory.jajascript;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;

/**
 *
 * @author Maelle_Iris
 */
public class JajascriptService {

    // Logger
    Logger logger = org.slf4j.LoggerFactory.getLogger(JajascriptService.class);
    private NavigableSet<Optimize> listOptimize = new TreeSet<Optimize>();

    
//    List<Optimize> listOptimize = new ArrayList<Optimize>();

    public String optimizeJajaScript(String commande) {

        String returnJsonOptimize = "Not Optimize";
        ObjectMapper mapperJajascript = new ObjectMapper(); // can reuse, share globally
        NavigableSet<Jajascript> listJajascript = null;
        try {
            listJajascript = mapperJajascript.readValue(commande, new TypeReference<NavigableSet<Jajascript>>() {
            });
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        // Apres  le tri lstope premier element contient le depart le plus petit et l'arrive le plus grand
        Jajascript jajaForStopWhile = listJajascript.first();

        // boucle sur
        for (Jajascript jajascript : listJajascript) {
            if (jajascript.getDepart() >= jajaForStopWhile.getArrivee()) {
                break;
            }
            // date depart du jajascript a tester
            //nouvelle instance optimize
            List<String> listPath = new ArrayList<String>();
            // optimize temporaire pour les tests
            Optimize optimize = new Optimize();
            optimize.setGain(jajascript.getPrix());
            listPath.add(jajascript.getVol());
            optimize.setPath(listPath);
            listOptimize.add(optimize);
            traitementOptimize(jajascript, optimize, listJajascript.tailSet(jajascript, false));

        }
        try {
            // Mapper json avec option d'inclusion
            ObjectMapper mapperOptimize = new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
            mapperOptimize.setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
            returnJsonOptimize = mapperOptimize.writeValueAsString(listOptimize.pollFirst());

//            returnJsonOptimize = mapperOptimize.writeValueAsString(listOptimize.first());
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(JajascriptService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnJsonOptimize;
    }

    private void traitementOptimize(Jajascript jaja, Optimize optimize, NavigableSet<Jajascript> listJajascript) {

        //Optimize optimizeJajascript = optimize;
        Jajascript jajascriptTemp = jaja;
        Optimize optimizeCopy = getOptimizeTemp(optimize);
        Optimize optimizeTemp = new Optimize();
        Optimize optiAjout;
        // boucle sur les autres jaja pour optimize
        for (Jajascript jajascriptCompareOptimize : listJajascript) {
            if (jaja.getArrivee() <= jajascriptCompareOptimize.getDepart()) {
                if (jajascriptTemp.getDepart() != jajascriptCompareOptimize.getDepart()
                        && jajascriptTemp.getArrivee() <= jajascriptCompareOptimize.getDepart()) {
                    optimizeTemp = getOptimizeTemp(optimizeCopy);
                }
                if (jajascriptTemp.getArrivee() <= jajascriptCompareOptimize.getDepart()
                        && jajascriptTemp.getDepart() < jajascriptCompareOptimize.getDepart()) {
                    optiAjout = getOptimizeTemp(optimizeTemp);
                    optiAjout.add(jajascriptCompareOptimize);
                    optimizeCopy.add(jajascriptCompareOptimize);
                    listOptimize.add(optiAjout);
                    jajascriptTemp = jajascriptCompareOptimize;
                } else if (jajascriptTemp.getDepart() == jajascriptCompareOptimize.getDepart()
                        || jajascriptTemp.getArrivee() >= jajascriptCompareOptimize.getDepart()) {
                    optiAjout = getOptimizeTemp(optimizeTemp);
                    optiAjout.add(jajascriptCompareOptimize);
                    listOptimize.add(optiAjout);
                    traitementOptimize(jajascriptCompareOptimize, optiAjout, listJajascript.tailSet(jajascriptCompareOptimize, false));
                    //jajascriptTemp = jajascriptCompareOptimize;
                }
            }
        }
    }

    private Optimize getOptimizeTemp(Optimize optimizeTraitement) {
        Optimize optimizeOut = new Optimize();
        List<String> listenewstring = new ArrayList<String>();
        listenewstring.addAll(optimizeTraitement.getPath());
        optimizeOut.setGain(optimizeTraitement.getGain());
        optimizeOut.setPath(listenewstring);
        return optimizeOut;
    }
}
