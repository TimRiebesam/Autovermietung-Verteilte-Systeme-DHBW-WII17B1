<%-- 
    Document   : rueckgabe_saved
    Created on : 25.03.2019, 14:45:36
    Author     : TimRiebesam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Rueckgabe gespeichert
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
        <div class="column">
            <label>Ihre Rueckgabe war erfolgreich und wurde in unserem System gespeichert!</label>
            Informationen zu Ihrer Rückgabe:<br>
            Buchungs-ID: <c:out value="${rueckgabe.buchung.id}"></c:out><br>
            Abstellort: <c:out value="${rueckgabe.rueckgabeOrt}"></c:out><br>
            Zufriedenheit Fahrzeug: <c:out value="${rueckgabe.fahrzeugZufriedenheit}"></c:out><br>
            Zufriedenheit Gesamt: <c:out value="${rueckgabe.gesamtZufriedenheit}"></c:out><br>
            Schadensmeldung: <c:out value="${rueckgabe.schadensMeldung}"></c:out><br>
            Ihre Rückmeldung für uns: <c:out value="${rueckgabe.kommentar}"></c:out><br>
            Datum der Rückgabe: <c:out value="${rueckgabe.rueckgabeDatum}"></c:out><br>
        </div>
    </jsp:attribute>
</template:base>