<%-- 
    Document   : template
    Created on : 12 févr. 2016, 14:46:38
    Author     : sebastien
--%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"  
        pageEncoding="UTF-8"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    <!DOCTYPE HTML>  
    <html>  
    <head>  
    <title>${param.title}</title>  
    <link rel="stylesheet" type="text/css"  
        href="${pageContext.request.contextPath}/resources/style.css" />  
    </head>  
    <body>  
        <jsp:include page="header.jsp"/>  
        <jsp:include page="menuDeroulant.jsp"/>  
          
        <h1>${param.title}</h1>  
      
        <jsp:include page="${param.content}.jsp"/>  
          
        <jsp:include page="footer.jsp"/>  
          
          
    </body>  
    </html>  