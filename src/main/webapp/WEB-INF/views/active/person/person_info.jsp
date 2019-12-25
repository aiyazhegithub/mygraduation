<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>


    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${pageContext.request.contextPath }/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/css/dashboard.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath }/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${pageContext.request.contextPath }/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

<!-- 表单开始 -->
<div style="width: 60%;margin: auto">
    <h1 class="page-header">个人信息</h1>
    <form method="post" action="${pageContext.request.contextPath }/users/update" style="text-align: left;">

        <div class="form-group" style="width: 40%;">
            <label >名称</label>
            <input value="${userInfo.userName}" required name="userName" type="text" class="form-control"  placeholder="名称">
        </div>

        <div class="form-group" style="width: 50%;">
            <label >电话</label>
            <input value="${userInfo.phone}" required name="phone" type="tel" class="form-control" placeholder="电话">
        </div>
        <div class="form-group" style="width: 50%;">
            <label >邮箱</label>
            <div class="form-control">${userInfo.email}</div>
        </div>
        <div class="form-group" style="width: 50%;">
            <label>性别</label>
            <select required name="sex" class="form-control">
                <c:if test="${userInfo.sex=='男' }">
                    <option value="男" selected="true" >男</option>
                    <option value="女" >女</option>
                </c:if>
                <c:if test="${userInfo.sex=='女'}">
                    option value="男" >男</option>
                    <option value="女" selected="true">女</option>
                </c:if>
                <c:if test="${userInfo.sex==null }">
                    <option value="男" selected="true" >男</option>
                    <option value="女" >女</option>
                </c:if>
            </select>
        </div>

        <button type="submit" class="btn btn-primary mb-2">提交</button>
    </form>

</div>



</body>

<!-- Placed at the end of the document so the pages load faster -->
<script>window.jQuery || document.write('<script src="${pageContext.request.contextPath }/assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="${pageContext.request.contextPath }/dist/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="${pageContext.request.contextPath }/assets/js/vendor/holder.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="${pageContext.request.contextPath }/assets/js/ie10-viewport-bug-workaround.js"></script>

</html>