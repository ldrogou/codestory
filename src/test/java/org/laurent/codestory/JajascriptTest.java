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
//        JajascriptService jajascriptSrv6 = new JajascriptService();
//        String valueJaja6 = jajascriptSrv6.optimizeJajaScript("[ { \"VOL\": \"excited-roadside-65\", \"DEPART\": 2, \"DUREE\": 7, \"PRIX\": 22 }, { \"VOL\": \"hilarious-farm-97\", \"DEPART\": 0, \"DUREE\": 10, \"PRIX\": 18 }, { \"VOL\": \"proud-grime-3\", \"DEPART\": 2, \"DUREE\": 6, \"PRIX\": 2 }, { \"VOL\": \"mysterious-mouser-91\", \"DEPART\": 0, \"DUREE\": 4, \"PRIX\": 14 }, { \"VOL\": \"high-skillet-77\", \"DEPART\": 2, \"DUREE\": 3, \"PRIX\": 1 }, { \"VOL\": \"condemned-ax-35\", \"DEPART\": 7, \"DUREE\": 9, \"PRIX\": 26 }, { \"VOL\": \"glorious-connection-83\", \"DEPART\": 9, \"DUREE\": 5, \"PRIX\": 7 }, { \"VOL\": \"ancient-reporter-93\", \"DEPART\": 9, \"DUREE\": 9, \"PRIX\": 9 }, { \"VOL\": \"kind-farming-3\", \"DEPART\": 7, \"DUREE\": 6, \"PRIX\": 15 }, { \"VOL\": \"splendid-fruitcake-74\", \"DEPART\": 5, \"DUREE\": 4, \"PRIX\": 2 }, { \"VOL\": \"healthy-steamroller-17\", \"DEPART\": 10, \"DUREE\": 4, \"PRIX\": 27 }, { \"VOL\": \"huge-stethoscope-15\", \"DEPART\": 14, \"DUREE\": 5, \"PRIX\": 10 }, { \"VOL\": \"naughty-southerner-76\", \"DEPART\": 13, \"DUREE\": 5, \"PRIX\": 8 }, { \"VOL\": \"dull-peddler-38\", \"DEPART\": 13, \"DUREE\": 9, \"PRIX\": 8 }, { \"VOL\": \"noisy-trout-46\", \"DEPART\": 14, \"DUREE\": 1, \"PRIX\": 6 }, { \"VOL\": \"zany-maroon-88\", \"DEPART\": 15, \"DUREE\": 8, \"PRIX\": 21 }, { \"VOL\": \"homeless-thermodynamics-25\", \"DEPART\": 18, \"DUREE\": 8, \"PRIX\": 8 }, { \"VOL\": \"fat-wig-8\", \"DEPART\": 19, \"DUREE\": 3, \"PRIX\": 8 }, { \"VOL\": \"foolish-stain-66\", \"DEPART\": 15, \"DUREE\": 9, \"PRIX\": 11 }, { \"VOL\": \"old-bobcat-52\", \"DEPART\": 17, \"DUREE\": 14, \"PRIX\": 2 }, { \"VOL\": \"curved-sunglasses-87\", \"DEPART\": 24, \"DUREE\": 5, \"PRIX\": 10 }, { \"VOL\": \"beautiful-thermos-17\", \"DEPART\": 20, \"DUREE\": 3, \"PRIX\": 20 }, { \"VOL\": \"worried-keynote-43\", \"DEPART\": 22, \"DUREE\": 8, \"PRIX\": 2 }, { \"VOL\": \"horrible-looter-42\", \"DEPART\": 23, \"DUREE\": 6, \"PRIX\": 13 }, { \"VOL\": \"ugly-seascape-78\", \"DEPART\": 23, \"DUREE\": 5, \"PRIX\": 5 }, { \"VOL\": \"stupid-zucchini-39\", \"DEPART\": 25, \"DUREE\": 4, \"PRIX\": 23 }, { \"VOL\": \"sparkling-springboard-83\", \"DEPART\": 27, \"DUREE\": 4, \"PRIX\": 16 }, { \"VOL\": \"kind-brain-15\", \"DEPART\": 29, \"DUREE\": 4, \"PRIX\": 10 }, { \"VOL\": \"zealous-nest-33\", \"DEPART\": 27, \"DUREE\": 2, \"PRIX\": 10 }, { \"VOL\": \"adventurous-gnu-84\", \"DEPART\": 28, \"DUREE\": 10, \"PRIX\": 6 }, { \"VOL\": \"crooked-rummy-97\", \"DEPART\": 31, \"DUREE\": 8, \"PRIX\": 10 }, { \"VOL\": \"excited-month-50\", \"DEPART\": 34, \"DUREE\": 1, \"PRIX\": 21 }, { \"VOL\": \"whispering-alphabet-20\", \"DEPART\": 30, \"DUREE\": 4, \"PRIX\": 5 }, { \"VOL\": \"impossible-vehemence-22\", \"DEPART\": 33, \"DUREE\": 1, \"PRIX\": 6 }, { \"VOL\": \"confused-silencer-47\", \"DEPART\": 30, \"DUREE\": 9, \"PRIX\": 3 }, { \"VOL\": \"zealous-turtleneck-50\", \"DEPART\": 38, \"DUREE\": 7, \"PRIX\": 21 }, { \"VOL\": \"fine-screwball-57\", \"DEPART\": 39, \"DUREE\": 7, \"PRIX\": 21 }, { \"VOL\": \"mysterious-shipwreck-67\", \"DEPART\": 39, \"DUREE\": 9, \"PRIX\": 1 }, { \"VOL\": \"witty-cotton-10\", \"DEPART\": 37, \"DUREE\": 5, \"PRIX\": 7 }, { \"VOL\": \"anxious-sap-23\", \"DEPART\": 38, \"DUREE\": 11, \"PRIX\": 1 }, { \"VOL\": \"grieving-graphic-70\", \"DEPART\": 43, \"DUREE\": 1, \"PRIX\": 21 }, { \"VOL\": \"bewildered-fastfood-33\", \"DEPART\": 42, \"DUREE\": 8, \"PRIX\": 7 }, { \"VOL\": \"quiet-cerebellum-24\", \"DEPART\": 41, \"DUREE\": 1, \"PRIX\": 6 }, { \"VOL\": \"silent-sidewalk-61\", \"DEPART\": 43, \"DUREE\": 3, \"PRIX\": 14 }, { \"VOL\": \"wicked-bartender-79\", \"DEPART\": 40, \"DUREE\": 18, \"PRIX\": 3 }, { \"VOL\": \"silly-sparrow-32\", \"DEPART\": 49, \"DUREE\": 2, \"PRIX\": 10 }, { \"VOL\": \"fast-truck-2\", \"DEPART\": 47, \"DUREE\": 8, \"PRIX\": 22 }, { \"VOL\": \"uninterested-bass-24\", \"DEPART\": 45, \"DUREE\": 6, \"PRIX\": 8 }, { \"VOL\": \"short-mimosa-98\", \"DEPART\": 46, \"DUREE\": 5, \"PRIX\": 12 }, { \"VOL\": \"bad-luck-52\", \"DEPART\": 49, \"DUREE\": 11, \"PRIX\": 6 }, { \"VOL\": \"shiny-bedpan-23\", \"DEPART\": 52, \"DUREE\": 1, \"PRIX\": 18 }, { \"VOL\": \"dull-watchband-79\", \"DEPART\": 50, \"DUREE\": 1, \"PRIX\": 7 }, { \"VOL\": \"busy-dish-33\", \"DEPART\": 52, \"DUREE\": 4, \"PRIX\": 6 }, { \"VOL\": \"expensive-cat-95\", \"DEPART\": 50, \"DUREE\": 9, \"PRIX\": 9 }, { \"VOL\": \"fine-beast-91\", \"DEPART\": 53, \"DUREE\": 18, \"PRIX\": 2 }, { \"VOL\": \"pleasant-liposuction-96\", \"DEPART\": 58, \"DUREE\": 9, \"PRIX\": 18 }, { \"VOL\": \"horrible-jacket-29\", \"DEPART\": 55, \"DUREE\": 8, \"PRIX\": 10 }, { \"VOL\": \"elegant-termite-14\", \"DEPART\": 55, \"DUREE\": 2, \"PRIX\": 2 }, { \"VOL\": \"naughty-butterfly-63\", \"DEPART\": 55, \"DUREE\": 5, \"PRIX\": 9 }, { \"VOL\": \"fragile-laser-82\", \"DEPART\": 58, \"DUREE\": 4, \"PRIX\": 5 }, { \"VOL\": \"successful-mimosa-47\", \"DEPART\": 61, \"DUREE\": 3, \"PRIX\": 7 }, { \"VOL\": \"lucky-pumice-83\", \"DEPART\": 63, \"DUREE\": 1, \"PRIX\": 12 }, { \"VOL\": \"black-ripoff-59\", \"DEPART\": 64, \"DUREE\": 6, \"PRIX\": 4 }, { \"VOL\": \"black-judo-59\", \"DEPART\": 62, \"DUREE\": 7, \"PRIX\": 12 }, { \"VOL\": \"fancy-sampler-2\", \"DEPART\": 61, \"DUREE\": 16, \"PRIX\": 5 }, { \"VOL\": \"jolly-poplin-36\", \"DEPART\": 67, \"DUREE\": 4, \"PRIX\": 28 }, { \"VOL\": \"distinct-stick-59\", \"DEPART\": 68, \"DUREE\": 1, \"PRIX\": 20 }, { \"VOL\": \"hurt-overlord-23\", \"DEPART\": 66, \"DUREE\": 2, \"PRIX\": 9 }, { \"VOL\": \"steep-form-38\", \"DEPART\": 68, \"DUREE\": 3, \"PRIX\": 11 }, { \"VOL\": \"poised-somebody-3\", \"DEPART\": 65, \"DUREE\": 6, \"PRIX\": 1 }, { \"VOL\": \"naughty-reactivation-19\", \"DEPART\": 73, \"DUREE\": 4, \"PRIX\": 7 }, { \"VOL\": \"famous-pillar-14\", \"DEPART\": 74, \"DUREE\": 9, \"PRIX\": 19 }, { \"VOL\": \"charming-sifter-72\", \"DEPART\": 73, \"DUREE\": 4, \"PRIX\": 7 }, { \"VOL\": \"dull-riffraff-9\", \"DEPART\": 72, \"DUREE\": 10, \"PRIX\": 9 }, { \"VOL\": \"talented-sesame-6\", \"DEPART\": 73, \"DUREE\": 10, \"PRIX\": 6 } ]");
        
        Assert.assertEquals(jajascriptTest1, valueJaja1);
        Assert.assertEquals(jajascriptTest2, valueJaja2);
        Assert.assertEquals(jajascriptTest3, valueJaja3);
        Assert.assertEquals(jajascriptTest4, valueJaja4);
        Assert.assertEquals(jajascriptTest5, valueJaja5);
//        Assert.assertEquals(jajascriptTest5, valueJaja6);
        
    }
}
