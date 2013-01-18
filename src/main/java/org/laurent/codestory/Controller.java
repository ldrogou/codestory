package org.laurent.codestory;

import com.google.common.io.CharStreams;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;

public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    Logger logger = org.slf4j.LoggerFactory.getLogger(Controller.class);
    private final static String scalaskel = "/scalaskel/change/";

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
            faireReponseQuestion(response, request.getParameter("q"));
        } else {
            int param = getIdentifiant(question);
            
        }

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String bodyReq = get(request.getInputStream());

        if ("".equals(bodyReq)) {
            logger.error("Probl&egraveme lors de la recup&eacuteration du post");
            // Retourne 400 PB
            response.setStatus(response.SC_GONE);
        } else {
            logger.info(bodyReq);
            // Retourne 201 pour le post avec succes
            response.setStatus(response.SC_CREATED);
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
        String tab[] = path.split("/");
        return Integer.valueOf(tab[tab.length - 1]);
    }

    private void faireReponseQuestion(HttpServletResponse response, String param) {
        if (ListQuestion.RecuEnonce.getValue().equals(formatQuestion(param))) {
            response.setContentType("text/html");
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException ex) {
                logger.error(ex.getMessage());
            }
            out.println("OUI");
            out.close();
        }
    }

    private String formatQuestion(String param){
        return  param != null ? param.replaceAll(" ", "") : "" ;
    }
            
}
