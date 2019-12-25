<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

  <title>Signin Template for Bootstrap</title>

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

</head>

<body>

<div class="container">

  <form action="${pageContext.request.contextPath }/sign" class="form-signin" method="post">
    <h2 class="form-signin-heading">创建账号</h2>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input name="username" type="email" id="inputEmail" class="form-control" placeholder="邮箱" required autofocus>

    <br>
    <label for="inputPassword" class="sr-only">Password</label>
    <input name="passwd" type="password" id="inputPassword" class="form-control" placeholder="密码" required>


    <div class="checkbox">
        <a href="${pageContext.request.contextPath }/tologin">已经有账号</a>
    </div>

    <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
  </form>

  <div style="width: 20%;margin: auto;text-align: center">
        <span class="span_red">
              ${data.msg}
        </span>

  </div>

</div> <!-- /container -->

</body>
</html>
