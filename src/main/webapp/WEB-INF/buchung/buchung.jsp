
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Buchung abschließen
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
                
                <%-- Buchungs ID --%>
                <label for="buchungsId">Buchungs-ID:<span class="required"></span></label>
                <input type="text" name="buchungsId" value="${param.buchungsId}" placeholder="Buchungs-ID" required/>
                
                <%-- Kunde ---%>
                <label for="kunde">Kunden-ID:<span class="required"></span></label>
                <input type="text" name="kunde" value="${param.kunde}" placeholder="Kundenname" required/>
                                
                <%-- Fahrzeug ---%>
                <label for="fahrzeug">Fahrzeug:<span class="required"></span></label>
                <input type="text" name="fahrzeug"  value="${param.fahrzeug}" placeholder="fahrzeug" required/>
                
                <%-- Start Datum ---%>
                <label for="startdatum">Start-Datum:<span class="required"></span></label>
                <input type="text" name="startdatum"  value="${param.startdatum}" placeholder="Start Datum" required/>
                
                <%-- End-Datum ---%>
                <label for="enddatum">End-Datum:<span class="required"></span></label>
                <input type="text" name="enddatum"  value="${param.enddatum}" placeholder="End Datum" required/>
                
                <%-- Abholort---%>
                <label for="abholort">Abholort:<span class="required"></span></label>
                <input type="text" name="abholort"  value="${param.abholort}" placeholder="End Datum" required/>
                
                <%-- Zahlungsmethode --%>
                <label for="zahlungsmethode">Zahlungsmethode:
                    <span class="required">*</span>
                </label>
                <select name="zahlungsmethode" value="">
                    <option value="PayPal" ${param.zahlungsmethode == 'PayPal' ? 'selected' : ''}>PayPal</option>
                    <option value="SWIFT Überweisung" ${param.zahlungsmethode == 'SWIFT Überweisung' ? 'selected' : ''}>SWIFT Überweisung</option>
                    <option value="Kreditkarte" ${param.zahlungsmethode == 'Kreditkarte' ? 'selected' : ''}>Kreditkarte</option>
                </select>
                </br>
                </br>

                
                <button class="icon-pencil" type="submit" name="action" value="save">
                        Zahlungspflichtig bestellen!
                </button>
                
                <c:if test="${!empty infos}">
                <ul class="infos">
                    <c:forEach items="${infos}" var="error">
                        <b>${infos}</b>
                    </c:forEach>
                </ul>
            </c:if>
        </form>
        
    </jsp:attribute>
</template:base>