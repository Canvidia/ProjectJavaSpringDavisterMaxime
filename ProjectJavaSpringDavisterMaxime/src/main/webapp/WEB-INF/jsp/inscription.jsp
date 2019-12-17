<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 18-11-19
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="bg-light">
    <form:form  id="form"
                method="post"
                action="/CheminDeTraverse/inscription/send"
                modelAttribute="nouvUtilisateur">
        <form:label path="username"><spring:message code="name"/></form:label>
        <form:input path="username"></form:input>
        <form:errors path="username"></form:errors>
        <br>
        <form:label path="password"><spring:message code="password"/> </form:label>
        <form:input path="password" type="password"></form:input>
        <form:errors path="password"></form:errors>
        <br>
        <form:label path="password"><spring:message code="password"/> </form:label>
        <form:input path="passwordValidation" type="password"></form:input>
        <form:errors path="passwordValidation"></form:errors>
        <br>
        <form:radiobutton path="sexe" value="f"/><spring:message code="femme"/>
        <form:radiobutton path="sexe" value="m"/><spring:message code="homme"/>
        <form:radiobutton path="sexe" value="a"/><spring:message code="autre"/>
        <br>
        <form:label path="maison"><spring:message code="maison"/> </form:label>
        <form:select path="maison">
            <form:option value="1" label="Griffondor"/>
            <form:option value="2" label="Serpentard" />
            <form:option value="3" label="serdaigle" />
            <form:option value="4" label="poufsouffle" />
        </form:select>
        <br>
        <form:label path="rue"><spring:message code="rue"/> </form:label>
        <form:input path="rue"></form:input>
        <form:errors path="rue"></form:errors>
        <br>
        <form:label path="numero"><spring:message code="numero"/></form:label>
        <form:input path="numero"></form:input>
        <form:errors path="numero"></form:errors>
        <br>
        <form:label path="telephonne"><spring:message code="telephone"/></form:label>
        <form:input path="telephonne"></form:input>
        <form:errors path="telephonne"></form:errors>
        <br>
        <form:label path="mail"><spring:message code="mail"/> </form:label>
        <form:input path="mail"></form:input>
        <form:errors path="mail"></form:errors>
        <br>
        <form:label path="patronus"><spring:message code="patronus"/> </form:label>
        <form:input path="patronus"></form:input>
        <form:errors path="patronus"></form:errors>
        <br>
        <form:button><spring:message code="valider"/> </form:button>
    </form:form>
</div>
</body>
</html>
