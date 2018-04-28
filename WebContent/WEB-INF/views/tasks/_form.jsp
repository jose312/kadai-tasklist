<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>

<label for="title">タスク名</label><br />
<input type="text" name="title" value="${tasks.title}" />
<br /><br />

<label for="content">完了の基準</label><br />
<input type="text" name="content" value=" ${tasks.content }">
<br /><br />

<label for="content_2">メモ</label><br />
<textarea name="content_2" cols="50" rows="5">${tasks.content_2 }</textarea>
<br /><br />

<label for="startdate">タスク開始日</label><br/>
<input type="date" name="startdate" value="${tasks.startdate }">
<br/><br/>

<label for="startdate">タスク完了予定日</label><br/>
<input type="date" name="finishdate" value="${tasks.finishdate }">
<br/><br/>

<label for="priority">優先順位</label>
<select name="priority">
<option value="A">A</option>
<option value="B">B</option>
<option value="C">C</option>
</select>
<br/><br/>

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button><br/><br/>