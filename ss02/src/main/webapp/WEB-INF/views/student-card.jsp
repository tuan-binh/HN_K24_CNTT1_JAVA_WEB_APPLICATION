<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: binh1
  Date: 4/6/2026
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
        .green {
            color: green;
        }

        .blue {
            color: blue;
        }

        .orange {
            color: orange;
        }

        .red {
            color: red;
        }
    </style>
</head>
<body>

<c:if test="${student == null}">
    <p>Sinh viên không tồn tại</p>
</c:if>

<c:if test="${student != null}">
    <div>
        <p>ID: <c:out value="${student.id}"/></p>
        <p>Name: <c:out value="${student.fullName}"/></p>
        <p>Department: <c:out value="${student.department}"/></p>
        <p>Year Of Study: <c:out value="${student.yearOfStudy}"/></p>

<%--        <p class="--%>
<%--            <c:choose>--%>
<%--                <c:when test="${student.avgScore >= 8}">green</c:when>--%>
<%--                <c:when test="${student.avgScore >= 6.5}">blue</c:when>--%>
<%--                <c:when test="${student.avgScore >= 5}">orange</c:when>--%>
<%--                <c:when test="${student.avgScore <5}">red</c:when>--%>
<%--            </c:choose>--%>
<%--                ">--%>
<%--            Avg Score: <c:out value="${student.avgScore}"/></p>--%>
                        <c:choose>
                            <c:when test="${student.avgScore >= 8}">
                                <p class="green"><c:out value="${student.avgScore}"/></p>
                            </c:when>
                            <c:when test="${student.avgScore >= 6.5}">
                                <p class="blue"><c:out value="${student.avgScore}"/></p>
                            </c:when>
                            <c:when test="${student.avgScore >= 5}">
                                <p class="orange"><c:out value="${student.avgScore}"/></p>
                            </c:when>
                            <c:when test="${student.avgScore <5}">
                                <p class="red"><c:out value="${student.avgScore}"/></p>
                            </c:when>
                        </c:choose>
    </div>
</c:if>

</body>
</html>
