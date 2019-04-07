<%-- 
    Document   : uebersichtTyp_show
    Created on : 06.04.2019, 11:17:20
    Author     : rapht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Buchungszeitraum
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
            <form method="POST">
                <h2>Wählen Sie den Zeitraum, an dem Sie das Fahrzeug wollen</h2>
                <input type="hidden" name="csrf_token" value="${csrf_token}">

                <input type="date" id="von" name="von"/>
                <input type="date" id="bis" name="bis"/>
                
                <button class="icon-pencil" type="submit" name="action" value="save">
                        auswählen
                </button>
            </form>
            
            
        </jsp:attribute>
</template:base>