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
    public static final String jajascriptTest4 = "{\"gain\":24,\"path\":[\"crowded-spoon-1\",\"beautiful-school-29\"]}";
    public static final String jajascriptTest5 = "{\"gain\":58,\"path\":[\"cautious-metropolitan-12\",\"high-tutu-72\",\"light-arm-24\",\"wild-wreckage-2\"]}";

    
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
        JajascriptService jajascriptSrv1 = new JajascriptService();
        String valueJaja1 = jajascriptSrv1.optimizeJajaScript(" [ {\"VOL\": \"AF514\", \"DEPART\":0, \"DUREE\":5, \"PRIX\": 10} ]");
        JajascriptService jajascriptSrv2 = new JajascriptService();
        String valueJaja2 = jajascriptSrv2.optimizeJajaScript(" [ {\"VOL\": \"YAGNI17\", \"DEPART\": 5, \"DUREE\": 9, \"PRIX\": 7 }, { \"VOL\": \"META18\", \"DEPART\": 3, \"DUREE\": 7, \"PRIX\": 14 },    { \"VOL\": \"LEGACY01\", \"DEPART\": 5, \"DUREE\": 9, \"PRIX\": 8 }, {\"VOL\": \"MONAD42\", \"DEPART\": 0, \"DUREE\": 5, \"PRIX\": 10 }]");
        JajascriptService jajascriptSrv3 = new JajascriptService();
        String valueJaja3 = jajascriptSrv3.optimizeJajaScript("[ {\"VOL\": \"AF1\", \"DEPART\":0, \"DUREE\":1, \"PRIX\": 2}, {\"VOL\": \"AF2\", \"DEPART\":4, \"DUREE\":1, \"PRIX\": 4}, {\"VOL\": \"AF3\", \"DEPART\":2, \"DUREE\":1, \"PRIX\": 6} ]");
        JajascriptService jajascriptSrv4 = new JajascriptService();
        String valueJaja4 = jajascriptSrv4.optimizeJajaScript("[{ \"VOL\": \"melodic-snack-37\", \"DEPART\": 3, \"DUREE\": 7, \"PRIX\": 19 }, { \"VOL\": \"relieved-lump-97\", \"DEPART\": 1, \"DUREE\": 9, \"PRIX\": 7 }, { \"VOL\": \"beautiful-martini-62\", \"DEPART\": 1, \"DUREE\": 9, \"PRIX\": 4 }, { \"VOL\": \"crowded-spoon-1\", \"DEPART\": 3, \"DUREE\": 1, \"PRIX\": 10 }, { \"VOL\": \"energetic-colt-46\", \"DEPART\": 1, \"DUREE\": 15, \"PRIX\": 1 }, { \"VOL\": \"melodic-snail-87\", \"DEPART\": 5, \"DUREE\": 5, \"PRIX\": 1 }, { \"VOL\": \"teeny-codfish-84\", \"DEPART\": 7, \"DUREE\": 6, \"PRIX\": 9 }, { \"VOL\": \"tired-motorcyclist-51\", \"DEPART\": 8, \"DUREE\": 1, \"PRIX\": 3 }, { \"VOL\": \"beautiful-school-29\", \"DEPART\": 5, \"DUREE\": 4, \"PRIX\": 14 }, { \"VOL\": \"disgusted-fisherman-90\", \"DEPART\": 5, \"DUREE\": 20, \"PRIX\": 3 } ]");
        JajascriptService jajascriptSrv5 = new JajascriptService();
        String valueJaja5 = jajascriptSrv5.optimizeJajaScript("[ { \"VOL\": \"cautious-metropolitan-12\", \"DEPART\": 1, \"DUREE\": 1, \"PRIX\": 25 }, { \"VOL\": \"light-arm-24\", \"DEPART\": 4, \"DUREE\": 4, \"PRIX\": 16 }, { \"VOL\": \"high-tutu-72\", \"DEPART\": 3, \"DUREE\": 1, \"PRIX\": 2 }, { \"VOL\": \"distinct-lumberyard-40\", \"DEPART\": 0, \"DUREE\": 8, \"PRIX\": 8 }, { \"VOL\": \"lonely-puddle-16\", \"DEPART\": 2, \"DUREE\": 4, \"PRIX\": 2 }, { \"VOL\": \"thundering-cardboard-97\", \"DEPART\": 5, \"DUREE\": 8, \"PRIX\": 24 }, { \"VOL\": \"fine-slacker-70\", \"DEPART\": 5, \"DUREE\": 8, \"PRIX\": 10 }, { \"VOL\": \"excited-witticism-91\", \"DEPART\": 7, \"DUREE\": 2, \"PRIX\": 5 }, { \"VOL\": \"wild-wreckage-2\", \"DEPART\": 8, \"DUREE\": 4, \"PRIX\": 15 }, { \"VOL\": \"lucky-faun-69\", \"DEPART\": 5, \"DUREE\": 17, \"PRIX\": 5 } ]");       
        
        Assert.assertEquals(jajascriptTest1, valueJaja1);
        Assert.assertEquals(jajascriptTest2, valueJaja2);
        Assert.assertEquals(jajascriptTest3, valueJaja3);
        Assert.assertEquals(jajascriptTest4, valueJaja4);
        Assert.assertEquals(jajascriptTest5, valueJaja5);
        
        
    }
}
