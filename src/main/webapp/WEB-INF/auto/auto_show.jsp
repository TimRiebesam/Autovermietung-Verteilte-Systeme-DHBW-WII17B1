<%-- 
    Document   : auto_show
    Created on : 26.03.2019, 19:28:23
    Author     : Nicolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Auto auswaehlen
    </jsp:attribute>

    <jsp:attribute name="head">
        <%--<link rel="stylesheet" href="<c:url value="/css/task_list.css"/>" /> --%>
        <link rel="stylesheet" href="<c:url value="/css/details.css"/>"/>
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
            <div id="boxDetail">
                <label id="labelDetail">Details: </label>
            </div>
            
            <table>
                <tr>
                    <td>Marke: </td>    
                    <td><c:out value="${detailedAuto.getMarke()}"/> </td>
                </tr>
                <tr>
                    <td>Modell: </td>
                    <td><c:out value="${detailedAuto.getModell()}"/> </td>
                </tr>
                <tr>
                    <td>Größe: </td>
                    <td><c:out value="${detailedAuto.getGroeße()}"/> </td>
                </tr>
                <tr>
                    <td>Typ: </td>
                    <td><c:out value="${detailedAuto.getTyp()}"/> </td>
                </tr>
                <tr>
                    <td>Kraftstoff: </td>
                    <td><c:out value="${detailedAuto.getKraftstoff()}"/> </td>
                </tr>
                <tr>
                    <td> Anzahl der Sitzplätze:</td>
                    <td><c:out value="${detailedAuto.getAnzahl_sitzplaetze()}"/> </td>
                </tr>
                <tr>
                    <td>Anzahl der Türen: </td>
                    <td><c:out value="${detailedAuto.getAnzahl_tueren()}"/> </td>
                </tr>
                <tr>
                    <td>Getriebetyp: </td>
                    <td><c:out value="${detailedAuto.getGetriebetyp()}"/> </td>
                </tr>
                <tr>
                    <td>Preis: </td>
                    <td><c:out value="${detailedAuto.getPreis()}"/>  €/Tag</td>
                </tr>
            
                
            </table>
        
    </jsp:attribute>
</template:base>
