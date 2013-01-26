/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.laurent.codestory.jajascript;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author Maelle_Iris
 */
public class Jajascript implements Comparable<Jajascript> {

    @JsonProperty("VOL")
    private String vol;

    /**
     * Get the value of vol
     *
     * @return the value of vol
     */
    public String getVol() {
        return vol;
    }

    /**
     * Set the value of vol
     *
     * @param vol new value of vol
     */
    public void setVol(String vol) {
        this.vol = vol;
    }

    @JsonProperty("DEPART")
    private long depart;

    /**
     * Get the value of depart
     *
     * @return the value of depart
     */
    public long getDepart() {
        return depart;
    }

    /**
     * Set the value of depart
     *
     * @param depart new value of depart
     */
    public void setDepart(long depart) {
        this.depart = depart;
    }

    @JsonProperty("DUREE")
    private long duree;

    /**
     * Get the value of duree
     *
     * @return the value of duree
     */
    public long getDuree() {
        return duree;
    }

    /**
     * Set the value of duree
     *
     * @param duree new value of duree
     */
    public void setDuree(long duree) {
        this.duree = duree;
    }

    @JsonProperty("PRIX")
    private long prix;

    /**
     * Get the value of prix
     *
     * @return the value of prix
     */
    public long getPrix() {
        return prix;
    }

    /**
     * Set the value of prix
     *
     * @param prix new value of prix
     */
    public void setPrix(long prix) {
        this.prix = prix;
    }


    private long arrivee;

    /**
     * Get the value of arrivee
     *
     * @return the value of arrivee
     */
    public long getArrivee() {
        return arrivee;
    }

    /**
     * Set the value of arrivee
     *
     * @param arrivee new value of arrivee
     */
    public void setArrivee(long arrivee) {
        this.arrivee = arrivee;
    }
    
    public final void calcArrivee(long depart, long duree){
        setArrivee(depart + duree);
    }

    public Jajascript() {
        this.vol = "";
        this.depart = 0;
        this.duree = 0;
        this.prix = 0;
        this.arrivee = 0;
    }

    @JsonCreator
    public Jajascript(@JsonProperty("VOL")String vol, @JsonProperty("DEPART")long depart, @JsonProperty("DUREE")long duree, @JsonProperty("PRIX")long prix) {
        this.vol = vol;
        this.depart = depart;
        this.duree = duree;
        this.prix = prix;
        calcArrivee(depart, duree);
    }

    @Override
    public String toString() {
        return "Jajascript{" + "vol=" + vol + ", depart=" + depart + ", duree=" + duree + ", prix=" + prix + ", arrivee=" + arrivee + '}';
    }

    @Override
    public int compareTo(Jajascript j) {
        return (getDepart()>j.getDepart() ? -1 : (getDepart()==j.getDepart() ? 0 : 1));
    }
    
    
    
    
    
    
    
    
}
