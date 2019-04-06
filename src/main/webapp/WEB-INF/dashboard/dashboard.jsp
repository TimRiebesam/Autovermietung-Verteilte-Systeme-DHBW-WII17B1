<%-- 
    Copyright © 2019 Dennis Schulmeister-Zimolong

    E-Mail: dhbw@windows3.de
    Webseite: https://www.wpvs.de/

    Dieser Quellcode ist lizenziert unter einer
    Creative Commons Namensnennung 4.0 International Lizenz.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Dashboard
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/dashboard.css"/>" />
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
        
        <h2>Reservieren Sie sich noch heute Ihren Taumwagen!</h2>
        
        <div class="tile overview">
            <a href="<c:url value="/app/zeitraum"/>">
                <div class="content">
                    <div class="label">
                        Auto reservieren
                    </div>
                </div>
            </a>
         </div>

        <div class="tile overview">
            <a href="<c:url value="/app/rueckgabe/new"/>">
                <div class="content">
                    <div class="label">
                        Auto zurückgeben
                    </div>
                </div>
            </a>
        </div>
        
    </jsp:attribute>
</template:base>