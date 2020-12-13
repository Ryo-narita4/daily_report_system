<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>商談状況一覧</h2>
        <table>
            <tbody>
                <tr>
                    <th>企業名</th>
                    <th>タイトル</th>
                    <th>商談内容</th>
                    <th>次回打合せ日</th>
                    <th>担当者</th>
                    <th>更新日</th>
                </tr>
                <c:forEach var="business" items="${businesses}" varStatus="status">
                    <tr>
                        <td><a href="<c:url value='/company/show?name=${business.company_name}' />"><c:out value="${business.company_name}" /></a></td>
                        <td><c:out value="${business.title}" /></td>
                        <td><a href="<c:url value='/business/show?id=${business.id}' />">詳細</a></td>
                        <td><fmt:formatDate value='${business.plan}' pattern='yyyy-MM-dd' /></td>
                        <td><c:out value="${business.employee.name}" /></td>
                        <td><fmt:formatDate value='${business.updated_at}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagenation">
            (全 ${businesses_count} 件)<br />
            <c:forEach var="i" begin="1" end="${((businesses_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/business/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>

        </div>
        <p><a href="<c:url value='/business/new_select' />">新規商談の登録</a></p>

    </c:param>
</c:import>