<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${business != null}">
                <h2>商談内容 詳細</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>企業名</th>
                            <td><c:out value="${business.company_name}" /></td>
                        </tr>
                        <tr>
                            <th>タイトル</th>
                            <td><c:out value="${business.title}" /></td>
                        </tr>
                        <tr>
                            <th>商談内容</th>
                            <td><c:out value="${business.content}" /></td>
                        </tr>
                        <tr>
                            <th>次回打合せ日</th>
                            <td><fmt:formatDate value="${business.plan}" pattern="yyyy-MM-dd" /></td>
                        </tr>
                        <tr>
                            <th>担当者</th>
                            <td><c:out value="${business.employee.name}" /></td>
                        </tr>
                    </tbody>
                </table>

                <c:if test="${sessionScope.login_employee.id == business.employee.id}">
                    <p><a href="<c:url value='/business/edit?id=${business.id}' />">編集する</a></p>
                </c:if>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータはありませんでした</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/business/index' />">一覧に戻る</a></p>
    </c:param>
</c:import>