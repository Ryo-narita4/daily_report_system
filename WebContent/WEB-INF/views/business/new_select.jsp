<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>企業を選択してください</h2>
            <c:forEach var="company" items="${companies}" varStatus="status">
                <p><a href="<c:url value='/business/new?id=${company.id}' />"><c:out value="${company.name}" /></a></p>
            </c:forEach>

            <div id="pagenation">
                (全 ${companies_count} 件)<br />
                <c:forEach var="i" begin="1" end="${((companies_count - 1) / 15) + 1 }" step="1">
                    <c:choose>
                        <c:when test="${i == page}">
                            <c:out value="${i}" />&nbsp;
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value='/business/new_select?page=${i}' />"><c:out value="${i}" /></a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>

            <p><a href="<c:url value='/company/new' />">商談先企業の追加</a></p>

            <p><a href="<c:url value='/business/index' />">商談一覧に戻る</a></p>

    </c:param>

</c:import>