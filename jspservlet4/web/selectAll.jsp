<%--
  Created by IntelliJ IDEA.
  User: ChenZhiKang
  Date: 2018/8/16
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>全部书籍</title>
    <style type="text/css">
        .onebook{
            width: 200px;
            border: 1px solid grey;
            float: left;
            margin: 10px;
        }
        .bookname{
            display: block;
            text-align:center;
        }
        .bookauthor{
            display: block;
            text-align:center;
        }
        .onebook:hover{
            cursor: pointer;
            border: 1px solid red;
        }
        .onebook:hover>.bookname{
            text-decoration: underline;
        }
        .onebook:hover>.bookauthor{
            text-decoration: underline;
        }
        .price{
            text-align:center;
        }
        .newprice{
            font-size: 20px;
            color: red;
        }
        .oldprice{
            font-size: 12px;
            color: darkgray;
            text-decoration: line-through;
        }
        .onebook:hover>.price>.newprice{
            text-decoration: underline;
        }
    </style>
    <script src="js/jquery-3.3.1.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            var books = $(".bookname");
            for (var i = 0; i < books.length; i++){
                var bookname = books.eq(i).attr("title");
                if (bookname.length > 10){
                    books.eq(i).html(bookname.substring(0,10)+"...");
                } else {
                    books.eq(i).html(bookname);
                }
            }
            var authors = $(".bookauthor");
            for (var i = 0; i < authors.length; i++){
                var author = authors.eq(i).attr("title");
                if (author.length > 10){
                    authors.eq(i).html(author.substring(0,10)+"...");
                } else {
                    authors.eq(i).html(author);
                }
            }
        });
    </script>
</head>
<body>
<c:forEach var="book" items="${allBook}">

    <div class="onebook">
        <img src="${book.image_b}">
        <span class="bookname" title="${book.bname}"></span>
        <span class="bookauthor" title="${book.author}"></span>
        <div class="price">
            <span class="newprice">￥${book.currPrice}</span>
            <span class="oldprice">￥${book.price}</span>
        </div>
    </div>
</c:forEach>
</body>
</html>
