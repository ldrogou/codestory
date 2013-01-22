package org.laurent.codestory;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import org.laurent.codestory.scalaskel.ScalaskelService;

public class ScalaskelTest {

    public static final String scalaskelTest1 = "[{\"foo\":1}]";
    public static final String scalaskelTest7 = "[{\"foo\":7},{\"bar\":1}]";
    public static final String scalaskelTest22 = "[{\"foo\":22},"
            + "{\"foo\":15,\"bar\":1},"
            + "{\"foo\":8,\"bar\":2},"
            + "{\"foo\":1,\"bar\":3},"
            + "{\"foo\":11,\"qix\":1},"
            + "{\"foo\":4,\"bar\":1,\"qix\":1},"
            + "{\"qix\":2},"
            + "{\"foo\":1,\"baz\":1}]";
        
    @Test
    public void testChangeScalaskel() throws IOException {
        
        ScalaskelService scalaskelSrv = new ScalaskelService();
        String valueSca1 = scalaskelSrv.ecrireJsonScalaskel(1);
        String valueSca7 = scalaskelSrv.ecrireJsonScalaskel(7);
        String valueSca22 = scalaskelSrv.ecrireJsonScalaskel(22);
        
        Assert.assertEquals(scalaskelTest1, valueSca1);
        Assert.assertEquals(scalaskelTest7, valueSca7);
        Assert.assertEquals(scalaskelTest22, valueSca22);
        
    }
} 