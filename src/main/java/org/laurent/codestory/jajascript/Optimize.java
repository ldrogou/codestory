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
public class Optimize implements Comparable<Optimize>, Cloneable {

    @JsonProperty("gain")
    private int gain;

    public int getGain() {
        return gain;
    }

    public void setGain(int gain) {
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
     *
     * @param addPath
     */
    public void addPath(String addPath) {
        this.path.add(addPath);
    }

    /**
     * Retire un element de la liste
     *
     * @param removePath
     */
    public void removePath(String removePath) {
        this.path.remove(removePath);
    }

    public Optimize add(Jajascript jajascript) {
        this.setGain(getGain() + jajascript.getPrix());
        this.addPath(jajascript.getVol());
        return this;
    }

    public Optimize(int gain) {
        this.gain = gain;
    }

    public Optimize() {
    }

    @Override
    public int compareTo(Optimize o) {
        int retour;
        // une version complete de cette methode
        // doit gerer le cas ou nom et prenom sont nuls
        if (o == null) {
            retour = 0;
        } else {
            retour = o.getGain() - this.gain;
        }
        return retour;
    }

    @Override
    public String toString() {
        return "{" + "gain=" + gain + ", path=" + path + '}';
    }

    @Override
    public int hashCode() {
        return this.gain;
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
        if (this.gain != other.gain) {
            return false;
        }


        return true;
    }

    @Override
    public Optimize clone() {
        Optimize o = null;
        try {
            // On recupere l instance a renvoyer par l appel de la 
            // methode super.clone()
            o = (Optimize) super.clone();
        } catch (CloneNotSupportedException cnse) {
            // Ne devrait jamais arriver car nous implementons 
            // l interface Cloneable
            cnse.printStackTrace(System.err);
        }
        // on renvoie le clone
        return o;
    }
}
