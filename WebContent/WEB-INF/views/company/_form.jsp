<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります<br />
        <c:forEach var="error" items="${errors}">
        ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<label for="name">企業名</label><br />
<input type="text" name="name" value="${company.name}" />
<br /><br />

<label for="address">住所</label><br />
<input type="text" name="address" value="${company.address}" />
<br /><br />

<label for="tell">電話番号</label><br />
<input type="text" name="tell" value="${company.tell}" />
<br /><br />

<label for="mail">メールアドレス</label><br />
<input type="text" name="mail" value="${company.mail}" />
<br /><br />

<label for="charge">担当者または代表者</label><br />
<input type="text" name="charge" value="${company.charge }" />
<br /><br />

<input type="reset" value="リセットする" />&nbsp;&nbsp;
<input type="hidden" name="_token" value="${_token}" /> <%--CSRF対策--%>
<button type="submit">確定</button>
