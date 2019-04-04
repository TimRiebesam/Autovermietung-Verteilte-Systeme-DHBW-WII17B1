<%-- 
    Document   : rueckgabe_save
    Created on : 23.03.2019, 20:30:12
    Author     : TimRiebesam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Rueckgabe abschließen
    </jsp:attribute>

    <jsp:attribute name="head">
        <%-- <link rel="stylesheet" href="<c:url value="/css/task_list.css"/>" /> --%>
    </jsp:attribute>

    <jsp:attribute name="menu">
        <div class="menuitem">
            <a href="<c:url value="/app/dashboard/"/>">Dashboard</a>
        </div>

        <div class="menuitem">
            <a href="<c:url value="/app/tasks/task/new/"/>">Aufgabe anlegen</a>
        </div>

        <div class="menuitem">
            <a href="<c:url value="/app/tasks/categories/"/>">Kategorien bearbeiten</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">
        
        
        
        <form method="POST" class="stacked" id="save">
            <div class="column">
                <%-- CSRF-Token --%>
                <input type="hidden" name="csrf_token" value="${csrf_token}">
                                
                <label for="buchungsId">Buchungs ID:
                    <span class="required">*</span>
                </label>
                <input type="text" name="buchungsId" value="${rueckgabe.buchung.id}" p laceholder="Buchungs-ID" required/>
                
                <label for="abstellort">Abstellort:
                    <span class="required">*</span>
                </label>
                <select name="abstellort" value="">
                    <option value="Karlsruhe Mitte" ${rueckgabe.rueckgabeOrt == 'Karlsruhe Mitte' ? 'selected' : ''}>Karlsruhe Mitte</option>
                    <option value="Karlsruhe Nord" ${rueckgabe.rueckgabeOrt == 'Karlsruhe Nord' ? 'selected' : ''}>Karlsruhe Nord</option>
                    <option value="Karlsruhe Ost" ${rueckgabe.rueckgabeOrt == 'Karlsruhe Ost' ? 'selected' : ''}>Karlsruhe Ost</option>
                    <option value="Karlsruhe Süd" ${rueckgabe.rueckgabeOrt == 'Karlsruhe süd' ? 'selected' : ''}>Karlsruhe Süd</option>
                    <option value="Karlsruhe West" ${rueckgabe.rueckgabeOrt == 'Karlsruhe West' ? 'selected' : ''}>Karlsruhe West</option>
                </select>
                
                <label for="schadenEntstanden">Schaden entstanden</label>
                <input type="checkbox" id="schadenEntstanden" name="schadenEntstanden" onclick="handleSchadensfall()"/>
                
                <label for="schadensmeldung" id="schadensmeldungLabel" style="display: none;">Schadensmeldung:</label>
                <textarea name="schadensmeldung" id="schadensmeldung" disabled="true" style="display: none;" value="${rueckgabe.schadensMeldung}" placeholder="Beschreiben Sie hier Ihren Schaden. Wir werden uns anschließend in kürze bei Ihnen melden."></textarea>
                
                <label for="fahrzeugZufriedenheit">Ihre Zufriedenheit mit dem Fahrzeug:
                    <span class="required">*</span>
                </label>
                <select name="fahrzeugZufriedenheit">
                    <option value="10" ${rueckgabe.fahrzeugZufriedenheit == 10 ? 'selected' : ''}>10</option>
                    <option value="9" ${rueckgabe.fahrzeugZufriedenheit == 9 ? 'selected' : ''}>9</option>
                    <option value="8" ${rueckgabe.fahrzeugZufriedenheit == 8 ? 'selected' : ''}>8</option>
                    <option value="7" ${rueckgabe.fahrzeugZufriedenheit == 7 ? 'selected' : ''}>7</option>
                    <option value="6" ${rueckgabe.fahrzeugZufriedenheit == 6 ? 'selected' : ''}>6</option>
                    <option value="5" ${rueckgabe.fahrzeugZufriedenheit == 5 ? 'selected' : ''}>5</option>
                    <option value="4" ${rueckgabe.fahrzeugZufriedenheit == 4 ? 'selected' : ''}>4</option>
                    <option value="3" ${rueckgabe.fahrzeugZufriedenheit == 3 ? 'selected' : ''}>3</option>
                    <option value="2" ${rueckgabe.fahrzeugZufriedenheit == 2 ? 'selected' : ''}>2</option>
                    <option value="1" ${rueckgabe.fahrzeugZufriedenheit == 1 ? 'selected' : ''}>1</option>
                </select>
                
                <label for="gesamtZufriedenheit">Ihre Zufriedenheit im Allgemeinen:
                    <span class="required">*</span>
                </label>
                <select name="gesamtZufriedenheit">
                    <option value="10" ${rueckgabe.gesamtZufriedenheit == 10 ? 'selected' : ''}>10</option>
                    <option value="9" ${rueckgabe.gesamtZufriedenheit == 9 ? 'selected' : ''}>9</option>
                    <option value="8" ${rueckgabe.gesamtZufriedenheit == 8 ? 'selected' : ''}>8</option>
                    <option value="7" ${rueckgabe.gesamtZufriedenheit == 7 ? 'selected' : ''}>7</option>
                    <option value="6" ${rueckgabe.gesamtZufriedenheit == 6 ? 'selected' : ''}>6</option>
                    <option value="5" ${rueckgabe.gesamtZufriedenheit == 5 ? 'selected' : ''}>5</option>
                    <option value="4" ${rueckgabe.gesamtZufriedenheit == 4 ? 'selected' : ''}>4</option>
                    <option value="3" ${rueckgabe.gesamtZufriedenheit == 3 ? 'selected' : ''}>3</option>
                    <option value="2" ${rueckgabe.gesamtZufriedenheit == 2 ? 'selected' : ''}>2</option>
                    <option value="1" ${rueckgabe.gesamtZufriedenheit == 1 ? 'selected' : ''}>1</option>
                </select>
                
                <label for="kommentar" id="schadensmeldungLabel" >Ihre Rückmeldung an uns:</label>
                <textarea name="kommentar" id="kommentar" value="${rueckgabe.kommentar}" placeholder="Sollten Sie Rückfragen oder ein bestimmtes Anliegen an uns haben, wäre Hier der richtige Platz dafür..."></textarea>
                
                <button class="icon-pencil" type="submit" name="action" value="save">
                        Sichern
                </button>

                <c:if test="${!empty errors}">
                <ul class="errors">
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </c:if>
        </form>
        
    </jsp:attribute>
</template:base>
       
<script type="text/javascript">
    function handleSchadensfall(){
        var sm = document.getElementById('schadensmeldung');
        var sml = document.getElementById('schadensmeldungLabel');
        if(sm.disabled){
            sm.disabled = false;
            sm.style.display = "block";
            sml.style.display = "block";
        }
        else{
            sm.disabled = true;
            sm.style.display = "none";
            sml.style.display = "none";
        }
    }
</script>