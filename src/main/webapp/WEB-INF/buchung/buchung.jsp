
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
            <a href="<c:url value="/app/zeitraum"/>">Auto reservieren</a>
        </div>

        <div class="menuitem">
            <a href="<c:url value="/app/rueckgabe/new"/>">Auto zurückgeben</a>
        </div>


    </jsp:attribute>

    <jsp:attribute name="content">
        
        
        
        <form method="POST" class="stacked" id="save">
            <div class="column">
                <%-- CSRF-Token --%>
                <input type="hidden" name="csrf_token" value="${csrf_token}">
                                
                <%-- Kunde ---%>
                <label for="kunde">Kunde:<span class="required"></span></label>
                <input type="text" disabled="true" name="kunde" value="${kunde}"/>
                                
                <%-- Fahrzeug ---%>
                <label for="fahrzeug">Fahrzeug:<span class="required"></span></label>
                <input type="text" disabled="true" name="fahrzeug" value="${fahrzeug}"/>
                
                <%-- Start Datum ---%>
                <label for="startdatum">Start-Datum:<span class="required"></span></label>
                <input type="text" disabled="true" name="startdatum" value="${startdatum}"/>
                
                <%-- End-Datum ---%>
                <label for="enddatum">End-Datum:<span class="required"></span></label>
                <input type="text" disabled="true" name="enddatum" value="${enddatum}"/>
                
                <%-- Preis ---%>
                <label for="preis">Preis:<span class="required"></span></label>
                <input type="text" disabled="true" name="preis" value="${preis}"/>
                
                <%-- Abholort---%>
                <label for="abholort">Abholort:<span class="required">*</span></label>
                <select name="abholort" value="">
                    <option value="Karlsruhe Nord" ${param.kanord == 'Karlsruhe Nord' ? 'selected' : ''}>Karlsruhe Nord</option>
                    <option value="Karlsruhe Ost" ${param.kaost == 'Karlsruhe Ost' ? 'selected' : ''}>Karlsruhe Ost</option>
                    <option value="Karlsruhe Süd" ${param.kasued == 'Karlsruhe Süd' ? 'selected' : ''}>Karlsuhe Süd</option>
                    <option value="Karlsruhe West" ${param.kawest == 'Karlsruhe West' ? 'selected' : ''}>Karlsuhe West</option>
                </select>
                
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