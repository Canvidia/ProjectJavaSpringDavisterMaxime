<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap-grid.css'/>">
    <link rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap-reboot.css'/>">
    <link rel="stylesheet" href="<c:url value='/bootstrap/css/background.css'/>">
    <title>${title}</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <spring:message code="welcome"/> ${username}
</sec:authorize>
<nav class="navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Chemin de Traverse</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample02" aria-controls="navbarsExample02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExample02">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/CheminDeTraverse/"><spring:message code="accueil" /> </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/CheminDeTraverse/infos"><spring:message code="info"/> </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/CheminDeTraverse/caddie"><spring:message code="caddie"/> </a>
            </li>
        </ul>
        <spring:url var="localeFr" value="">
            <spring:param name="locale" value="fr"/>
        </spring:url>
        <spring:url var="localeEn" value="">
            <spring:param name="locale" value="en"/>
        </spring:url>

        <a href='${localeFr}'><img src="<c:url value ='/image/drapeau_francais.png'/>" height="42" width="42"/></a>
        <a href='${localeEn}'><img src="<c:url value='/image/icone-drapeau-anglais.png'/>" height="42" width="42"/></a>
        <sec:authorize access="!isAuthenticated()">
            <a class="nav-link" href="/CheminDeTraverse/login"><spring:message code="connection"/> </a>
            <a class="nav-link" href="/CheminDeTraverse/inscription"><spring:message code="inscription"/> </a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <a class="nav-link" href="/CheminDeTraverse/logout"><spring:message code="deconnection"/> </a>
        </sec:authorize>

    </div>
</nav>

    <div>
        <tiles:insertAttribute name = "main-content" />
    </div>

</body>
</html>