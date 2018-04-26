<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<label for="title">タスク名</label><br />
<input type="text" name="title" value="${tasks.title}" />
<br /><br />

<label for="content">メッセージ</label><br />
<input type="text" name="content" value="${tasks.content}" />
<br /><br />

<label for="content_2">コメント</label><br />
<input type="text" name="content_2" value="${tasks.content_2}" />
<br /><br />



<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>