/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.laurent.codestory.jajascript;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author Maelle_Iris
 */
public class Optimize implements Comparable<Optimize> {

    @JsonProperty("gain")
     private Long gain;

    /**
     * Get the value of gain
     *
     * @return the value of gain
     */
    public Long getGain() {
        return gain;
    }

    /**
     * Set the value of gain
     *
     * @param gain new value of gain
     */
    public void setGain(Long gain) {
        this.gain = gain;
    }

    
    @JsonProperty("path")
    private List<String> path;

    /**
     * Get the value of path
     *
     * @return the value of path
     */
    public List<String> getPath() {
        return path;
    }

    /**
     * Set the value of path
     *
     * @param path new value of path
     */
    public void setPath(List<String> path) {
        this.path = path;
    }
    
    /**
     * Ajoute un element dans la liste
     * @param addPath 
     */
    public void addPath(String addPath){
        this.path.add(addPath);
    }
    
    /**
     *  Retire un element de la liste
     * @param removePath 
     */
    public void removePath(String removePath){
        this.path.remove(removePath);
    }
    
    public Optimize add(Jajascript jajascript){
        this.setGain(getGain() + jajascript.getPrix());
        this.addPath(jajascript.getVol());
        return this;
    }

    public Optimize(long gain) {
        this.gain = gain;
    }

    public Optimize() {
    }

    

    
    @Override
    public int compareTo(Optimize o) {
        int retour;
        // une version complete de cette methode
        // doit gerer le cas ou nom et prenom sont nuls
        if (o == null){
            retour = 0;
        }else {
            retour = o.getGain().compareTo(getGain());
        }
        return retour;
    }

    @Override
    public String toString() {
        return "{" + "gain=" + gain + ", path=" + path + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.gain != null ? this.gain.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Optimize other = (Optimize) obj;
        if (this.gain != other.gain && (this.gain == null || !this.gain.equals(other.gain))) {
            return false;
        }
        
        for(int i=0; i<=path.size(); i++){
            if (!path.get(i).equals(other.path.get(i))){
                return false;
            }
        }
        return true;
    }

    

    
    
    
    
    
}
