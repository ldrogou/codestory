/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.laurent.codestory.scalaskel;

import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

/**
 *
 * @author Maelle_Iris
 */
@JsonSerialize(include = Inclusion.NON_DEFAULT)
public class ScalaskelJson implements Serializable{

    //private int foo = 0;
    //private int bar = 0;
    //private int qix = 0; 
    //private int baz = 0;
    private Integer foo = 0;

    /**
     * Get the value of foo
     *
     * @return the value of foo
     */
    public Integer getFoo() {
        return foo;
    }

    /**
     * Set the value of foo
     *
     * @param foo new value of foo
     */
    public void setFoo(Integer foo) {
        this.foo = foo;
    }

    private Integer bar = 0;

    /**
     * Get the value of bar
     *
     * @return the value of bar
     */
    public Integer getBar() {
        return bar;
    }

    /**
     * Set the value of bar
     *
     * @param bar new value of bar
     */
    public void setBar(Integer bar) {
        this.bar = bar;
    }

    private Integer qix = 0;

    /**
     * Get the value of qix
     *
     * @return the value of qix
     */
    public Integer getQix() {
        return qix;
    }

    /**
     * Set the value of qix
     *
     * @param qix new value of qix
     */
    public void setQix(Integer qix) {
        this.qix = qix;
    }

    private Integer baz = 0;

    /**
     * Get the value of baz
     *
     * @return the value of baz
     */
    public Integer getBaz() {
        return baz;
    }

    /**
     * Set the value of baz
     *
     * @param baz new value of baz
     */
    public void setBaz(Integer baz) {
        this.baz = baz;
    }

    public ScalaskelJson() {
    }

    public ScalaskelJson(Integer foo, Integer bar, Integer qix, Integer baz) {
        this.foo = foo;
        this.bar = bar;
        this.qix = qix;
        this.baz = baz;
    }

    @Override
    public String toString() {
        return "{" + "foo=" + foo + ", bar=" + bar + ", qix=" + qix + ", baz=" + baz + '}';
    }

    
    
}
