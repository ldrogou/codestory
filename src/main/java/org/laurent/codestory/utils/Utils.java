/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.laurent.codestory.utils;

import com.google.common.io.CharStreams;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.logging.Level;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletResponse;
import org.laurent.codestory.Controller;
import org.laurent.codestory.ListQuestion;
import org.slf4j.Logger;

/**
 *
 * @author Maelle_Iris
 */
public class Utils {

    // Logger
    static Logger logger = org.slf4j.LoggerFactory.getLogger(Utils.class);
    // Path enonce1 Scalaskel
    public final static String SCALASKEL = "/scalaskel/change/";

    public static String evaluationMath(String param) {

        Calculable calc;
        BigDecimal result = new BigDecimal(BigInteger.ZERO);
        try {
            calc = new ExpressionBuilder(param.replaceAll(" ", "+").replaceAll(",", "\\.")).build();
            result = new BigDecimal(calc.calculate(), MathContext.UNLIMITED);
        } catch (UnknownFunctionException ex) {
            java.util.logging.Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnparsableExpressionException ex) {
            java.util.logging.Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result.toString().replaceAll("\\.", ",");
    }

    public static String formatQuestion(String param) {
        return param != null ? param.replaceAll(" ", "") : "";
    }

    public static String get(ServletInputStream in) {
        String inputStreamPost = "";
        try {
            inputStreamPost = CharStreams.toString(new InputStreamReader(in, "UTF-8"));
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inputStreamPost;
    }

    public static int getIdentifiant(String path) {
        int resultIdentifiant = 0;
        if (path.startsWith(SCALASKEL)) {
            String tab[] = path.split("/");
            resultIdentifiant = Integer.valueOf(tab[tab.length - 1]);
        }
        return resultIdentifiant;

    }

    /**
     * Traite les question en get "q="
     *
     * @param response
     * @param param
     */
    public static void faireReponseQuestion(HttpServletResponse response, String param, String ecrireDansResponse) {
        if (ListQuestion.recuEnonce.getValue().equals(formatQuestion(param)) || 
                ListQuestion.participation.getValue().equals(formatQuestion(param)) ||
                ListQuestion.mailing.getValue().equals(formatQuestion(param)) ||
                ListQuestion.enonce1.getValue().equals(formatQuestion(param)) ) {
            ecrireDansResponse = "OUI";
        } else if (ListQuestion.eMail.getValue().equals(formatQuestion(param))) {
            ecrireDansResponse = "ldrogou@gmail.com";
        } else {
            ecrireDansResponse = evaluationMath(param);
        }

        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
        out.println(ecrireDansResponse);
        out.close();
    }
}
