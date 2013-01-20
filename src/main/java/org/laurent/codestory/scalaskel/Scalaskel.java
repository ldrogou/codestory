/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.laurent.codestory.scalaskel;

/**
 *
 * @author Maelle_Iris
 */
public enum Scalaskel implements Comparable<Scalaskel> {

    Foo(1), Bar(7), Qix(11), Baz(21);
    
    private int value;

    private Scalaskel(int value) {
            this.value = value;
    }
    
    public int getValue(){
        return this.value;
    }
    
}
