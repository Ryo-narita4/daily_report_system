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
<label for="company_name">企業名</label><br />
<input type="text" name="company_name" value="${business.company_name}" /> <%--新規登録の場合は入力した値がname=で指定した変数に代入され、editでは --%>
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

<label for="employee.name">担当者</label><br />
<input type="text" name="employee.name" value="${sessionScope.login_employee.name}" />
<br /><br />


<input type="reset" value="リセットする" />&nbsp;&nbsp;
<input type="hidden" name="_token" value="${_token}" /> <%--CSRF対策--%>
<button type="submit">投稿</button>
