<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>


    <title>Dashboard Template for Bootstrap</title>

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
<%--<c:import url="../importModel/nav.jsp">
</c:import>--%>


<%--<a href="/charges/tocharge" class="btn btn-primary mb-2">&DoubleLongLeftArrow;返回</a>--%>
<BR>
<BR>
<BR>
<BR>
<BR>
<div style="margin: auto">

    <div style="width: 30%;margin: auto">
        <div style="width: 230px;height:230px;margin: auto">
            <img class="qcodeimg" style="width: 230px;height:230px;margin: auto" src="${pageContext.request.contextPath }/charges/createQCode?totalMoney=${totalMoney}&trade_no=${chargeId}">
        </div>

        <div class="qcodemsg" style="margin: auto;width: 20%;text-align: center">
            请扫码
        </div>
    </div>

    <input class="chargeId" type="hidden" value="${chargeId}">


</div>


</body>

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

        var chargeId=$(".chargeId").attr("value");
        var coun=0;
        var intv=setInterval(function () {
            $.post(
                "${pageContext.request.contextPath }/charges/isDone",
                {
                    chargeId:chargeId
                },
                function (data,status) {

                    if(data == "SUCCESS"){
                        $(".qcodeimg").css("opacity","50%");
                        $(".qcodemsg").html("充值成功");
                        $(".qcodemsg").attr("class","qcodemsg span_red");
                        clearInterval(intv);

                    }

                    if(data == "FAIL"){
                        console.log("---"+chargeId);
                    }


                }
            );

        },3000);

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

</html>