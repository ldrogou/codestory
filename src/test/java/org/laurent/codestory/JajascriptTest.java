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
    public static final String jajascriptTest3 = "{\"gain\":12,\"path\":[\"AF1\",\"AF3\",\"AF2\"]}";

    
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
        String valueJaja2 = jajascriptSrv.optimizeJajaScript(" [ {\"VOL\": \"YAGNI17\", \"DEPART\": 5, \"DUREE\": 9, \"PRIX\": 7 }, { \"VOL\": \"META18\", \"DEPART\": 3, \"DUREE\": 7, \"PRIX\": 14 },    { \"VOL\": \"LEGACY01\", \"DEPART\": 5, \"DUREE\": 9, \"PRIX\": 8 }, {\"VOL\": \"MONAD42\", \"DEPART\": 0, \"DUREE\": 5, \"PRIX\": 10 }]");
        String valueJaja3 = jajascriptSrv.optimizeJajaScript("[ {\"VOL\": \"AF1\", \"DEPART\":0, \"DUREE\":1, \"PRIX\": 2}, {\"VOL\": \"AF2\", \"DEPART\":4, \"DUREE\":1, \"PRIX\": 4}, {\"VOL\": \"AF3\", \"DEPART\":2, \"DUREE\":1, \"PRIX\": 6} ]");
        Assert.assertEquals(jajascriptTest1, valueJaja1);
        Assert.assertEquals(jajascriptTest2, valueJaja2);
        Assert.assertEquals(jajascriptTest3, valueJaja3);
        
    }
}
