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
    private long gain;

    /**
     * Get the value of gain
     *
     * @return the value of gain
     */
    public long getGain() {
        return gain;
    }

    /**
     * Set the value of gain
     *
     * @param gain new value of gain
     */
    public void setGain(long gain) {
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

    public Optimize() {
    }

    @Override
    public int compareTo(Optimize o) {
        // une version complete de cette methode
        // doit gerer le cas ou nom et prenom sont nuls
        return (getGain() > o.getGain() ? -1 : (getGain() == o.getGain() ? 0 : 1));
    }

    @Override
    public String toString() {
        return "{" + "gain=" + gain + ", path=" + path + '}';
    }
    
    
}
