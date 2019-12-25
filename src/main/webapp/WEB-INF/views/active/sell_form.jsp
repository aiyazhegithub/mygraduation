<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Dashboard Template for Bootstrap</title>


    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${pageContext.request.contextPath }/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath }/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${pageContext.request.contextPath }/assets/js/ie-emulation-modes-warning.js"></script>

    <script type='text/javascript'
            src='${pageContext.request.contextPath }/dist/js/textboxio.js'>

    </script>
    <%--<link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/css/example.css"/>--%>

</head>

<script>
    /*
    This function replaces all <textareas> on a page with
    instances of Textbox.io.
    */
    var instantiateTextbox = function () {
        textboxio.replaceAll('textarea', {
            paste: {
                style: 'clean'
            },
            css: {
                stylesheets: ['example.css']
            }
        });
    };

</script>
<script>
    /*
    This function gets the content from the instance of Textbox.io
    with the ID 'textbox'
    */
    var getEditorContent = function () {
        /*if (e && e.preventDefault) {
            e.preventDefault();
        } else {
            window.event.returnValue = false; //兼容IE
        }*/

        var editors = textboxio.get('#textbox');
        var editor = editors[0];
        $(".goodsDescribe").attr("value", editor.content.get());
        alert(editor.content.get().length)

    };
</script>

<body onload="instantiateTextbox();">

<%-- 导航栏 --%>


<!-- 表单开始 -->
<div style="width: 60%;margin: auto;margin-top: 70px">
    <span class="span_red">${data.msg}</span>
    <form enctype="multipart/form-data" method="post"
          action="${pageContext.request.contextPath }/publish/add"
          style="text-align: left;">
        <div class="form-group">
            <label for="exampleFormControlInput1">商品标题</label>
            <input required name="title" type="text" class="form-control" id="exampleFormControlInput1"
                   placeholder="商品标题">
        </div>
        <div class="form-group">
            <label for="exampleFormControlTextarea1">商品卖点</label>
            <textarea required name="goodsDescribe" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
        </div>
        <div class="form-group">
            <label for="exampleFormControlInput1">商品出售价格</label>
            <input required name="sprice" type="text" class="form-control" placeholder="商品价格">
        </div>
        <div class="form-group">
            <label for="exampleFormControlInput1">商品原价</label>
            <input required name="oprice" type="text" class="form-control" placeholder="商品原价">
        </div>
        <div class="form-group">
            <label for="exampleFormControlFile1">商品封面</label>
            <input name="uploadFile" type="file" class="form-control-file" id="exampleFormControlFile1">
        </div>
        <div class="form-group">
            <label>商品类型</label>
            <select required name="goodsType" class="form-control">
                <option value="1">闲置数码</option>
                <option value="2">校园代步</option>
                <option value="3">电器日用</option>
                <option value="4">图书教材</option>
                <option value="5">美妆衣物</option>
                <option value="6">运动棋牌</option>
                <option value="7">其他</option>
            </select>
        </div>

        <div class="form-group">
            <label for="textbox">商品描述</label>

            <textarea id="textbox" style="width: 100%; height: 400px;">

             </textarea>
        </div>

        <input class="goodsDescribe" type="hidden" name="goodsDescribe" value="">

        <button type="submit" class="btn btn-primary mb-2"
                onclick="javascript:getEditorContent();">
            提交
        </button>
    </form>
    <BR>
    <BR>
    <BR>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
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
</body>
</html>
