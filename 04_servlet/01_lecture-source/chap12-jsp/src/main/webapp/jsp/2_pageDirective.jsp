<!-- 지시자 태그는 page, include, taglib 지시자 태그가 있다. -->

<%@ page contentType="text/html;charset=UTF-8" language="java"
    import="java.util.Date, java.util.ArrayList"  errorPage="errorPage.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Date date = new java.util.Date();
        System.out.println(date);

        String str = null;
        char ch = str.charAt(0);
    %>
</body>
</html>
