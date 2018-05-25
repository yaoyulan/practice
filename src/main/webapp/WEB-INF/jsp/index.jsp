<%--
  Created by IntelliJ IDEA.
  User: zm
  Date: 2018/5/22
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"   isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>查询页面</title>
    <meta charset="utf-8">
    <script src="/statics/calendar/WdatePicker.js"></script>
    <script src="/statics/js/dataformat.js"></script>
    <link rel="stylesheet"  href="statics/css/bootstrap.css"  />
</head>
<body>

<div class="container">
    <h1>学员信息查询</h1>
    <div class="row">
        <div class="col-md-2"><a href="add.html" class="btn btn-default" role="button">添加学员</a></div>
    </div>
    <hr/>

    <form id="frmSeach" class="form-inline">
        <div class="form-group">
            <label for="querystuName">学生姓名：</label>
            <input type="text" class="form-control"  name="querystuName" id="querystuName" placeholder="学生姓名">
        </div>
        <div class="form-group">
            <label for="gradeId">年级：</label>
            <select name="gradeId" id="gradeId" >
                <option value="0">全部</option>
                <c:forEach items="${grades}" var="grade" >
                    <option value="${grade.gradeid}">${grade.gradename}</option>
                </c:forEach>
            </select>
        </div>
        <input type="button" name=""  class="btn btn-default" value="搜索" onclick="nav(1)">
    </form>

    <%--显示数据和页码--%>
    <div id="tabData">
    </div>
</div>


<%--修改模态框--%>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">用户修改</h4>
            </div>
            <div class="modal-body">
                <form id="updateform" enctype="multipart/form-data" method="post" class="form-horizontal">
                    <input type="hidden" id="stuId" name="stuId"   />
                    <div class="form-group">
                        <label for="stuName" class="col-sm-2 control-label">姓名:</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="stuName" name="stuName"  placeholder="姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stuSex" class="col-sm-2 control-label">性别:</label>
                        <div class="col-sm-10">
                            <div class="radio">
                                <input type="radio"  id="stuSex1" value="男" name="stuSex" >男
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio"   id="stuSex"  value="女" name="stuSex" >女
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stuBirthday" class="col-sm-2 control-label">出生日期:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="stuBirthday" onClick="WdatePicker()" name="stuBirthday"  placeholder="出生日期">
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
                            <input type="file" class="form-control" id="pic" name="pic"   placeholder="照片">
                            <img  width="50px" height="50px"  id="picImg"/>
                        </div>
                    </div>
                    <div class="form-group text-center"  >
                        <input type="button" name="" class="btn btn-primary" value="修改" id="btnAdd">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    </div>
                </form>

            </div>

        </div>
    </div>
</div>

<script src="/statics/js/jquery-1.12.4.js"></script>
<script src="/statics/js/jquery-form.js"></script>
<script src="/statics/js/index.js"></script>
<script src="/statics/js/bootstrap.js"></script>

</body>
</html>
