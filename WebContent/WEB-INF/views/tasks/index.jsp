<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
<c:param name="content">


<h2>現行タスク</h2>

<p>

タスク名:
開始日:
完了予定日:
優先順位
</p>

<c:forEach var="nowtasks" items="${nowtasks }">


<li>
<a href="${pageContext.request.contextPath }/show?id=${nowtasks.id}"><c:out value="${nowtasks.title }"/></a>：
<c:out value="${nowtasks.startdate}"/>～
<c:out value="${nowtasks.finishdate}"/>：
<c:out value="${nowtasks.priority}"/>


</li>


</c:forEach>

</tbody>


<h2>完了済みタスク</h2>

<c:forEach var="finishtasks" items="${finishtasks }">
<li>


<a href="${pageContext.request.contextPath }/show?id=${finishtasks.id}"><c:out value="${finishtasks.title }"/></a>


</li>
</c:forEach>

<p><a href="${pageContext.request.contextPath}/new">新規タスクの登録
</a>
</c:param>
</c:import>