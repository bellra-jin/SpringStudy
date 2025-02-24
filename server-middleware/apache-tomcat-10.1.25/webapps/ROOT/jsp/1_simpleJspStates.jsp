<%--페이지 지시자 태그--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- html 주석 -->
    <%-- jsp 주석 --%>

    <!-- 선언 태그 -->
    <!-- 서블릿으로 변환 시 선언 태그 내에 작성한 내용을 필드로 선언한다. -->
    <%!
        private String name;
        private int age;
    %>

    <!-- scriptlet 태그 -->
    <!-- 간단한 자바 코드를 작성할 수 있는 부분이다. -->
    <%
        // 자바 코드를 작성할 수 있음
        /** 자바코드로 해석되기 때문에
         * 자바에[서 사용하는 주석을 그대로 사용할 수 있다.
         */

        name = "홍길동";
        age = 20;

        System.out.println("name = " + name);
        System.out.println("age = " + age);
    %>

    <!-- expression 태크 -->
    name : <%= name %> <br>
    age : <%= age %>  <br>

</body>
</html>
