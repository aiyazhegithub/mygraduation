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
<c:import url="./importModel/nav.jsp">
</c:import>
<BR>

<div class="row">
    <div style="margin: auto;width: 60%">&nbsp;</div>
    <div style="margin: auto;width: 60%">&nbsp;</div>
    <div style="margin: auto;width: 60%">&nbsp;</div>
    <div style="margin: auto;width: 60%;text-align: center">
            <span class="span_red">
                <c:if test="${totalData.msg!=null}">
                    ${totalData.msg}
                    <a  href="${pageContext.request.contextPath }/charges/tocharge" target="_self">充值</a>
                </c:if>
                <c:if test="${totalData.msg==null}">

                </c:if>
                         &nbsp;
            </span>
    </div>
    <div style="margin: auto;width: 60%">&nbsp;</div>
    <div style="margin: auto;width: 60%">&nbsp;</div>


    <div style="margin: auto;width: 80%;overflow: hidden;padding: 10px;background-color: #fff4e8">
        <div style="float: left">
            <img src="${pageContext.request.contextPath }/img/${publishGoods.img}" style="width: 150px">
        </div>
        <div style="float: left;margin-left: 20px">
            ${publishGoods.title}

        </div>
        <div style="float: left;margin-left: 150px">
            <span class="span_red">￥${publishGoods.sprice}</span>

        </div>
        <a href="${pageContext.request.contextPath }/deals/pay?publishId=${publishGoods.id}" class="btn btn-danger" style="float: right;margin-right: 150px">
            支付

        </a>
    </div>
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