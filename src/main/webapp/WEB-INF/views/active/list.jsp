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


<div class="placeholders" style="overflow: hidden">

    <c:forEach items="${pageInfo.list}" var="list">
        <a href="${pageContext.request.contextPath }/list/todetail?id=${list.id}" target="_blank">
            <div class="col-xs-6 col-sm-3 placeholder" style="height: 207px">
                <%-- 图片--%>
                <c:if test="${list.img!=null}">
                    <img src="${pageContext.request.contextPath }/img/${list.img}"
                         style="width: 200px;height: 136px"
                         class="img-responsive" alt="Generic placeholder thumbnail">

                    <%--  上线后的图片地址 --%>
                   <%-- <img src="https://www.nihaostillme.site:81/imgs/${list.img}"
                         style="width: 200px;height: 136px"
                         class="img-responsive" alt="Generic placeholder thumbnail">
--%>

                </c:if>
                <c:if test="${list.img==null}">
                    <img src="/img/11.jpg"
                         style="width: 200px;height: 136px"
                         class="img-responsive" alt="Generic placeholder thumbnail">
                </c:if>
                    <%-- 描述--%>
                <div style="overflow: hidden;height: 30px">
                    <h4>${list.title}<span class="span_red">&nbsp;${list.sprice}￥</span></h4>
                </div>
                <div style="overflow: hidden;height: 37px">
                    <span class="text-muted">${list.goodsDescribe}</span>
                </div>

            </div>
        </a>
    </c:forEach>





</div>

<div class="placeholders " style="width: 100%">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="/list/page?type=${type}&page=1">
                    首页
                </a>
            </li>

            <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                <%-- 是否等于当前页 --%>
                <c:if test="${pageNum==pageInfo.pageNum}">
                    <li class="page-item active">
                        <a class="page-link" href="${pageContext.request.contextPath }/list/page?type=${type}&page=${pageNum}">
                                ${pageNum}
                        </a>
                    </li>
                </c:if>
                <c:if test="${pageNum!=pageInfo.pageNum}">
                    <li class="page-item">
                        <a class="page-link" href="${pageContext.request.contextPath }/list/page?type=${type}&page=${pageNum}">
                                ${pageNum}
                        </a>
                    </li>
                </c:if>
            </c:forEach>

            <li class="page-item">
                <a class="page-link" href="${pageContext.request.contextPath }/list/page?type=${type}&page=${pageInfo.pages}">
                    末页
                </a>
            </li>
        </ul>
    </nav>
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




    })


</script>

</html>