<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1>Request Pramater</h1>
    <h3>GET 방식의 요청</h3>
    <h4>form 태그를 이용한 get 방식 요청</h4>
    <form action="querystring" method="get">
        <lable>이름 : </lable><input type="text" name="name">
        <br>
        <lable>나이 : </lable><input type="number" name="age">
        <br>
        <lable>생일 : </lable><input type="date" name="birthday">
        <br>
        <label>성별 : </label>
        <input type="radio" name="gender" id="male" value="M">
        <label for="male">남자</label>
        <input type="radio" name="gender" id="female" value="F">
        <label for="female">여자</label>
        <br>
        <label>국적 : </label>
        <select name="national">
            <option value="ko">한국</option>
            <option value="ch">중국</option>
            <option value="jp">일본</option>
            <option value="etc">기타</option>
        </select>
        <br>
        <lable>취미 : </lable>
        <input type="checkbox" name="hobbies" id="movie" value="movie">
        <label for="movie">영화</label>
        <input type="checkbox" name="hobbies" id="music" value="music">
        <label for="music">음악</label>
        <input type="checkbox" name="hobbies" id="sleep" value="sleep">
        <label for="sleep">취침</label>
        <br>
        <input type="submit" value="전송">
    </form>

    <h4>a 태그의 href 속성에 직접 파라미터를 쿼리스트링 형태로 작성하여 get 요청</h4>
    <a href="querystring?name=박진희&age=33&birthday=2024-07-05&gender=F&national=ko&hobbies=movie&&hobbies=music">
        쿼리스트링을 이용한 값 전달
    </a>

    <h4>form 태그를 이용한 post 방식 요청</h4>
    <form action="formdata" method="post">
        <lable>이름 : </lable><input type="text" name="name">
        <br>
        <lable>나이 : </lable><input type="number" name="age">
        <br>
        <lable>생일 : </lable><input type="date" name="birthday">
        <br>
        <label>성별 : </label>
        <input type="radio" name="gender" id="male2" value="M">
        <label for="male2">남자</label>
        <input type="radio" name="gender" id="female2" value="F">
        <label for="female2">여자</label>
        <br>
        <label>국적 : </label>
        <select name="national">
            <option value="ko">한국</option>
            <option value="ch">중국</option>
            <option value="jp">일본</option>
            <option value="etc">기타</option>
        </select>
        <br>
        <lable>취미 : </lable>
        <input type="checkbox" name="hobbies" id="movie2" value="movie">
        <label for="movie2">영화</label>
        <input type="checkbox" name="hobbies" id="music2" value="music">
        <label for="music2">음악</label>
        <input type="checkbox" name="hobbies" id="sleep2" value="sleep">
        <label for="sleep2">취침</label>
        <br>
        <input type="submit" value="전송">
    </form>

</body>
</html>