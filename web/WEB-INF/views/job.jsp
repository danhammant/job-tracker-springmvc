<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<%--
  Created by IntelliJ IDEA.
  User: danha
  Date: 25/09/2018
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
  <head>
    <title>Job Page</title>
    <style type="text/css">
      .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
      .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
      .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
      .tg .tg-4eph{background-color:#f9f9f9}
    </style>
  </head>
  <body>
    <h1>
      Add a Job
    </h1>


  <c:url var="addAction" value="/job/add"/>

  <form:form action="${addAction}" modelAttribute="job">
    <table>
      <c:if test="${not empty job.title}">
        <tr>
          <td>
            <form:label path="id">
              <spring:message text="Job ID"/>
            </form:label>
          </td>
          <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
          </td>
        </tr>
      </c:if>

      <tr>
        <td>
          <form:label path="title">
            <spring:message text="Title"/>
          </form:label>
        </td>
        <td>
          <form:input path="title"/>
        </td>
      </tr>

      <tr>
        <td>
          <form:label path="company">
            <spring:message text="Company"/>
          </form:label>
        </td>
        <td>
          <form:input path="company"/>
        </td>
      </tr>

      <tr>
        <td>
          <form:label path="location">
            <spring:message text="Location"/>
          </form:label>
        </td>
        <td>
          <form:input path="location"/>
        </td>
      </tr>

      <tr>
        <td>
          <form:label path="url">
            <spring:message text="URL"/>
          </form:label>
        </td>
        <td>
          <form:input path="url"/>
        </td>
      </tr>

      <tr>
        <td>
          <form:label path="status">
            <spring:message text="Status"/>
          </form:label>
        </td>
        <td>
          <form:input path="status"/>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <c:if test="${!empty job.title}">
            <input type="submit"
                   value="<spring:message text="Edit Job"/>" />
          </c:if>
          <c:if test="${empty job.title}">
            <input type="submit"
                   value="<spring:message text="Add Job"/>" />
          </c:if>
        </td>
      </tr>

    </table>
  </form:form>
  <br>

  <c:if test="${not empty jobList}">
    <h3><spring:message text="Job List"/></h3>
    <table class="empTable">
      <tr>
        <th width="80">ID</th>
        <th width="120">Title</th>
        <th width="120">Company</th>
        <th width="120">Location</th>
        <th width="120">URL</th>
        <th width="120">Status</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
      </tr>

      <c:forEach items="${jobList}" var="job">
        <tr>
          <td>${job.id}</td>
          <td>${job.title}</td>
          <td>${job.company}</td>
          <td>${job.location}</td>
          <td><a href="<c:url value='${job.url}'/>" >${job.url}</a></td>
          <td>${job.status}</td>
          <td><a href="<c:url value='/job/edit/${job.id}' />" >Edit</a></td>
          <td><a href="<c:url value='/job/remove/${job.id}' />" >Delete</a></td>
        </tr>
      </c:forEach>
    </table>
  </c:if>
  </body>
</html>
