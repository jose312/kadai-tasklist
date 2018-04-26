<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <% request.setCharacterEncoding("UTF-8"); %>

        <h2>id : ${message.id} のタスク詳細ページ</h2>

        <p>タスク名：<c:out value="${tasks.title}" /></p>
        <p>メッセージ：<c:out value="${tasks.content}" /></p>
        <p>コメント：<c:out value="${tasks.content_2}" /></p>
        <p>作成日時：<fmt:formatDate value="${tasks.created_at}" pattern="yyyy-MM-dd HH:mm:ss" /></p>
        <p>更新日時：<fmt:formatDate value="${tasks.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" /></p>

        <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p>
<p><a href="${pageContext.request.contextPath}/edit?id=${tasks.id}">このタスクを編集する</a></p>
    </c:param>
</c:import>