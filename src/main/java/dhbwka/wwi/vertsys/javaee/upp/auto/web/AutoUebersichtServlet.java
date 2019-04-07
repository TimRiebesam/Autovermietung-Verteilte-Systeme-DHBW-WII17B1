/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.vertsys.javaee.upp.auto.web;

/**
 *
 * @author rapht
 */

import dhbwka.wwi.vertsys.javaee.upp.auto.ejb.AutoBean;
import dhbwka.wwi.vertsys.javaee.upp.auto.jpa.Auto;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
 * @author TimRiebesam
 */
@WebServlet(urlPatterns = {"/app/uebersicht"})
public class AutoUebersichtServlet extends HttpServlet{
    
    @EJB
    private AutoBean autoBean;
    
    //@EJB
    //private BuchungBean buchungBean;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              
        //Liest den Typ der angefragten Autos aus der URL
        String typ = request.getParameter("typ");
        if(typ == null){
            
        }
        else{
            List<Auto> autos = autoBean.getAutoByTyp(typ);
            
            request.setAttribute("autos", autos);
        }
        
        // Anfrage an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/uebersicht/uebersicht_show.jsp").forward(request, response);
    }
    
}