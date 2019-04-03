/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.vertsys.javaee.upp.auto.web;

import dhbwka.wwi.vertsys.javaee.upp.auto.ejb.AutoBean;
import dhbwka.wwi.vertsys.javaee.upp.auto.jpa.Auto;
import dhbwka.wwi.vertsys.javaee.upp.common.web.WebUtils;
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
 * @author Nicolas
 */
@WebServlet(urlPatterns = {"/app/details"})
public class AutoServlet extends HttpServlet {

    @EJB
    AutoBean autoBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Liest die ID des angefragten Autos aus der URL
        long id = Long.parseLong(request.getParameter("id"));

        /*Ausgewähltes Auto anhand der AutoID aus der Datenbank auslesen und im Request-Context
          abzulegen um sie der JSP zur Verfügung zu stellen */
        Auto detailedAuto = this.autoBean.findById(id);

        request.setAttribute("detailedAuto", detailedAuto);

        // Anfrage an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/auto/auto_show.jsp").forward(request, response);
    }//end of doGet

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String> errors = new ArrayList<>();

        long id = Long.parseLong(request.getParameter("id"));

        Auto bookedAuto = this.autoBean.findById(id);

       request.getSession().setAttribute("bookedAuto",bookedAuto);

        response.sendRedirect(WebUtils.appUrl(request, "/app/buchung/new"));

    }
}
