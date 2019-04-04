    /**
 * Copyright © 2019
 *  Marcel Jakob
 *  Nicolas Neuhof
 *  Raphael Menken
 *  Tim Riebesam
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */

package dhbwka.wwi.vertsys.javaee.upp.rueckgabe.web;

import dhbwka.wwi.vertsys.javaee.upp.buchung.ejb.BuchungBean;
import dhbwka.wwi.vertsys.javaee.upp.buchung.jpa.Buchung;
import dhbwka.wwi.vertsys.javaee.upp.common.ejb.ValidationBean;
import dhbwka.wwi.vertsys.javaee.upp.common.web.FormValues;
import dhbwka.wwi.vertsys.javaee.upp.rueckgabe.ejb.RueckgabeBean;
import dhbwka.wwi.vertsys.javaee.upp.rueckgabe.jpa.Rueckgabe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TimRiebesam
 */
@WebServlet(urlPatterns = {"/app/rueckgabe/new"})
public class RueckgabeSaveServlet extends HttpServlet{
    
    @EJB
    private RueckgabeBean rueckgabeBean;
    
    @EJB
    private BuchungBean buchungBean;
    
    @EJB
    ValidationBean validationBean;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Anfrage an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/rueckgaben/rueckgabe_save.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<String> errors = new ArrayList<>();
        
        //Mögliche Buchungs-IDs für Tests: 250 / 251
        
        String buchungsId = request.getParameter("buchungsId");
        String abstellort = request.getParameter("abstellort");
        String schadensmeldung = request.getParameter("schadensmeldung");
        String fahrzeugZufriedenheit = request.getParameter("fahrzeugZufriedenheit");
        String gesamtZufriedenheit = request.getParameter("gesamtZufriedenheit");
        String kommentar = request.getParameter("kommentar");
        
        Rueckgabe rueckgabe = new  Rueckgabe(schadensmeldung, abstellort, Integer.parseInt(gesamtZufriedenheit), Integer.parseInt(fahrzeugZufriedenheit), kommentar);
        
        if(buchungsId != null && abstellort != null && fahrzeugZufriedenheit != null && gesamtZufriedenheit != null){            
            if(!buchungsId.equals("") && !abstellort.equals("") && !fahrzeugZufriedenheit.equals("") && !gesamtZufriedenheit.equals("")){
                try {
                    long bId = Long.parseLong(buchungsId);
                    Buchung buchung = buchungBean.findById(bId);
                    if(buchung != null){
                        rueckgabe.setBuchung(buchung);
                        rueckgabeBean.saveNew(rueckgabe);
                        request.setAttribute("rueckgabe", rueckgabe);
                        request.getRequestDispatcher("/WEB-INF/rueckgaben/rueckgabe_saved.jsp").forward(request, response);
                    } 
                    else{
                        errors.add("Es existiert keine Buchung zu der ID: " + buchungsId + "<br>Bitte überprüfen Sie Ihre Eingabe!");
                    }
                } catch (Exception e) {
                    errors.add("Die Buchungs-ID darf ausschließlich aus Zahlen bestehen!<br>Bitte überprüfen Sie Ihre Eingabe!");
                }
            }
        
            else{
                errors.add("Fehler!<br>Bitte überprüfen Sie Ihre eingegebenen Daten!");
            }
            
            this.validationBean.validate(rueckgabe, errors);
        }
        
        if(!errors.isEmpty()){            
            FormValues formValues = new FormValues();
            formValues.setValues(request.getParameterMap());
            formValues.setErrors(errors);

            HttpSession session = request.getSession();
            session.setAttribute("task_form", formValues);

            response.sendRedirect(request.getRequestURI());
        }
        
    }
    
}
