<%--
  Created by IntelliJ IDEA.
  User: zm
  Date: 2018/5/22
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:if  test="${pageInfo.pages == 0}">
    <table class="table table-striped">
        <tr><td>暂无数据</td></tr>
    </table>
</c:if>

<c:if  test="${pageInfo.pages != 0}">
    <table  class="table table-striped  table-bordered text-center">
        <tr >
            <th class="text-center">编号</th>
            <th class="text-center">学号</th>
            <th class="text-center">姓名</th>
            <th class="text-center">性别</th>
            <th class="text-center">出生日期</th>
            <th class="text-center">年级</th>
            <th class="text-center">照片</th>
            <th class="text-center">操作</th>
        </tr>
        <c:forEach items="${ pageInfo.getList()}" var="Student" varStatus="stuStus">
            <tr>
                <td>${stuStus.index + 1}</td>
                <td>${Student.stuId}</td>
                <td>${Student.stuName}</td>
                <td>${Student.stuSex}</td>
                <td><fmt:formatDate value="${Student.stuBirthday}" pattern="yyyy年MM月dd日"></fmt:formatDate> </td>
                <td>${Student.gradeName}</td>
                <td><img src="statics/uploadfiles/${Student.stuPic}"  width="25px" height="25px"></td>
                <td>
                    <a href="javascript:;" class="btn btn-default" data-toggle="modal" data-target="#exampleModal"  data-whatever="${Student.stuId}">修改</a>
                    <a href="javascript:;" onclick="delStu(${Student.stuId})" class="btn btn-default">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <%-- 页码--%>
    <div class="row">
            <div class="col-md-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination">


                        <li><a href="javascript:;"  onclick="nav(1)">首页</a></li>

                        <c:if test="${!pageInfo.isFirstPage}">
                            <li> <a href="javascript:;"  onclick="nav(${pageInfo.pageNum - 1})">上一页</a></li>
                        </c:if>


                        <c:forEach begin="1" end="${pageInfo.pages}" var="i">
                            <li> <a href="javascript:;"  onclick="nav(${i})"> ${i}</a></li>
                        </c:forEach>

                        <c:if test="${!pageInfo.isLastPage}">
                            <li> <a href="javascript:;"  onclick="nav(${pageInfo.pageNum + 1})">下一页</a></li>
                        </c:if>

                        <li><a href="javascript:;"  onclick="nav(${pageInfo.pages})">尾页</a></li>



                    </ul>
                </nav>
            </div>
            <div class ="col-md-2">
                第 ${pageInfo.pageNum}页 / 共 ${pageInfo.pages} 页
            </div>
    </div>


</c:if>




