<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
<c:param name="content">
<h2>タスク一覧</h2>
<ul>
<c:forEach var="tasks" items="${tasks }">
<li>
<a href="${pageContext.request.contextPath }/show?id=${tasks.id}">
<c:out value="${tasks.id }"/></a>

<c:out value="${tasks.title }"/>
</li>
</c:forEach>
</ul>
<p><a href="${pageContext.request.contextPath}/new">新規タスクの登録
</a>
</c:param>
</c:import>