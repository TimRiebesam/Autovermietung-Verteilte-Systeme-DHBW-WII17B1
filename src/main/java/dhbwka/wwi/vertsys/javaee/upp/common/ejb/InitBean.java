/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.vertsys.javaee.upp.common.ejb;

import dhbwka.wwi.vertsys.javaee.upp.auto.ejb.AutoBean;
import dhbwka.wwi.vertsys.javaee.upp.auto.jpa.Auto;
import dhbwka.wwi.vertsys.javaee.upp.buchung.ejb.BuchungBean;
import dhbwka.wwi.vertsys.javaee.upp.buchung.jpa.Buchung;
import dhbwka.wwi.vertsys.javaee.upp.rechnung.ejb.RechnungBean;
import dhbwka.wwi.vertsys.javaee.upp.rechnung.jpa.Rechnung;
import dhbwka.wwi.vertsys.javaee.upp.rueckgabe.ejb.RueckgabeBean;
import dhbwka.wwi.vertsys.javaee.upp.rueckgabe.jpa.Rueckgabe;
import dhbwka.wwi.vertsys.javaee.upp.zahlungsmethode.ejb.ZahlungsmethodeBean;
import dhbwka.wwi.vertsys.javaee.upp.zahlungsmethode.jpa.Zahlungsmethode;
import java.util.Date;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author TimRi
 */

@Stateless
@RolesAllowed("app-user")
public class InitBean {
    
    @EJB
    private RueckgabeBean rueckgabeBean;
    
    @EJB
    private AutoBean autoBean;
    
    @EJB
    private BuchungBean buchungBean;
    
    @EJB
    private RechnungBean rechnungBean;
    
    @EJB
    private ZahlungsmethodeBean zahlungsmethodeBean;
    
    @EJB
    private UserBean userBean;
    
    public void initializeDatabase(){
        deleteAllFromDatabase();
        loadAutosIntoDatabase();
    }
    
    private void deleteAllFromDatabase(){
        List<Rueckgabe> rueckgaben = rueckgabeBean.findAll();
        rueckgaben.forEach(rueckgabe -> {
            rueckgabeBean.delete(rueckgabe);
        });
        
        List<Auto> autos = autoBean.findAll();
        autos.forEach(auto -> {
            autoBean.delete(auto);
        });
        
        List<Buchung> buchungen = buchungBean.findAll();
        buchungen.forEach(buchung -> {
            buchungBean.delete(buchung);
        });
        
        List<Rechnung> rechnungen = rechnungBean.findAll();
        rechnungen.forEach(rechnung -> {
            rechnungBean.delete(rechnung);
        });
        
        List<Zahlungsmethode> zahlungsmethoden = zahlungsmethodeBean.findAll();
        zahlungsmethoden.forEach(zahlungsmethode -> {
            zahlungsmethodeBean.delete(zahlungsmethode);
        });
    }
    
    private void loadAutosIntoDatabase(){
        //Autos
        Auto auto1 = new Auto("VW", "Golf", "L 4.258 mm <br>B 1.790 mm <br>H 1.492 mm", "Kleinwagen", "Benzin", 5, 4, "Automatik", 12034, 55, "https://cdn.meinauto.de/car-pics/___Pix-NoBrand/VOLKSWAGEN/GOLF/7/5Hatchback%20Comfortline/volkswagen_17golfcomfort5ha7fb_angularfront_nb-298.jpg");
        Auto auto2 = new Auto("Ford", "Transit", "L 4.973 mm <br>B 1.986 mm <br>H 2.000 mm", "Transporter", "Diesel", 3, 4, "Automatik", 16344, 90, "https://www.meinauto.de/pics/auto_neuwagen/ford-transit-custom-kastenwagen-298.jpg");
        Auto auto3 = new Auto("Porsche", "911", "L 4.519 mm <br>B 1.852 mm <br>H 1.300 mm", "Sportwagen", "Benzin", 2, 2, "Automatik", 4020, 150, "https://cdn.meinauto.de/car-pics/___Pix-NoBrand/PORSCHE/911/7/2Coupe%20CarreraS/porsche_17911carrerasco7fa_angularfront_nb-298.jpg");
        autoBean.saveAuto(auto1);
        autoBean.saveAuto(auto2);
        autoBean.saveAuto(auto3);
        
        //Zwei weitere Autos
        autoBean.saveAuto(new Auto("Audi", "911", "L 4.519 mm <br>B 1.852 mm <br>H 1.300 mm", "Limousine", "Benzin", 2, 2, "Automatik", 4020, 150, "https://cdn.meinauto.de/car-pics/___Pix-NoBrand/PORSCHE/911/7/2Coupe%20CarreraS/porsche_17911carrerasco7fa_angularfront_nb-298.jpg"));
        autoBean.saveAuto(new Auto("Porsche", "911", "L 4.519 mm <br>B 1.852 mm <br>H 1.300 mm", "Sonstige", "Benzin", 2, 2, "Automatik", 4020, 150, "https://cdn.meinauto.de/car-pics/___Pix-NoBrand/PORSCHE/911/7/2Coupe%20CarreraS/porsche_17911carrerasco7fa_angularfront_nb-298.jpg"));
        
        
        Buchung buchung1 = new Buchung(auto1, userBean.getCurrentUser(), "1", new Date(), new Date(), 0, "Karlsruhe Süd");
        Buchung buchung2 = new Buchung(auto2, userBean.getCurrentUser(), "2", new Date(), new Date(), 0, "Karlsruhe Mitte");
        buchungBean.saveBuchung(buchung1);
        buchungBean.saveBuchung(buchung2);
        
        rueckgabeBean.saveNew(new Rueckgabe(buchung1, "", "Karlsruhe West", 9, 7, "Sehr zufrieden, Danke für den unkomplizierten Service!"));
        rueckgabeBean.saveNew(new Rueckgabe(buchung2, "Kratzer Frontstoßstange", "Karlsruhe Mitte", 10, 10, "Alles TipTop"));
    }
    
}
