<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ include file="include/importTags.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 04-12-19
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="album py-5">
    <div class="container">

        <div class="row">
            <c:forEach items="${ListArticle.keySet()}" var="ligne" varStatus="i">
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="${ligne.getImage()}" alt="${ligne.getNom()}">
                        <div class="card-body">
                            <p class="card-text">${ligne.getDescription()}</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <form id="delete" action="/CheminDeTraverse/caddie/remove/${ligne.getId()}" method="get">
                                    <button type="submit" value="Submit">supprimer</button>
                                </form>
                                <button type="button" class="btn btn-sm btn-outline-secondary" onclick="window.location.href ='<c:url value="/produit_info/${ligne.getId()}"/>'"><spring:message code="modifieQuantite"/></button>
                                <small class="text-muted">${ListArticle.get(ligne)} X ${ligne.getPrix()}€ = ${ListArticle.get(ligne)*ligne.getPrix()}€</small>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <sec:authorize access="isAuthenticated()">
                <c:if test="${!ListArticle.isEmpty()}">
                    <%--
                    <form:form method="post" modelAttribute="ListArticle" action="https://www.sandbox.paypal.com/cgi-bin/webscr%22%3E">
                        <form:button><spring:message code="paid"/></form:button>
                        <form:hidden path="business" value="@business.example.com"/>
                        <form:hidden path="password" value=""/>
                        <form:hidden path="cert_id" value=""/>
                        <form:hidden path="amount" value=""/>
                        <form:hidden path="cmd" value="_xclick"/>
                        <form:hidden path="currency_code" value="EUR"/>
                    </form:form>
                    --%>
                </c:if>
            </sec:authorize>
        </div>
    </div>
</div>
</body>
</html>
