package org.laurent.codestory;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.laurent.codestory.jajascript.Jajascript;
import org.laurent.codestory.jajascript.JajascriptService;
import org.laurent.codestory.scalaskel.ScalaskelService;
import org.laurent.codestory.utils.Utils;
import org.slf4j.Logger;

public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    // Logger
    Logger logger = org.slf4j.LoggerFactory.getLogger(Controller.class);

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

        String path = request.getServletPath();
        String question = "";
        String ecrireReponse = "";
        if ("/".equals(path)) {
            response.setContentType("text/html");
            question = request.getParameter("q");
        } else if (path.startsWith(Utils.SCALASKEL)) {
            ScalaskelService scalaskelSrv = new ScalaskelService();
            response.setContentType("application/json");
            question = Utils.SCALASKEL;
            ecrireReponse = scalaskelSrv.ecrireJsonScalaskel(Utils.getIdentifiant(path));
        }
        // Appel de l utilitaire
        if (!"null".equals(question) && !"".equals(question) && question != null) {
            Utils.faireReponseQuestion(response, question, ecrireReponse);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // body de la request
        String bodyReq = Utils.get(request.getInputStream());
        // Path de la requete post
        String path = request.getServletPath();

        //Ecrire la reponse
        String ecrireReponse = "";
        if ("".equals(bodyReq)) {
            logger.error("Probl&egraveme lors de la recup&eacuteration du post");
            // Retourne 400 PB
            response.setStatus(HttpServletResponse.SC_GONE);
        } else if (Utils.JAJASCRIPT.contains(path)) {
            JajascriptService jajascriptSrv = new JajascriptService();
            logger.info(bodyReq);
            // contenu du traitement
            response.setContentType("application/json");
            // Retourne 201 pour le post avec succes
            response.setStatus(HttpServletResponse.SC_CREATED);

            ecrireReponse = jajascriptSrv.optimizeJajaScript(bodyReq);
        } else {
            logger.info(bodyReq);
            // Retourne 201 pour le post avec succes
            response.setStatus(HttpServletResponse.SC_CREATED);
        }
        // Ecriture de la reponse
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
        out.println(ecrireReponse);
        out.close();

    }
}
