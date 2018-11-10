<!DOCTYPE html>
 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
  </head>
  <body>
    <%=request.getAttribute("message")%></ br>
    current_delay:<%=request.getAttribute("current_delay")%></ br>
    current_interval:<%=request.getAttribute("current_interval")%>

    <f:form modelAttribute="rescheduleForm" action="reschedule" method="post">
      <div>interval:<input type="text" id="interval" name="interval"></div>
      <div>delay:<input type="text" id="delay" name="delay"></div>
      <div><input type="submit" value="reschedule"></div>
    </f:form>
  </body>
</html>