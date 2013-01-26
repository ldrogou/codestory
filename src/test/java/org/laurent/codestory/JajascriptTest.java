/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.laurent.codestory;

import org.junit.*;
import org.laurent.codestory.jajascript.JajascriptService;

/**
 *
 * @author Maelle_Iris
 */
public class JajascriptTest {
    
    public static final String jajascriptTest1 = "{\"gain\":10,\"path\":[\"AF514\"]}";
    public static final String jajascriptTest2 = "{\"gain\":18,\"path\":[\"MONAD42\",\"LEGACY01\"]}";

    
    public JajascriptTest() {
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
    // TODO add test methods he$re.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void jajascriptServiceTest() {
        JajascriptService jajascriptSrv = new JajascriptService();
        String valueJaja1 = jajascriptSrv.optimizeJajaScript(" [ {\"VOL\": \"AF514\", \"DEPART\":0, \"DUREE\":5, \"PRIX\": 10} ]");
        String valueJaja2 = jajascriptSrv.optimizeJajaScript(" [ {\"VOL\": \"MONAD42\", \"DEPART\": 0, \"DUREE\": 5, \"PRIX\": 10 }, { \"VOL\": \"META18\", \"DEPART\": 3, \"DUREE\": 7, \"PRIX\": 14 },    { \"VOL\": \"LEGACY01\", \"DEPART\": 5, \"DUREE\": 9, \"PRIX\": 8 },    { \"VOL\": \"YAGNI17\", \"DEPART\": 5, \"DUREE\": 9, \"PRIX\": 7 }]");
        
        Assert.assertEquals(jajascriptTest1, valueJaja1);
        Assert.assertEquals(jajascriptTest2, valueJaja2);
        
    }
}
