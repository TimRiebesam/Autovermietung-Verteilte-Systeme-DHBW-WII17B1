/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.vertsys.javaee.upp.buchung.web;



import dhbwka.wwi.vertsys.javaee.upp.buchung.ejb.BuchungBean;
import dhbwka.wwi.vertsys.javaee.upp.buchung.jpa.Buchung;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcel Jakob
 */

@WebServlet(urlPatterns = {"/app/buchung/new"})
public class BuchungSaveServlet extends HttpServlet {
    
    @EJB
    BuchungBean buchungBean;
    
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("signup_username");

        // Anfrage an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/buchung/buchung.jsp").forward(request, response);
    }//end of doGet
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<String> infos = new ArrayList<>();
        
 
        String buchungsId = request.getParameter("buchungsId");
        String kunde = request.getParameter("kunde");
        String fahrzeug = request.getParameter("fahrzeug");
        String startdatum = request.getParameter("startdatum");
        String enddatum = request.getParameter("enddatum");
        String preis = request.getParameter("preis");
        String abholort = request.getParameter("abholort");
        String zahlungsmethode = request.getParameter("zahlungsmethode");
        
        if(!zahlungsmethode.equals("") && !abholort.equals("") ){
                infos.add("Wird gesendet!");
                request.setAttribute("infos", infos);
                doGet(request, response);
            
        }
        
        
        
        
    }
}