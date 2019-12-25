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

<BR>

<div class="row">
    <div style="margin: auto;width: 60%">&nbsp;</div>
    <div style="margin: auto;width: 60%">&nbsp;</div>
    <div style="margin: auto;width: 60%">&nbsp;</div>
    <div style="margin: auto;width: 60%;text-align: center">
        <c:if test="${data.msg=='支付成功'}">
            <span class="span_red">
            ${data.msg}
            &nbsp;
                <a href="${pageContext.request.contextPath }/deals/list">
                查看
                </a>
            </span>
        </c:if>
        <c:if test="${data.msg=='发布成功'}">
            <span class="span_red">
            ${data.msg}
            &nbsp;
                 <a href="${pageContext.request.contextPath }/publish/listUserPublish">
                        查看
                 </a>
            </span>
        </c:if>

    </div>
    <div style="margin: auto;width: 60%">&nbsp;</div>
    <div style="margin: auto;width: 60%">&nbsp;</div>


</div>

</body>

<!-- Placed at the end of the document so the pages load faster -->
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="../../dist/js/bootstrap.min.js"></script>

<script src="../../assets/js/vendor/holder.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
<script>
    $(function () {


        $(".change").click(function (target) {

            var aa = $(target.target);

            var url = aa.attr("_href");

            var adasdas;
            if (url == adasdas) {
                console.log("---")
            } else {
                var ifra = $(".ifra");

                ifra.attr("src", url);
            }


        });

    })

</script>

</html>