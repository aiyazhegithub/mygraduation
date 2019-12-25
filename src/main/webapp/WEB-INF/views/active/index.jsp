<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <title>大学生自主交易系统</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${pageContext.request.contextPath }/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath }/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${pageContext.request.contextPath }/assets/js/ie-emulation-modes-warning.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/ie-emulation-modes-warning.js"></script>

</head>


<body>

<%-- 导航栏 --%>
<c:import url="./importModel/nav.jsp">
</c:import>
<div class="container-fluid">
    <div class="row">
        <!-- 左边导航 -->
        <div class="col-sm-3 col-md-2 sidebar navclick">
            <ul class="nav nav-sidebar">
                <li class="active"><a _href="${pageContext.request.contextPath }/publish/list?">最新商品<span class="sr-only">(current)</span></a></li>
                <li><a _href="${pageContext.request.contextPath }/publish/list?type=1">闲置数码</a></li>
                <li><a _href="${pageContext.request.contextPath }/publish/list?type=2">校园代步</a></li>
                <li><a _href="${pageContext.request.contextPath }/publish/list?type=3">电器日用</a></li>
                <li><a _href="${pageContext.request.contextPath }/publish/list?type=4">图书教材</a></li>
                <li><a _href="${pageContext.request.contextPath }/publish/list?type=5">美妆衣物</a></li>
                <li><a _href="${pageContext.request.contextPath }/publish/list?type=6">运动棋牌</a></li>
                <li><a _href="${pageContext.request.contextPath }/publish/list?type=7">其他</a></li>
            </ul>

        </div>

        <!-- 右边内容页面 -->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"
             >

            <div class="row placeholders">

                <iframe class="ifra" width="100%" height="650px" scrolling="yes"
                        src="${pageContext.request.contextPath }/publish/list"
                        frameborder="0">

                </iframe>


            </div>


        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script>window.jQuery || document.write('<script src="${pageContext.request.contextPath }/assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="${pageContext.request.contextPath }/dist/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="${pageContext.request.contextPath }/assets/js/vendor/holder.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="${pageContext.request.contextPath }/assets/js/ie10-viewport-bug-workaround.js"></script>



<script>
    $(function () {
        $(".navclick").click(function (target) {

            var aa=$(target.target);

            var url=aa.attr("_href");

            var adasdas;
            if(url==adasdas){
                console.log("---")
            }else{
                var ifra=$(".ifra");

                $(".active").attr("class","");

                var parent=aa.parent();

                parent.attr("class","active");

                ifra.attr("src",url);
            }


        });


        $(".change").click(function (target) {

            var aa=$(target.target);

            var url=aa.attr("_href");

            var adasdas;
            if(url==adasdas){
                console.log("---")
            }else{
                var ifra=$(".ifra");

                ifra.attr("src",url);
            }


        });

    })

</script>
</body>
</html>
