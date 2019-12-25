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

<!-- 表单开始 -->
<div style="width: 20%;margin: auto">
    <img style="width: 200px;margin: auto" src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575692741195&di=5baa6c8030de1d20bc94d9a7e5b189e8&imgtype=0&src=http%3A%2F%2Fwww.lgstatic.com%2Fthumbnail_600x360%2Fimage1%2FM00%2F3B%2FE8%2FCgYXBlWyBQWAKqxQAABGYbPqXLw817.png">

    <form action="${pageContext.request.contextPath }/charges/toqcode" style="text-align: left;">
        <br>
        <div class="form-group">
            <label >金额</label>
            <input required
                   name="totalMoney" type="" class="form-control"
                   placeholder="金额">
        </div>


        <button type="submit" class="btn btn-primary mb-2">提交</button>
    </form>

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