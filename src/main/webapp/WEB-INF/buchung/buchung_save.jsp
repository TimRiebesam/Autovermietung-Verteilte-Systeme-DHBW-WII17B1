
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
                
                <%-- Kundennummer ---%>
                <label for="buchungsId">Kunden-ID:<span class="required"></span></label>
                <input type="text" name="buchungsId" value="${param.buchungsId}" placeholder="Kundenname" required/>
                
                <%-- Fahrzeug ---%>
                <label for="auto">Fahrzeug:<span class="required"></span></label>
                <input type="text" name="fahrzeug"  value="${param.fahrzeugId}" placeholder="Auto" required/>
                
                <%-- Fahrzeug ---%>
                <label for="auto">Fahrzeug:<span class="required"></span></label>
                <input type="text" name="fahrzeug"  value="${param.fahrzeugId}" placeholder="Auto" required/>
                
                <%-- Fahrzeug ---%>
                <label for="auto">Fahrzeug:<span class="required"></span></label>
                <input type="text" name="fahrzeug"  value="${param.fahrzeugId}" placeholder="Auto" required/>
                
                <%-- Zahlungsmethode --%>
                <label for="zahlungsmethode">Zahlungsmethode:
                    <span class="required">*</span>
                </label>
                <select name="zahlungsmethode" value="">
                    <option value="PayPal" ${param.zahlungsmethode == 'PayPal' ? 'selected' : ''}>PayPal</option>
                    <option value="SWIFT Überweisung" ${param.zahlungsmethode == 'SWIFT Überweisung' ? 'selected' : ''}>SWIFT Überweisung</option>
                    <option value="Kreditkarte" ${param.zahlungsmethode == 'Kreditkarte' ? 'selected' : ''}>Kreditkarte</option>
                </select>
                
                
                <button class="icon-pencil" type="submit" name="action" value="save">
                        Zahlungspflichtig bestätigen!
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