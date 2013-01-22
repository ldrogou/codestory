/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.laurent.codestory.scalaskel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.laurent.codestory.Controller;
import org.slf4j.Logger;

/**
 *
 * @author DROGOU
 */
public class ScalaskelService {

    // Logger
    Logger logger = org.slf4j.LoggerFactory.getLogger(Controller.class);

    /**
     * M�thode expos� pour la construction de la liste de scalaskel contenant toute les possibilit�s
     * 
     * @param valeur Valeur � traiter
     * @return Liste des possibilit�s
     * @throws IOException 
     */
    public String ecrireJsonScalaskel(int valeur) throws IOException {
        // Init liste et construction des possibilit�s
        List<ScalaskelJson> resultScalaskelJsonList = constructBazQixBarFoo(valeur);

        // Mapper json avec option d'inclusion
        ObjectMapper mapper = new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
        return mapper.writeValueAsString(resultScalaskelJsonList);

    }

    /**
     * 
     * @param value Valeur � traiter pour baz
     * @return 
     */
    private List<ScalaskelJson> constructBazQixBarFoo(int value) {
        //Nombre de boucle � effectuer pour Baz
        int countBaz = getNumberOfChange(value, Scalaskel.Baz);
        //Liste contenant les diff�rentes possibilit�s
        List<ScalaskelJson> resultList = new ArrayList<ScalaskelJson>();
        // Boucle servant � initialiser Scalaskel et mise � jour de Baz
        for (int i = 0; i <= countBaz; i++) {
            constructQixBarFoo(getValue(value, i, Scalaskel.Baz.getValue()), resultList, new ScalaskelJson(0, 0, 0, i));
        }
        return resultList;
    }

    /**
     * 
     * @param value Valeur � traiter pour Qix
     * @param resultList
     * @param result 
     */
    private void constructQixBarFoo(int value, List<ScalaskelJson> resultList, ScalaskelJson result) {
        //Nombre de boucle � effectuer pour Qix
        int countQix = getNumberOfChange(value, Scalaskel.Qix);
        // Boucle servant � initialiser Scalaskel et mise � jour de Qix
        for (int i = 0; i <= countQix; i++) {
            constructBarFoo(getValue(value, i, Scalaskel.Qix.getValue()), resultList, new ScalaskelJson(0, 0, i, result.getBaz()));
        }
    }

    /**
     * 
     * @param value Valeur � traiter pour Bar
     * @param resultList
     * @param resultQixBaz 
     */
    private void constructBarFoo(int value, List<ScalaskelJson> resultList, ScalaskelJson resultQixBaz) {
        //Nombre de boucle � effectuer pour Bar
        int countBar = getNumberOfChange(value, Scalaskel.Bar);
        // Boucle servant � initialiser Scalaskel et mise � jour de Bar
        for (int i = 0; i <= countBar; i++) {
            ScalaskelJson result = new ScalaskelJson(0,i,resultQixBaz.getQix(), resultQixBaz.getBaz());
            result.setFoo(getValue(value,i,Scalaskel.Bar.getValue()));
            //Ajout de l'objet ScalaskelJson � la liste
            resultList.add(result);
        }

    }

    /**
     * Compute the number of change selon the value
     *
     * @param value
     * @param scalaskel
     * @return the number of coins
     */
    private int getNumberOfChange(int value, Scalaskel scalaskel) {
        return value / scalaskel.getValue();
    }
    
    /**
     * 
     * @param value
     * @param compteur
     * @param valueChange
     * @return 
     */
    private int getValue(int value, int compteur, int valueChange){
            return (value - (compteur * valueChange));
    }
 
}
