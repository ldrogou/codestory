/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.laurent.codestory.scalaskel;

import java.util.Comparator;

/**
 *
 * @author Maelle_Iris
 */
public class ScalaskelComparator implements Comparator<Scalaskel> {
   
    @Override
    public int compare(Scalaskel o1, Scalaskel o2) {
        return (o1.getValue()>o2.getValue() ? -1 : (o1.getValue()==o2.getValue() ? 0 : 1));
    }
}
