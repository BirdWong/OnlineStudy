<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<body>
<form id="fi" method="post" action="http://119.29.56.187/cas/login">
    用户名：<input name="username" value="admin"><br>
    密码：<input name="password" value="admin"><br>
    loginTicket：<input id="lt" class="lt" name="lt" type="text"><br>
    flowExecutionKey：<input id="execution" class="execution" name="execution" type="text"><br>
    _eventId：<input name="_eventId" value="submit" />
</form>
<input type="button" onclick="doLogin()" value="cas">
</body>
</html>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
    function doLogin(){
        $.ajax({
            url:"http://119.29.56.187:80/cas/login?action=getlt&callback=?",
            dataType:"jsonp",
            success:function(data){
                $("#lt").val(data.lt)
                $("#execution").val(data.execution)
                $("#fi").submit();
            }
        });
    }
</script>