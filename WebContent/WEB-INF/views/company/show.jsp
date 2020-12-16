<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${company != null}">
                <h2>企業情報</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>企業名</th>
                            <td><c:out value="${company.name}" /></td>
                        </tr>
                        <tr>
                            <th>所在地</th>
                            <td><c:out value="${company.address}" /></td>
                        </tr>
                        <tr>
                            <th>担当者または代表者</th>
                            <td><c:out value="${company.charge}" /></td>
                        </tr>
                        <tr>
                            <th>電話番号</th>
                            <td><c:out value="${company.tell}" /></td>
                        </tr>
                        <tr>
                            <th>メールアドレス</th>
                            <td><c:out value="${company.mail}" /></td>
                        </tr>
                    </tbody>
                </table>
                <p><a href="<c:url value='/company/edit?id=${company.id}' />">企業情報を編集する</a></p>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/business/index' />">一覧に戻る</a></p>
    </c:param>
</c:import>