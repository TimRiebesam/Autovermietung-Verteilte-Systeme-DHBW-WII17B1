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
                <input type="text" name="buchungsId" value="${param.buchungsId}" placeholder="Buchungs-ID" required/>
                
                <label for="abstellort">Abstellort:
                    <span class="required">*</span>
                </label>
                <select name="abstellort" value="">
                    <option value="Karlsruhe Mitte" ${param.abstellort == 'Karlsruhe Mitte' ? 'selected' : ''}>Karlsruhe Mitte</option>
                    <option value="Karlsruhe Nord" ${param.abstellort == 'Karlsruhe Nord' ? 'selected' : ''}>Karlsruhe Nord</option>
                    <option value="Karlsruhe Ost" ${param.abstellort == 'Karlsruhe Ost' ? 'selected' : ''}>Karlsruhe Ost</option>
                    <option value="Karlsruhe Süd" ${param.abstellort == 'Karlsruhe süd' ? 'selected' : ''}>Karlsruhe Süd</option>
                    <option value="Karlsruhe West" ${param.abstellort == 'Karlsruhe West' ? 'selected' : ''}>Karlsruhe West</option>
                </select>
                
                <label for="schadenEntstanden">Schaden entstanden</label>
                <input type="checkbox" id="schadenEntstanden" name="schadenEntstanden" onclick="handleSchadensfall()"/>
                
                <label for="schadensmeldung" id="schadensmeldungLabel" style="display: none;">Schadensmeldung:</label>
                <textarea name="schadensmeldung" id="schadensmeldung" disabled="true" style="display: none;" value="${param.schadensmeldung}" placeholder="Beschreiben Sie hier Ihren Schaden. Wir werden uns anschließend in kürze bei Ihnen melden."></textarea>
                
                <label for="fahrzeugZufriedenheit">Ihre Zufriedenheit mit dem Fahrzeug:
                    <span class="required">*</span>
                </label>
                <select name="fahrzeugZufriedenheit" value="">
                    <option value="10" ${param.fahrzeugZufriedenheit == 10 ? 'selected' : ''}>10</option>
                    <option value="9" ${param.fahrzeugZufriedenheit == 9 ? 'selected' : ''}>9</option>
                    <option value="8" ${param.fahrzeugZufriedenheit == 8 ? 'selected' : ''}>8</option>
                    <option value="7" ${param.fahrzeugZufriedenheit == 7 ? 'selected' : ''}>7</option>
                    <option value="6" ${param.fahrzeugZufriedenheit == 6 ? 'selected' : ''}>6</option>
                    <option value="5" ${param.fahrzeugZufriedenheit == 5 ? 'selected' : ''}>5</option>
                    <option value="4" ${param.fahrzeugZufriedenheit == 4 ? 'selected' : ''}>4</option>
                    <option value="3" ${param.fahrzeugZufriedenheit == 3 ? 'selected' : ''}>3</option>
                    <option value="2" ${param.fahrzeugZufriedenheit == 2 ? 'selected' : ''}>2</option>
                    <option value="1" ${param.fahrzeugZufriedenheit == 1 ? 'selected' : ''}>1</option>
                </select>
                
                <label for="gesamtZufriedenheit">Ihre Zufriedenheit im Allgemeinen:
                    <span class="required">*</span>
                </label>
                <select name="gesamtZufriedenheit" value="">
                    <option value="10" ${param.gesamtZufriedenheit == 10 ? 'selected' : ''}>10</option>
                    <option value="9" ${param.gesamtZufriedenheit == 9 ? 'selected' : ''}>9</option>
                    <option value="8" ${param.gesamtZufriedenheit == 8 ? 'selected' : ''}>8</option>
                    <option value="7" ${param.gesamtZufriedenheit == 7 ? 'selected' : ''}>7</option>
                    <option value="6" ${param.gesamtZufriedenheit == 6 ? 'selected' : ''}>6</option>
                    <option value="5" ${param.gesamtZufriedenheit == 5 ? 'selected' : ''}>5</option>
                    <option value="4" ${param.gesamtZufriedenheit == 4 ? 'selected' : ''}>4</option>
                    <option value="3" ${param.gesamtZufriedenheit == 3 ? 'selected' : ''}>3</option>
                    <option value="2" ${param.gesamtZufriedenheit == 2 ? 'selected' : ''}>2</option>
                    <option value="1" ${param.gesamtZufriedenheit == 1 ? 'selected' : ''}>1</option>
                </select>
                
                <label for="kommentar" id="schadensmeldungLabel" >Ihre Rückmeldung an uns:</label>
                <textarea name="kommentar" id="kommentar" value="${param.kommentar}" placeholder="Sollten Sie Rückfragen oder ein bestimmtes Anliegen an uns haben, wäre Hier der richtige Platz dafür..."></textarea>
                
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