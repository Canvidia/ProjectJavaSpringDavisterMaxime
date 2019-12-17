<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 04-12-19
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container  text-center">
        <div class="card mb-4 shadow-sm">
            <img src="${article.getImage()}" alt="${article.getNom()}">
            <div class="card-body">
                <p class="card-text">${article.getDescription()}</p>
                <div class="d-flex justify-content-between align-items-center">

                    <form:form  id="form"
                                method="post"
                                action="/CheminDeTraverse/produit_info/send/${article.getId()}"
                                modelAttribute="nouvelleLigne">
                        <form:label path="quantite"><spring:message code="quantite"/> </form:label>
                        <form:input path="quantite"></form:input>
                        <form:errors path="quantite"></form:errors>
                        <br>
                        <form:button><spring:message code="valider"/> </form:button>
                    </form:form>


                    <small class="text-muted">${article.getPrix()}€</small>
                </div>
            </div>
        </div>
</div>

</body>
</html>
