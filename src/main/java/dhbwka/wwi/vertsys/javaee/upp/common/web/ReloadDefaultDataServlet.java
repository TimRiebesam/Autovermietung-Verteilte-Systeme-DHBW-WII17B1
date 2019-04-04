/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.vertsys.javaee.upp.common.web;

import dhbwka.wwi.vertsys.javaee.upp.common.ejb.InitBean;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TimRi
 */

@WebServlet(urlPatterns = {"/reloaddefaultdata/"})
public class ReloadDefaultDataServlet extends HttpServlet{
    
    @EJB
    InitBean initBean;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initBean.initializeDatabase();
        
        response.sendRedirect(WebUtils.appUrl(request, "/app/dashboard/"));
    }
    
}
