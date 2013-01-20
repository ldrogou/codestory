package org.laurent.codestory;

import com.google.common.io.CharStreams;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.laurent.codestory.scalaskel.Scalaskel;
import org.laurent.codestory.scalaskel.ScalaskelComparator;
import org.laurent.codestory.scalaskel.ScalaskelJson;
import org.slf4j.Logger;

public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    Logger logger = org.slf4j.LoggerFactory.getLogger(Controller.class);
    public static int monnaieScalaskelATraiter;
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
            monnaieScalaskelATraiter = getIdentifiant(question);

            List<ScalaskelJson> listNewScal = new ArrayList<ScalaskelJson>();
            List<Scalaskel> listEnumScalaSkel = getListEnumScalaskel();
            int monnaieScalaskelATraiterTotal = monnaieScalaskelATraiter;

            for (Scalaskel sca : listEnumScalaSkel) {
                monnaieScalaskelATraiter = monnaieScalaskelATraiterTotal;
                if (sca.getValue() <= monnaieScalaskelATraiter) {
                    ScalaskelJson json = new ScalaskelJson();
                    for (Scalaskel scalaloop : listEnumScalaSkel) {
                        if (sca.getValue() >= scalaloop.getValue() && monnaieScalaskelATraiter >= scalaloop.getValue()) {

                            switch (scalaloop.getValue()) {
                                case 21:
                                    json.setBaz(monnaieScalaskelATraiter / scalaloop.getValue());
                                    break;
                                case 11:
                                    json.setQix(monnaieScalaskelATraiter / scalaloop.getValue());
                                    break;
                                case 7:
                                    json.setBar(monnaieScalaskelATraiter / scalaloop.getValue());
                                    break;
                                case 1:
                                    json.setFoo(monnaieScalaskelATraiter / scalaloop.getValue());
                                    break;
                            }

                            monnaieScalaskelATraiter = monnaieScalaskelATraiter % scalaloop.getValue();

                        }
                    }
                    listNewScal.add(json);
                }

            }
            ObjectMapper mapper = new ObjectMapper();

            mapper = new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
            mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
            logger.info(mapper.writeValueAsString(listNewScal));
            response.setContentType("application/json");
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException ex) {
                logger.error(ex.getMessage());
            }
            out.println(mapper.writeValueAsString(listNewScal));
            out.close();
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

    private String formatQuestion(String param) {
        return param != null ? param.replaceAll(" ", "") : "";
    }

    public List<Scalaskel> getListEnumScalaskel() {

        List<Scalaskel> maListeMonnaie = new ArrayList<Scalaskel>();
        maListeMonnaie.addAll(Arrays.asList(Scalaskel.values()));
        Collections.sort(maListeMonnaie, new ScalaskelComparator());



        return maListeMonnaie;
    }
}
