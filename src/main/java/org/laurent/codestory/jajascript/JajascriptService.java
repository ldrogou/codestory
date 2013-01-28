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
//    SortedSet<Optimize> listOptimize1 = new TreeSet<Optimize>();
//    List<Optimize> listOptimize = new ArrayList<Optimize>();
    SortedSet<Optimize> listOptimize = new TreeSet<Optimize>();

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

        // boucle sur
        for (Jajascript jajascript : listJajascript) {
            // date depart du jajascript a tester
            //nouvelle instance optimize
            List<String> listPath = new ArrayList<String>();
            // optimize temporaire pour les tests
            Optimize optimize = new Optimize();
            optimize.setGain(jajascript.getPrix());
            listPath.add(jajascript.getVol());
            optimize.setPath(listPath);
            listOptimize.add(optimize);
            traitementOptimize(jajascript, optimize, listJajascript);

        }

        // Mapper json avec option d'inclusion
        ObjectMapper mapperOptimize = new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);

        mapperOptimize.setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);

        // Iterating over the elements in the set
        List<Optimize> listOptimize1 = new LinkedList<Optimize>();
        Iterator<Optimize> it = listOptimize.iterator();
        while (it.hasNext()) {

            // Get element
            Optimize element = it.next();
            listOptimize1.add(element);
        }

        Collections.sort(listOptimize1);
        try {
            returnJsonOptimize = mapperOptimize.writeValueAsString(listOptimize1.get(0));

//            returnJsonOptimize = mapperOptimize.writeValueAsString(listOptimize.first());
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(JajascriptService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnJsonOptimize;
    }

    private void traitementOptimize(Jajascript jaja, Optimize optimize, List<Jajascript> listJajascript) {

        //Optimize optimizeJajascript = optimize;
        Jajascript jajascriptTemp = jaja;
        Optimize optimizeTraitement = optimize;
        Optimize optimizeTemp = new Optimize();
        // boucle sur les autres jaja pour optimize
        for (Jajascript jajascriptCompareOptimize : listJajascript) {
            if (jaja.getArrivee() <= jajascriptCompareOptimize.getDepart()) {
                if (jajascriptTemp.getDepart() != jajascriptCompareOptimize.getDepart() && jajascriptTemp.getArrivee() <= jajascriptCompareOptimize.getDepart()) {
                    List<String> listenewstring = new ArrayList<String>();
                    listenewstring.addAll(optimizeTraitement.getPath());
                    optimizeTemp.setGain(optimizeTraitement.getGain());
                    optimizeTemp.setPath(listenewstring);
                }
                if (jajascriptTemp.getArrivee() <= jajascriptCompareOptimize.getDepart() && jajascriptTemp.getDepart() < jajascriptCompareOptimize.getDepart()) {
                    optimizeTraitement.setGain(optimizeTraitement.getGain() + jajascriptCompareOptimize.getPrix());
                    optimizeTraitement.addPath(jajascriptCompareOptimize.getVol());
                    listOptimize.add(optimizeTraitement);
                    jajascriptTemp = jajascriptCompareOptimize;
                } else if (jajascriptTemp.getDepart() == jajascriptCompareOptimize.getDepart() || (jajascriptTemp.getArrivee() >= jajascriptCompareOptimize.getDepart() && jaja.getArrivee() <= jajascriptCompareOptimize.getDepart())) {
                    List<String> listenewstring = new ArrayList<String>();
                    listenewstring.addAll(optimizeTemp.getPath());
                    Optimize opti = new Optimize();
                    opti.setGain(optimizeTemp.getGain() + jajascriptCompareOptimize.getPrix());
                    opti.setPath(listenewstring);
                    opti.addPath(jajascriptCompareOptimize.getVol());
                    listOptimize.add(opti);
                    traitementOptimize(jajascriptCompareOptimize, opti, listJajascript);

                    //jajascriptTemp = jajascriptCompareOptimize;
                }
            }
        }
    }
}
