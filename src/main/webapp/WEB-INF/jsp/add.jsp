<%--
  Created by IntelliJ IDEA.
  User: zm
  Date: 2018/5/22
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加页面</title>
    <link rel="stylesheet"  href="statics/css/bootstrap.css"  >
    <script src="/statics/calendar/WdatePicker.js"></script>

</head>
<body>
    <div class="container">
        <h1>学员添加</h1>
        <hr/>
        <form id="addform" enctype="multipart/form-data" method="post" class="form-horizontal">
            <div class="form-group">
                <label for="stuName" class="col-sm-2 control-label">姓名:</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="stuName" required name="stuName"  placeholder="姓名">
                </div>
            </div>
            <div class="form-group">
                <label for="stuSex" class="col-sm-2 control-label">性别:</label>
                <div class="col-sm-10">
                    <div class="radio">
                        <input type="radio"  id="stuSex1" value="男" name="stuSex"  checked>男
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio"   id="stuSex"  value="女" name="stuSex" >女
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="stuBirthday" class="col-sm-2 control-label">出生日期:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="stuBirthday" onClick="WdatePicker()"  name="stuBirthday"  placeholder="出生日期">
                </div>
            </div>
            <div class="form-group">
                <label for="stuGradeId" class="col-sm-2 control-label">年级:</label>
                <div class="col-sm-10">
                    <select name="stuGradeId" id="stuGradeId"  class="form-control">
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="pic" class="col-sm-2 control-label">照片:</label>
                <div class="col-sm-10">
                    <input type="file" class="form-control" id="pic" name="pic"  placeholder="照片">

                </div>
            </div>

            <div class="form-group text-center"  >
                <input type="button" name="" class="btn btn-default" value="添加" id="btnAdd">
                <input type="reset" name="" class="btn btn-default" value="重置">
                <input type="button" name=""  class="btn btn-default" onclick="javascript:history.back();" value="返回"></p>
            </div>
        </form>
    </div>





    <script src="/statics/js/jquery-1.12.4.js"></script>
    <script src="/statics/js/jquery-form.js"></script>
    <script src="/statics/js/add.js"></script>

</body>
</html>
