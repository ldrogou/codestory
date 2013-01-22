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
        
        int evaluation1 = (Integer) Utils.evaluationMath("1+1");
        int evaluation2 = (Integer) Utils.evaluationMath("(2+3)*6");
        int evaluation3 = (Integer) Utils.evaluationMath("(9+1)-2*3");
        
        assertEquals(2, evaluation1);
        assertEquals(30, evaluation2);
        assertEquals(4, evaluation3);
    }
    
    
}
