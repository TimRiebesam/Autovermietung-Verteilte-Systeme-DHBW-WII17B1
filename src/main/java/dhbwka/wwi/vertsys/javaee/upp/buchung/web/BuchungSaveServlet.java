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
        
        //Liest die ID des angefragten Autos aus der URL
       // long id = Long.parseLong(request.getParameter("id"));
             
        /*Ausgewähltes Auto anhand der AutoID aus der Datenbank auslesen und im Request-Context
          abzulegen um sie der JSP zur Verfügung zu stellen */
       // Buchung buchung = this.buchungBean.findById(id);
     
      //  request.setAttribute("buchung", buchung);
        
         
        // Anfrage an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/buchung/buchung_save.jsp").forward(request, response);
    }//end of doGet

}
