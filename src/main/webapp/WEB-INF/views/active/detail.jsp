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

<div class="placeholders row" style="padding-left: 10%;margin-right: 0px">
    <%-- 图片 --%>
    <div class="col-xs-6 col-sm-3 placeholder left-img" style="width: 50%">
        <c:if test="${publishGoods.img!=null}">
            <img src="${pageContext.request.contextPath }/img/${publishGoods.img}"
                 style="width: 100%;"
                 class="img-responsive" alt="Generic placeholder thumbnail">

        </c:if>
        <c:if test="${publishGoods.img==null}">
            <img src="${pageContext.request.contextPath }/img/1.jpg"
                 style="width: 100%;"
                 class="img-responsive" alt="Generic placeholder thumbnail">

        </c:if>
    </div>

    <div class="col-xs-6 col-sm-3 right-dec"
         style="position:relative;width: 50%;height:400px;padding-left: 10%;text-align: left">
        <%-- 标题 --%>
        <h3>
            ${publishGoods.title}
        </h3>
        <%-- 出售价 --%>
        <h4>
            <span class="span_red">
                ${publishGoods.sprice}
            </span>
        </h4>
        <%-- 原价 --%>
        <h4>
            <span class="span_gray;" style="text-decoration-line: line-through;color: gainsboro">
                原价：${publishGoods.oprice}
            </span>
        </h4>
        <%-- 买家信息 --%>
        <h4>
            买家信息：学生
        </h4>

        <div style="position: absolute;bottom: 20px">

            <c:if test="${collections.size() == 0 }">
                <a class="btn collectionB " _href="0">
                    <span class="collectionX glyphicon  glyphicon-star-empty" aria-hidden="true">

                    </span>
                </a>
            </c:if>
            <c:if test="${collections.size() >0 }">
                <a class="btn collectionB " _href="${collections.get(0).id}">
                <span class="collectionX glyphicon btn-danger glyphicon-star-empty" aria-hidden="true">

                </span>
                </a>
            </c:if>
            <%-- 发布时间 --%>
            <h4>

                发布于&nbsp;
                <fmt:formatDate value="${publishGoods.beginDate}" pattern="yyyy-MM-dd HH"/>
            </h4>
        </div>

        <div style="margin-top: 20%">
            <c:if test="${publishGoods.endDate == null}">
                <a class="btn btn-danger" href="${pageContext.request.contextPath }/deals/todeals?publishId=${publishGoods.id}">立即购买</a>
            </c:if>
            <c:if test="${publishGoods.endDate != null}">
                <a disabled="true" class="btn btn-danger" href="#">立即购买</a>
                <span class="span_red">
                    已经出售
                </span>
            </c:if>
        </div>

    </div>

</div>

<div class="placeholders row" style="margin-right: 0px;text-align: left;padding-left: 10%">

    <h2 class="page-header">商品描述</h2>
    <div>
        <p>
            ${publishGoods.goodsDescribe}
        </p>
    </div>

</div>

