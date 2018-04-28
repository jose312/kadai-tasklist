<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>タスク編集ページ</h2>

        <form method="POST" action="${pageContext.request.contextPath}/update">
            <c:import url="_form.jsp" />
        </form>

        <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p>




<p><a href="#" onclick="confirmDestroy();">タスクを削除する</a></p>
<form method="POST" action="${pageContext.request.contextPath}/destroy">
    <input type="hidden" name="_token" value="${_token}" />
</form>
<script>
    function confirmDestroy() {
        if(confirm("本当に削除してよろしいですか？")) {
            document.forms[1].submit();


        }
    }


</script>

<c:choose>
<c:when test="${tasks.finish_flag == 0 }">
            <form method="POST" action="${pageContext.request.contextPath}/finish">

                <input type="hidden" name="_token" value="${_token}" />

                <button type="submit">完了済みリストに移動</button>
            </form>
            </c:when>
            <c:otherwise>
            <form method="POST" action="${pageContext.request.contextPath}/now">

                <input type="hidden" name="_token" value="${_token}" />

                <button type="submit">現行リストに移動</button>
                </form>
            </c:otherwise>
            </c:choose><br/><br/>
    </c:param>

</c:import>