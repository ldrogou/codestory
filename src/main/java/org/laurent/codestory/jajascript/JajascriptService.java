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

    public String optimizeJajaScript(String commande) {

        String returnJsonOptimize = "Not Optimize";
        ObjectMapper mapperJajascript = new ObjectMapper(); // can reuse, share globally
        List<Jajascript> listJajascript = null;
        try {
            listJajascript = mapperJajascript.readValue(commande, new TypeReference<List<Jajascript>>() {
            });
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        // mise en ordre de la liste sur l heure de depart
        Collections.sort(listJajascript);
        //
        SortedSet<Optimize> listOptimize = new TreeSet<Optimize>();
        // boucle sur
        for (Jajascript jajascript : listJajascript) {
            long newheureArrive;
            // date depart du jajascript a tester
            newheureArrive = jajascript.getArrivee();
            //nouvelle instance optimize
            Optimize optimize = new Optimize();
            optimize.setGain(jajascript.getPrix());
            List<String> listPath = new ArrayList<String>();
            listPath.add(jajascript.getVol());
            // optimize temporaire pour les tests
            Jajascript jajascriptTemp = new Jajascript();
            // boucle sur les autres jaja pour optimize
            for (Jajascript jajascriptCompareOptimize : listJajascript) {
                if (jajascript.getArrivee() <= jajascriptCompareOptimize.getDepart()) {
                    if (newheureArrive <= jajascriptCompareOptimize.getDepart()) {
                        // optimize temporaire pour les tests
                        jajascriptTemp = jajascriptCompareOptimize;
                        newheureArrive = jajascriptCompareOptimize.getArrivee();
                        optimize.setGain(optimize.getGain() + jajascriptCompareOptimize.getPrix());
                        listPath.add(jajascriptCompareOptimize.getVol());
                    } else if (jajascriptTemp.getPrix() < jajascriptCompareOptimize.getPrix()) {
                        newheureArrive = jajascriptTemp.getArrivee();
                        optimize.setGain(optimize.getGain() - jajascriptTemp.getPrix());
                        optimize.setGain(optimize.getGain() + jajascriptCompareOptimize.getPrix());
                        listPath.remove(jajascriptTemp.getVol());
                        listPath.add(jajascriptCompareOptimize.getVol());
                    }
                }
            }
            optimize.setPath(listPath);
            listOptimize.add(optimize);
        }

        // Mapper json avec option d'inclusion
        ObjectMapper mapperOptimize = new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);

        mapperOptimize.setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);


        try {
            returnJsonOptimize = mapperOptimize.writeValueAsString(listOptimize.first());
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(JajascriptService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnJsonOptimize;
    }
}
