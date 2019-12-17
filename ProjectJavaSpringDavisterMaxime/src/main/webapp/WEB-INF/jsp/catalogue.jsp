<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ include file="include/importTags.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 03-12-19
  Time: 10:13
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
            <c:forEach items="${articles}" var="article" varStatus="i">
            <div class="col-md-4">
                <div class="card mb-4 shadow-sm">
                    <img src="${article.getImage()}" alt="${article.getNom()}">
                    <div class="card-body">
                        <p class="card-text">${article.getDescription()}</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button type="button" class="btn btn-sm btn-outline-secondary" onclick="window.location.href ='<c:url value="/produit_info/${article.getId()}"/>'"><spring:message code="voirProduit"/></button>
                            </div>
                            <small class="text-muted">${article.getPrix()}€</small>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
