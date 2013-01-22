package org.laurent.codestory;

import com.google.common.io.CharStreams;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.laurent.codestory.scalaskel.ScalaskelService;
import org.slf4j.Logger;

public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    // Logger
    Logger logger = org.slf4j.LoggerFactory.getLogger(Controller.class);
    // Path enonce1 Scalaskel
    private final static String SCALASKEL = "/scalaskel/change/";

    public Controller() {
        super();
    }

    /*
     * Our code doesn't use any GET requests, so we instead do a POST request
     * which will just list the items we have saved in the database.
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String question = request.getServletPath();

        //question = request.getParameter("q"); 
        if ("/".equals(question)) {
            response.setContentType("text/html");
            faireReponseQuestion(response, request.getParameter("q"), "");
        } else if (question.startsWith(SCALASKEL)) {
            ScalaskelService scalaskelSrv = new ScalaskelService();
            response.setContentType("application/json");
            faireReponseQuestion(response, "", scalaskelSrv.ecrireJsonScalaskel(getIdentifiant(question)));
        }

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String bodyReq = get(request.getInputStream());

        if ("".equals(bodyReq)) {
            logger.error("Probl&egraveme lors de la recup&eacuteration du post");
            // Retourne 400 PB
            response.setStatus(HttpServletResponse.SC_GONE);
        } else {
            logger.info(bodyReq);
            // Retourne 201 pour le post avec succes
            response.setStatus(HttpServletResponse.SC_CREATED);
        }



    }

    private String get(ServletInputStream in) {
        String inputStreamPost = "";
        try {
            inputStreamPost = CharStreams.toString(new InputStreamReader(in, "UTF-8"));
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inputStreamPost;
    }

    private int getIdentifiant(String path) {
        int resultIdentifiant = 0;
        if (path.startsWith(SCALASKEL)) {
            String tab[] = path.split("/");
            resultIdentifiant = Integer.valueOf(tab[tab.length - 1]);
        }
        return resultIdentifiant;

    }

    private void faireReponseQuestion(HttpServletResponse response, String param, String ecrireDansResponse) {
        if (ListQuestion.RecuEnonce.getValue().equals(formatQuestion(param))) {
            ecrireDansResponse = "OUI";
        }else {
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

    private String evaluationMath(String param){
        String evaluation = "";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByMimeType("text/javascript");
        try {
            if ((Boolean)engine.eval(param)){
                evaluation = (String) engine.eval(param);
            }
        } catch (ScriptException ex) {
           evaluation = "KO";
        }
        return evaluation;
    }
    
    private String formatQuestion(String param) {
        return param != null ? param.replaceAll(" ", "") : "";
    }

    
}
