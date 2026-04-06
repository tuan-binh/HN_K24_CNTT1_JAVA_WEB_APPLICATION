<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: binh1
  Date: 4/6/2026
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách CNTT4</h1>
<%-- Chưa nói về JSTL Java Standard Tag Library --%>
<%-- Scriptlet --%>
<%-- <%= request.getAttribute("full_name") %> --%>

<%-- Sử dụng JSP --%>
<%--<%--%>
<%--    List<String> names = (List<String>) request.getAttribute("ds_cntt1");--%>
<%--    if (names != null) {--%>
<%--        for (String s : names) {--%>
<%--%>--%>
<%--<p><%= s %>--%>
<%--</p>--%>
<%--<%--%>
<%--        }--%>
<%--    }--%>
<%--%>--%>

<%-- Khi sử dụng JSTL --%>
<%-- items chính là mảng cần duyệt --%>

<table border="1" cellspacing="10" cellpadding="10">
    <thead>
    <tr>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ds_cntt1}" var="p">
        <tr>
            <td><c:out value="${p}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%--<c:forEach items="${ds_cntt1}" var="p">--%>
<%--    <c:if test="${p != 'Hoàng Cương Cát'}">--%>
<%--        <p><c:out value="${p}"/></p>--%>
<%--    </c:if>--%>

<%--</c:forEach>--%>

</body>
</html>
