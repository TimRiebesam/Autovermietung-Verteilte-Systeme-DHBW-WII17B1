/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.vertsys.javaee.upp.auto.web;

import dhbwka.wwi.vertsys.javaee.upp.common.web.WebUtils;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rapht
 */
@WebServlet(urlPatterns = {"/app/zeitraum"})
public class AutoZeitraumServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/uebersicht/zeitraum.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String> errors = new ArrayList<>();

        String beginDate = request.getParameter("von");
        String endDate = request.getParameter("bis");
        Date today = new Date();

        System.out.println(beginDate);
        System.out.println(endDate);

        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(beginDate);
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
            System.out.println(date1);
            System.out.println(date2);
            if (date1 != null && date2 != null && (date2.compareTo(date1) == 1 || date2.compareTo(date1) == 0) && (date1.compareTo(today)==1) && beginDate != null && endDate != null){
                request.getSession().setAttribute("Datum1", beginDate);
                request.getSession().setAttribute("Datum2", endDate);
                response.sendRedirect(WebUtils.appUrl(request, "/app/uebersicht"));
            }
            else{
                response.sendRedirect(WebUtils.appUrl(request, "/app/zeitraum"));
            }
        } catch (ParseException ex) {
            Logger.getLogger(AutoZeitraumServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
}
