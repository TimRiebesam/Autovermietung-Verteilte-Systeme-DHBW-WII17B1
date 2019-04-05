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
        <link rel="stylesheet" href="<c:url value="/css/rueckgabe_save.css"/>" />
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
                <input type="text" name="buchungsId" value="${task_form.values['buchungsId'][0]}" p laceholder="Buchungs-ID" required/>
                
                <label for="abstellort">Abstellort:
                    <span class="required">*</span>
                </label>
                <select name="abstellort" >
                    <option value="Karlsruhe Mitte" ${task_form.values['abstellort'][0].equals('Karlsruhe Mitte') ? 'selected' : ''}>Karlsruhe Mitte</option>
                    <option value="Karlsruhe Nord" ${task_form.values['abstellort'][0].equals('Karlsruhe Nord') ? 'selected' : ''}>Karlsruhe Nord</option>
                    <option value="Karlsruhe Ost" ${task_form.values['abstellort'][0].equals('Karlsruhe Ost') ? 'selected' : ''}>Karlsruhe Ost</option>
                    <option value="Karlsruhe Süd" ${task_form.values['abstellort'][0].equals('Karlsruhe süd') ? 'selected' : ''}>Karlsruhe Süd</option>
                    <option value="Karlsruhe West" ${task_form.values['abstellort'][0].equals('Karlsruhe West') ? 'selected' : ''}>Karlsruhe West</option>
                </select>
                
                <label class="container">Schaden entstanden
                    <input type="checkbox" id="schadenEntstanden" name="schadenEntstanden" onclick="handleSchadensfall()">
                    <span class="checkmark"></span>
                </label>
                <label for="schadensmeldung" id="schadensmeldungLabel" style="display: none">Schadensmeldung:</label>
                <textarea name="schadensmeldung" id="schadensmeldung" disabled="true" style="display: none" placeholder="Beschreiben Sie hier Ihren Schaden. Wir werden uns anschließend in kürze bei Ihnen melden.">
                    <c:out value="${task_form.values['schadensmeldung'][0]}"/>
                </textarea>
                
                <label for="fahrzeugZufriedenheit">Ihre Zufriedenheit mit dem Fahrzeug:
                    <span class="required">*</span>
                </label>
                <select name="fahrzeugZufriedenheit">
                    <option value="10" ${task_form.values['fahrzeugZufriedenheit'][0] == 10 ? 'selected' : ''}>10</option>
                    <option value="9" ${task_form.values['fahrzeugZufriedenheit'][0] == 9 ? 'selected' : ''}>9</option>
                    <option value="8" ${task_form.values['fahrzeugZufriedenheit'][0] == 8 ? 'selected' : ''}>8</option>
                    <option value="7" ${task_form.values['fahrzeugZufriedenheit'][0] == 7 ? 'selected' : ''}>7</option>
                    <option value="6" ${task_form.values['fahrzeugZufriedenheit'][0] == 6 ? 'selected' : ''}>6</option>
                    <option value="5" ${task_form.values['fahrzeugZufriedenheit'][0] == 5 ? 'selected' : ''}>5</option>
                    <option value="4" ${task_form.values['fahrzeugZufriedenheit'][0] == 4 ? 'selected' : ''}>4</option>
                    <option value="3" ${task_form.values['fahrzeugZufriedenheit'][0] == 3 ? 'selected' : ''}>3</option>
                    <option value="2" ${task_form.values['fahrzeugZufriedenheit'][0] == 2 ? 'selected' : ''}>2</option>
                    <option value="1" ${task_form.values['fahrzeugZufriedenheit'][0] == 1 ? 'selected' : ''}>1</option>
                </select>
                
                <label for="gesamtZufriedenheit">Ihre Zufriedenheit im Allgemeinen:
                    <span class="required">*</span>
                </label>
                <select name="gesamtZufriedenheit">
                    <option value="10" ${task_form.values['gesamtZufriedenheit'][0] == 10 ? 'selected' : ''}>10</option>
                    <option value="9" ${task_form.values['gesamtZufriedenheit'][0] == 9 ? 'selected' : ''}>9</option>
                    <option value="8" ${task_form.values['gesamtZufriedenheit'][0] == 8 ? 'selected' : ''}>8</option>
                    <option value="7" ${task_form.values['gesamtZufriedenheit'][0] == 7 ? 'selected' : ''}>7</option>
                    <option value="6" ${task_form.values['gesamtZufriedenheit'][0] == 6 ? 'selected' : ''}>6</option>
                    <option value="5" ${task_form.values['gesamtZufriedenheit'][0] == 5 ? 'selected' : ''}>5</option>
                    <option value="4" ${task_form.values['gesamtZufriedenheit'][0] == 4 ? 'selected' : ''}>4</option>
                    <option value="3" ${task_form.values['gesamtZufriedenheit'][0] == 3 ? 'selected' : ''}>3</option>
                    <option value="2" ${task_form.values['gesamtZufriedenheit'][0] == 2 ? 'selected' : ''}>2</option>
                    <option value="1" ${task_form.values['gesamtZufriedenheit'][0] == 1 ? 'selected' : ''}>1</option>
                </select>
                
                <label for="kommentar" id="schadensmeldungLabel" >Ihre Rückmeldung an uns:</label>
                <textarea name="kommentar" id="kommentar" plceholder="Hier wäre der pssende Ort, falls Sie eine Frage / ein Anliegen an uns haben...">
                    <c:out value="${task_form.values['kommentar'][0]}"/>
                </textarea>
                
                <button class="icon-pencil" type="submit" name="action" value="save">
                        Sichern
                </button>

                <c:if test="${!empty task_form.errors}">
                    <ul class="errors">
                        <c:forEach items="${task_form.errors}" var="error">
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