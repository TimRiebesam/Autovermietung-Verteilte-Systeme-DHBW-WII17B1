<%-- 
    Document   : uebersicht_show
    Created on : 01.04.2019, 20:37:45
    Author     : rapht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<template:base>
    <jsp:attribute name="title">
        Autotyp wählen
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/uebersicht.css"/>"/>
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

        <div class="flex-container">
            <a href="#">
                <img class="img-responsive img-rounded" src="" alt="">
            </a>
                    <a href="/upp/app/zeitraum">
                       <button id="button2" class="icon-pencil" type="submit" name="action" value="save">
                           <td>zurück</td> 
                       </button>
                   </a>
                      
            <h2>
                Welcher Typ soll das Fahrzeug sein?
            </h2>
            <div class="flex-item">
                <a href="uebersicht?typ=Sportwagen">
                    <button id="button1" class="icon-pencil" type="submit" name="action" value="save">
                        Sportwagen
                    </button> 
                </a>

                <a href="uebersicht?typ=Limousine">
                    <button id="button1" class="icon-pencil" type="submit" name="action" value="save">
                        Limousine
                    </button> 
                </a>
                <a href="uebersicht?typ=Kleinwagen">
                    <button id="button1" class="icon-pencil" type="submit" name="action" value="save">
                        Kleinwagen
                    </button> 
                </a>
                <a href="uebersicht?typ=Transporter">
                    <button id="button1" class="icon-pencil" type="submit" name="action" value="save">
                        Transporter
                    </button> 
                </a>
                <a href="uebersicht?typ=Sonstige">
                    <button id="button1" class="icon-pencil" type="submit" name="action" value="save">
                        Sonstige
                    </button> 
                </a>
            </div> 
            
            <div class="flex-item">
              <c:forEach items="${autos}" var="auto">
                   <tr>     
                   <a href="details?id=${auto.getId()}">
                       <button id="button2" class="icon-pencil" type="submit" name="action" value="save">
                           <td>${auto.getMarke()}</td> 
                       </button>
                   </a>
                   </tr>
               </c:forEach>
           </div>
        </div>
        <!-- /.row -->






    </jsp:attribute>
</template:base>

