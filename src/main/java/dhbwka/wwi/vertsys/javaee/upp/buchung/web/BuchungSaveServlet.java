/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.vertsys.javaee.upp.buchung.web;

import dhbwka.wwi.vertsys.javaee.upp.auto.ejb.AutoBean;
import dhbwka.wwi.vertsys.javaee.upp.auto.jpa.Auto;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import dhbwka.wwi.vertsys.javaee.upp.buchung.ejb.BuchungBean;
import dhbwka.wwi.vertsys.javaee.upp.buchung.jpa.Buchung;
import dhbwka.wwi.vertsys.javaee.upp.common.jpa.User;
import dhbwka.wwi.vertsys.javaee.upp.kunde.jpa.Kunde;
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
        
        //Kunde Session ID
        User user = (User) request.getSession().getAttribute("user");
       String kunde = user.getVorname();
       request.setAttribute("kunde", kunde);
        
        //Auto Session ID
        Auto bookedAuto = (Auto) request.getSession().getAttribute("bookedAuto");
        String fahrzeug = bookedAuto.getMarke()+bookedAuto.getModell();
        request.setAttribute("fahrzeug", fahrzeug);
        System.out.println(bookedAuto.getMarke()+bookedAuto.getModell());

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
        
        if(!zahlungsmethode.equals("")){
                // ZEIGE INFO AN
                infos.add("Vielen Dank für Ihre Bestellung!</br>Sie erhalten eine Email mit allen wichtigen Informationen!");
                request.setAttribute("infos", infos);
                // SENDE EMAIL
                final String username = "lagerteamapp2018@gmail.com";
		final String password = "#LagerTeamApp2018";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
                        @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("lagerteamapp2018@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("11marci11@gmail.com"));
			message.setSubject("Buchungsbestätigung: Ihre Bestellung beim Auto-Mietservice");
			message.setText("Hallo "+kunde+","
				+ "\n\n vielen Dank für Ihre Bestellung beim Auto-Mietservice."
                                + "\n\n Hier eine Übersicht Ihrer Bestellung mit dem Link für die Rückgabe des Fahrzeugs."
                                + "\n\n BuchungsID: "+buchungsId+"."
                                + "\n\n Fahrzeug: "+fahrzeug+"."
                                + "\n\n Preis: "+preis+"."
                                + "\n\n Start-Datum: "+startdatum+"."
                                + "\n\n End-Datum: "+enddatum+"."
                                + "\n\n Abholort: "+abholort+"."
                                + "\n\n Zahlungsmethode: "+zahlungsmethode+"."
                                + "Sie können Ihre Fahrzeug über folgenden  Link (https://localhost:8443/upp/app/rueckgabe/new?id="+buchungsId+") zurück geben: <a>."
                                );

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
                
                doGet(request, response);
            
        }
        
        
        
        
    }
}