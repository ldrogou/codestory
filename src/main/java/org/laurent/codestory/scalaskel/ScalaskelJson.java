/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.laurent.codestory.scalaskel;

/**
 *
 * @author Maelle_Iris
 */
public class ScalaskelJson {

    private String piece = "";
    
    private int value = 0;

    public ScalaskelJson() {
        
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    private int valueRestant;

    /**
     * Get the value of valueRestant
     *
     * @return the value of valueRestant
     */
    public int getValueRestant() {
        return valueRestant;
    }

    /**
     * Set the value of valueRestant
     *
     * @param valueRestant new value of valueRestant
     */
    public void setValueRestant(int valueRestant) {
        this.valueRestant = valueRestant;
    }

    
    
    public ScalaskelJson getTest(String pieceName, int valueATraiter ){
        piece = Scalaskel.valueOf(pieceName).name();
        value = valueATraiter / Scalaskel.valueOf(pieceName).getValue();
        valueRestant = valueATraiter%Scalaskel.valueOf(pieceName).getValue();
        
        return this;
    }
    
    @Override
    public String toString() {
        return "\"" + piece + "\" : " + value;
    }
    
    
    
    
}
