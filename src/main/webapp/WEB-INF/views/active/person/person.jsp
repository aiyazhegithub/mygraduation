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
<%-- 导航栏 --%>
<c:import url="../importModel/nav.jsp">
</c:import>

<div class="container-fluid">
    <div class="row">
        <!-- 左边导航 -->
        <div class="col-sm-3 col-md-2 sidebar navclick" style="text-align: center" >
            <ul class="nav nav-sidebar">
                <li class="active">
                    <div style="width: 80px;overflow: hidden;margin: auto;font-size: 15px">
                        <img src="${pageContext.request.contextPath }/img/11.jpg" style="width: 80px;border-radius: 50%;">
                        <span class="span_greed">
                            余额:${userInfo.money}￥
                        </span>
                    </div>
                    <BR>
                    <a _href="${pageContext.request.contextPath }/users/userInfo">
                        个人信息
                    </a>
                </li>
                <li>
                    <a _href="${pageContext.request.contextPath }/deals/list">
                        订单详情
                    </a>
                </li>
                <li>
                    <a _href="${pageContext.request.contextPath }/publish/listUserPublish">
                        我的发布
                    </a>
                </li>
                <li>
                    <a _href="${pageContext.request.contextPath }/collections/listUserCollections">
                        我的收藏
                    </a>
                </li>
                <BR>
            </ul>

        </div>

        <!-- 右边内容页面 -->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"
             >


            <div class="row placeholders" >

                <iframe class="ifra" width="100%" height="650px"  scrolling="yes"
                        src="${pageContext.request.contextPath }/users/userInfo"
                        frameborder="0">

                </iframe>












            </div>


        </div>
    </div>
</div>

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
