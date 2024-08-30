<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mission Orders</title>
</head>
<body>
    <h1>Mission Orders</h1>
    <ul>
        <c:forEach var="mission" items="${missions}">
            <li>
                Mission ID: ${mission.id} - ${mission.description}
                <c:choose>
                    <c:when test="${sessionScope.user.role == 'Supervisor'}">
                        <a href="<c:url value='/editMission'><c:param name='id' value='${mission.id}'/></c:url>">Edit</a>
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/viewMission'><c:param name='id' value='${mission.id}'/></c:url>">View</a>
                    </c:otherwise>
                </c:choose>
            </li>
        </c:forEach>
    </ul>
    <c:if test="${sessionScope.user.role == 'Super Admin'}">
        <a href="<c:url value='/createMission'/>">Create New Mission</a>
    </c:if>
</body>
</html>
