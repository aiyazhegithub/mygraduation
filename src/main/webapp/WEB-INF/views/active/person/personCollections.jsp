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

<h2 class="sub-header">收藏列表</h2>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>商品名称</th>
            <th>商品价格</th>
            <th>商品描述</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${collections}" var="list" varStatus="status">
            <tr class="t${status.index}">
                <td>
                    <a href="${pageContext.request.contextPath }/list/todetail?id=${list.publishGoods.id}" target="_blank">
                        <div style="float: left">
                            <img src="${pageContext.request.contextPath }/img/${list.publishGoods.img}" style="height: 110px">
                        </div>
                    </a>
                    <c:if test="${list.publishGoods.endDate!=null}">
                        <span class="span_red" style="line-height: 110px">已经出售</span>
                    </c:if>
                </td>
                <td style="line-height: 110px">
                        ${list.publishGoods.title}
                </td>
                <td style="line-height: 110px">
                        <span class="span_red">
                                ${list.publishGoods.sprice}
                        </span>
                </td>
                <td style="line-height: 110px">
                        ${list.publishGoods.goodsDescribe}
                </td>
                <td>
                    <div class="cdel btn btn-default" _href="${status.index}" _value="${list.id}">删除</div>
                </td>
            </tr>

        </c:forEach>


        </tbody>
    </table>
</div>


</body>

<!-- Placed at the end of the document so the pages load faster -->
<script>window.jQuery || document.write('<script src="${pageContext.request.contextPath }/assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="${pageContext.request.contextPath }/dist/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="${pageContext.request.contextPath }/assets/js/vendor/holder.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="${pageContext.request.contextPath }/assets/js/ie10-viewport-bug-workaround.js"></script>

<script>
    $(function () {

        $(".cdel").click(function (target) {
            var cdel=$(target.target);
            var id=cdel.attr("_value");
            $.post(
                "${pageContext.request.contextPath }/collections/delCollection",
                {
                    id:id
                },
                function (data,status) {

                    if(status=="success"){
                        console.log(id);
                        var dref=cdel.attr("_href");
                        $(".t"+dref).remove();
                    }

                }
            );
            
        });
        
        
        
    })

</script>


</html>