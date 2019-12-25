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

<h2 class="sub-header">订单详情</h2>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>商品标题</th>
            <th>出售价格</th>
            <th>商品原价</th>
            <th>商品类型</th>
            <th>创建时间</th>
            <th>是否售出</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${publishGoods}" var="list">
            <tr>
                <td>
                    <a href="${pageContext.request.contextPath }/list/todetail?id=${list.id}" target="_blank">
                            ${list.title}
                    </a>
                </td>
                <td>
                        ${list.sprice}
                </td>
                <td>
                        ${list.oprice}
                </td>
                <td>
                        ${list.goodsType}
                </td>
                <td>
                    <fmt:formatDate value="${list.beginDate}" pattern="yyyy-MM-dd HH"/>
                </td>
                <td>
                    <c:if test="${list.endDate !=null}">
                        <span class="span_red">
                            是
                        </span>
                    </c:if>
                    <c:if test="${list.endDate ==null}">
                        否
                    </c:if>
                </td>
                <td>

                <td class="inse">
                    <c:if test="${list.endDate !=null}">
                        <a class="btn btn-default" href="${pageContext.request.contextPath }/list/todetail?id=${list.id}" target="_blank">
                            查看
                        </a>
                    </c:if>
                    <c:if test="${list.endDate ==null && list.isdeal ==0}">
                        <div onclick="loaddown(${list.id})" class="btn btn-default loaddown loaddown${list.id}">
                            下架
                        </div>
                    </c:if>
                    <c:if test="${list.endDate ==null && list.isdeal !=0}">
                        <div class="btn btn-default">
                            已经下架
                        </div>
                    </c:if>
                </td>
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

    
    function loaddown(id) {
        var loaddown = $(".loaddown"+id);
        $.post(
            "${pageContext.request.contextPath }/publish/upisdeal",
            {
                publishGoodsId:id
            },
            function (data,status) {
                console.log(data=="SUCCESS");
                if(data=="SUCCESS"){


                    loaddown.html("已经下架");
                    loaddown.attr("onclick","");


                }

            });
        
    }

</script>

</html>