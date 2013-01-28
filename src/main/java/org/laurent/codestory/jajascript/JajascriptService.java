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
    SortedSet<Optimize> listOptimize = new TreeSet<Optimize>();
//    List<Optimize> listOptimize = new ArrayList<Optimize>();

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

        List<Optimize> listOptimizeResult = new LinkedList<Optimize>();
        Iterator<Optimize> it = listOptimize.iterator();
        while (it.hasNext()) {
            listOptimizeResult.add(it.next());
        }
        Collections.sort(listOptimizeResult);
        try {
            // Mapper json avec option d'inclusion
            ObjectMapper mapperOptimize = new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
            mapperOptimize.setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
            returnJsonOptimize = mapperOptimize.writeValueAsString(listOptimizeResult.get(0));

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
                if (jajascriptTemp.getDepart() != jajascriptCompareOptimize.getDepart()
                        && jajascriptTemp.getArrivee() <= jajascriptCompareOptimize.getDepart()) {
                    optimizeTemp = getOptimizeTemp(optimizeTraitement);
                }
                if (jajascriptTemp.getArrivee() <= jajascriptCompareOptimize.getDepart()
                        && jajascriptTemp.getDepart() < jajascriptCompareOptimize.getDepart()) {
                    optimizeTraitement.add(jajascriptCompareOptimize);
                    listOptimize.add(optimizeTraitement);
                    jajascriptTemp = jajascriptCompareOptimize;
                } else if (jajascriptTemp.getDepart() == jajascriptCompareOptimize.getDepart()
                        || jajascriptTemp.getArrivee() >= jajascriptCompareOptimize.getDepart()) {
                    Optimize opti = getOptimizeTemp(optimizeTemp);
                    opti.add(jajascriptCompareOptimize);
                    listOptimize.add(opti);
                    traitementOptimize(jajascriptCompareOptimize, opti, listJajascript);
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
