<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
<c:param name="content">
<c:if test="${flush != null}">
    <div id="flush_success">
        <c:out value="${flush}"></c:out>
    </div>
</c:if>

<h2>現行タスク</h2>

<p>
タスク名:
開始日:
完了予定日:
優先順位：
最終更新
</p>

<c:forEach var="nowtasks" items="${nowtasks }">


<li>
<a href="${pageContext.request.contextPath }/show?id=${nowtasks.id}"><c:out value="${nowtasks.title }"/></a>：
<c:out value="${nowtasks.startdate}"/>～
<c:out value="${nowtasks.finishdate}"/>：
<c:out value="${nowtasks.priority}"/>：
<c:out value="${nowtasks.updated_at }"/>

</li>


</c:forEach>

<div id="pagination">
    （全 ${tasks_count} 件）<br />
    <c:forEach var="i" begin="1" end="${((tasks_count - 1) / 15) + 1}" step="1">
        <c:choose>
            <c:when test="${i == page}">
                <c:out value="${i}" />&nbsp;
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/index?page=${i}"><c:out value="${i}" /></a>&nbsp;
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>
<p><a href="${pageContext.request.contextPath}/new">新規タスクの登録
</a><br/><br/>

<h2>完了済みタスク</h2>
<p>
タスク名:
開始日:
完了予定日:
優先順位：
最終更新
</p>
<c:forEach var="finishtasks" items="${finishtasks }">

<li>
<a href="${pageContext.request.contextPath }/show?id=${finishtasks.id}"><c:out value="${finishtasks.title }"/></a>：
<c:out value="${finishtasks.startdate}"/>～
<c:out value="${finishtasks.finishdate}"/>：
<c:out value="${finishtasks.priority}"/>：
<c:out value="${finishtasks.updated_at }"/>



</li>
</c:forEach>

<div id="paginationf">
    （全 ${tasks_countf} 件）<br />
    <c:forEach var="i" begin="1" end="${((tasks_countf - 1) / 15) + 1}" step="1">
        <c:choose>
            <c:when test="${i == pagef}">
                <c:out value="${i}" />&nbsp;
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/index?pagef=${i}"><c:out value="${i}" /></a>&nbsp;
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>





</c:param>
</c:import>