<div class="placeholders row" style="margin-right: 0px;text-align: left;padding-left: 10%">

    <h3 class="page-header">评价</h3>

    <form enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath }/publish/add"
          style="text-align: left;width: 90%">


        <div class="form-group">
            <label for="exampleFormControlTextarea1"></label>
            <textarea required
                      name="goodsDescribe" class="form-control mytextform"
                      id="exampleFormControlTextarea1" rows="3"></textarea>
        </div>

        <input type="hidden" name="ruserId" class="ruserId" value="${publishGoods.userId}">
        <input type="hidden" name="luserId" class="luserId" value="${userInfo.id}">
        <input type="hidden" name="publishId" class="publishId" value="${publishGoods.id}">
        <input type='hidden' name='luserName' class='luserName' value='${userInfo.userName}'>
        <div class="btn btn-primary mb-2 mytextformb">提交</div>
    </form>

    <div style="margin-top: 10px;
        margin-bottom:20px;
        padding-top:20px;
        border-top: gainsboro solid 1px;
        width: 70%"
         class="messageContainer">


        <c:forEach items="${messages}" var="list" varStatus="status">
            <div class='messages'>
                <h5>
                <span class="span_pink">
                        ${userInfo.userName}
                </span>
                </h5>
                <p>
                        ${list.message}
                </p>
                <div>
                    <fmt:formatDate value="${list.beginDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                    &nbsp;
                    <c:if test="${list.luserId != userInfo.id }">
                        <a class='btn btn-default responseButton' _href='${status.index}' role='button'>
                            回复
                        </a>
                    </c:if>
                    <form class='responseForm l${status.index}' enctype='multipart/form-data' method='post'
                          action='${pageContext.request.contextPath }/publish/add'
                          style='text-align: left;width: 90%'>

                        <div class='form-group'>
                            <label for='exampleFormControlTextarea1'></label>
                            <textarea required
                                      name='goodsDescribe' class='form-control mytextform'
                                      rows='3'></textarea>
                        </div>

                        <div class='btn btn-primary mb-2 mytextformb'>提交</div>
                    </form>
                </div>
            </div>


        </c:forEach>


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
        $(".responseForm").slideUp();
        var responseButton = $(".responseButton");

        responseButton.click(function (target) {

            var a = $(target.target);
            var hrefValue = a.attr("_href");

            $(".l" + hrefValue).slideToggle(500);
            console.log(hrefValue);

        })


    })

    function dateFormat(fmt, date) {
        var ret;
        var opt = {
            "Y+": date.getFullYear().toString(),        // 年
            "m+": (date.getMonth() + 1).toString(),     // 月
            "d+": date.getDate().toString(),            // 日
            "H+": date.getHours().toString(),           // 时
            "M+": date.getMinutes().toString(),         // 分
            "S+": date.getSeconds().toString()          // 秒
            // 有其他格式化字符需求可以继续添加，必须转化成字符串
        };
        for (var k in opt) {
            ret = new RegExp("(" + k + ")").exec(fmt);
            if (ret) {
                fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
            }
            ;
        }
        ;
        return fmt;
    }


</script>


<script>


    $(function () {
        //评价
        $(".mytextformb").click(function () {
            //要发送的数据
            var mytextform = $(".mytextform");
            var luserName = $(".luserName").attr("value");
            var ruserId = $(".ruserId").attr("value");
            var luserId = $(".luserId").attr("value");
            var publishId = $(".publishId").attr("value");
            var luserName=$(".luserName").attr("value");
            var message = mytextform.val().trim();
            //要插入的容器
            var messageContainer = $(".messageContainer");


            $.post(
                "${pageContext.request.contextPath }/messages/addmessages",
                {
                    ruserId: ruserId,
                    luserId: luserId,
                    publishId: publishId,
                    message: message,
                    messageType: 1,
                    luserName: luserName
                },
                function (data, status) {

                    if (status == "success") {
                        var messageContainer = $(".messageContainer");
                        var aa = "<h5><span class='span_pink'>";
                        aa = aa + luserName;
                        aa = aa + "</span></h5><p>"
                        aa = aa + message;
                        var date = new Date();
                        var dd = dateFormat("YYYY-mm-dd HH:MM", date)
                        aa = aa + "</p><div>" + dd;
                        messageContainer.prepend(aa);
                        mytextform.val("");

                    }

                    console.log(data);
                    console.log(status);

                }
            )


        });

        var collectionB = $(".collectionB");

        collectionB.click(function () {
            var hvalue = collectionB.attr("_href");
            //发送的数据
            var publishId = $(".publishId").attr("value");
            var userId = $(".luserId").attr("value");

            if (hvalue == 0) {
                $.post(
                    "${pageContext.request.contextPath }/collections/addCollection",
                    {
                        publishId: publishId,
                        userId: userId
                    },
                    function (data, status) {
                        if (status == "success") {
                            var collectionX = $(".collectionX");
                            collectionX.attr("class", "collectionX glyphicon btn-danger glyphicon-star-empty");

                            collectionB.attr("_href",data.data);
                        }
                    })

            } else {

                $.post(
                    "${pageContext.request.contextPath }/collections/delCollection",
                    {
                        id:hvalue
                    },
                    function (data, status) {
                        if (status == "success") {
                            var collectionX = $(".collectionX");
                            collectionX.attr("class", "collectionX glyphicon glyphicon-star-empty");
                            collectionB.attr("_href","0");
                        }
                    })



            }


        });


    })

</script>


</html>