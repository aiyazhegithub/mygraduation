<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>


</head>

<body>


<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">大学生自主交易系统 </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath }/hello">首页</a></li>
                <li><a href="${pageContext.request.contextPath }/users/person">个人信息</a></li>
                <li><a class="change"  _href="${pageContext.request.contextPath }/publish/tolist"  >发布商品</a></li>
                <li><a class="change" _href="${pageContext.request.contextPath }/charges/tocharge" >充值</a></li>
                <li class="dropdown navclick">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">分类<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li class="active">
                            <a _href="${pageContext.request.contextPath }/publish/list?">
                            最新商品<span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li>
                            <a _href="${pageContext.request.contextPath }/publish/list?type=1">闲置数码</a>
                        </li>
                        <li>
                            <a _href="${pageContext.request.contextPath }/publish/list?type=2">校园代步</a>
                        </li>
                        <li>
                            <a _href="${pageContext.request.contextPath }/publish/list?type=3">电器日用</a>
                        </li>
                        <li>
                            <a _href="${pageContext.request.contextPath }/publish/list?type=4">图书教材</a>
                        </li>
                        <li>
                            <a _href="${pageContext.request.contextPath }/publish/list?type=5">美妆衣物</a>
                        </li>
                        <li>
                            <a _href="${pageContext.request.contextPath }/publish/list?type=6">运动棋牌</a>
                        </li>
                        <li>
                            <a _href="${pageContext.request.contextPath }/publish/list?type=7">其他</a>
                        </li>
                    </ul>
                </li>
                <li >
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">操作<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li >
                            <a href="${pageContext.request.contextPath }/logout">
                                退出
                            </a>
                        </li>
                    </ul>
                 </li>

            </ul>
            <!-- 查询表单 -->
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="搜索">
            </form>
        </div>
    </div>
</nav>

</body>
</html>
