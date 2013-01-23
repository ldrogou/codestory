/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.laurent.codestory;

import org.junit.*;
import static org.junit.Assert.*;
import org.laurent.codestory.utils.Utils;

/**
 *
 * @author Maelle_Iris
 */
public class UtilsTest {
    
    public UtilsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void evaluationMathTest() {
        
        String evaluation1 =  Utils.evaluationMath("1 1");
        String evaluation2 =  Utils.evaluationMath("(2 3)*6");
        String evaluation3 =  Utils.evaluationMath("(9 1)-2*3");
        String evaluation4 =  Utils.evaluationMath("(2 1)/2");
        String evaluation5 =  Utils.evaluationMath("1,5*4");
                
        assertEquals(String.valueOf(2), evaluation1);
        assertEquals(String.valueOf(30), evaluation2);
        assertEquals(String.valueOf(4), evaluation3);
        assertEquals("1,5", evaluation4);
        assertEquals("6", evaluation5);
        
    }
    
    
}
