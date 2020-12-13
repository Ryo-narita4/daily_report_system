<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります<br />
        <c:forEach var="error" items="${errors}">
        ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<p>企業名<br />
<p><c:out value="${company.name}"></c:out><p>
<br /><br />

<label for="title">タイトル</label><br />
<input type="text" name="title" value="${business.title}" />
<br /><br />

<label for="content">商談内容</label><br />
<textarea name="content" rows="10" cols="50">${business.content}</textarea>
<br /><br />

<label for="plan">次回打合せ日</label><br />
<input type="date" name="plan" value="<fmt:formatDate value='${business.plan}' pattern='yyyy-MM-dd' />" />
<br /><br />

<input type="reset" value="リセットする" />&nbsp;&nbsp;
<input type="hidden" name="_token" value="${_token}" /> <%--CSRF対策--%>
<button type="submit">投稿</button>
