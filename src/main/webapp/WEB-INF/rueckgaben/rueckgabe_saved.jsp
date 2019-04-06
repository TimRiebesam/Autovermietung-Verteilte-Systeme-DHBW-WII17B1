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
            <a href="<c:url value="/app/zeitraum"/>">Auto reservieren</a>
        </div>

        <div class="menuitem">
            <a href="<c:url value="/app/rueckgabe/new"/>">Weiteres Auto zurückgeben</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">
        <div class="column">
            <h3>Ihre Rueckgabe war erfolgreich und wurde in unserem System gespeichert!</h3>
            <table style="font-size: 16pt;">
                <th>
                <td>Informationen zu Ihrer Rückgabe:</td>
                </th>
                <tr>
                    <td style="min-width: 120pt;">Buchungs-ID:</td>
                    <td><c:out value="${rueckgabe.buchung.id}"></c:out></td>
                </tr>
                <tr>
                    <td>Abstellort: </td>
                    <td><c:out value="${rueckgabe.rueckgabeOrt}"></c:out></td>
                </tr>
                <tr>
                    <td>Zufriedenheit Fahrzeug: </td>
                    <td><c:out value="${rueckgabe.fahrzeugZufriedenheit}"></c:out></td>
                </tr>
                <tr>
                    <td> Zufriedenheit Gesamt:</td>
                    <td><c:out value="${rueckgabe.gesamtZufriedenheit}"></c:out></td>
                </tr>
                <tr>
                    <td>Schadensmeldung:</td>
                    <td><c:out value="${rueckgabe.schadensMeldung}"></c:out></td>
                </tr>
                <tr>
                    <td>Ihre Rückmeldung für uns:</td>
                    <td><c:out value="${rueckgabe.kommentar}"></c:out></td>
                </tr>
                <tr>
                    <td>Datum der Rückgabe:</td>
                    <td><c:out value="${rueckgabe.rueckgabeDatum}"></c:out></td>
                </tr>
                
            </table>
        </div>
    </jsp:attribute>
</template:base>