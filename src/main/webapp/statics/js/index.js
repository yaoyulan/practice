
$(function(){
   /* 窗体加载时查询*/
    nav(1);
});

/* 根据页码查询， 根据查询按钮查询  */
function nav(index){
    var data = $("#frmSeach").serialize() + "&pageIndex=" + index;

    $.ajax({
        type:"post",
        data:data,
        url:"/select",
        dataType:"html",
        success:function(data){
            $("#tabData").html(data);
        }
    });
}

/*删除*/
function delStu(stuId){
    $.ajax({
        type:"get",
        url:"/delete?stuId=" + stuId,
        dataType:"json",
        success:function(data){
            alert("删除成功！");
            nav(1);
        }
    });
}

/*  根据ID查询学生的信息*/
$('#exampleModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget);
    var stuId = button.data('whatever');



    /*窗体加载显示全部年级信息*/
    $.ajax({
        url:"/querygrade",
        dataType:"json",
        success:function(data){
            $("#stuGradeId").html();

            var str = "";
            for(var i = 0; i< data.length; i++){
                str += " <option value= "+ data[i].gradeid +">"+ data[i].gradename +"</option>";
            }
            $("#stuGradeId").html(str);
        }
    });

    $.ajax({
        type:"get",
        url:"/queryStuById?stuId=" + stuId,
        dataType:"json",
        success:function(data){
            $("#stuId").val(stuId);
            $("#stuName").val(data.stuName);
            if(data.stuSex == "女"){
                $("#stuSex").attr("checked",true);
            }else{
                $("#stuSex1").attr("checked",true);
            }
            //JS 将 时间戳格式更改为 年月日 （在日期函数中添加format 原型函数，详情看  dataformat.js）
            //var birthday = new Date(data.stuBirthday).format("yyyy-MM-dd");
            var birthday = new Date(data.stuBirthday).format("yyyy-MM-dd");
            $("#stuBirthday").val(birthday);
            $("#stuGradeId").val(data.stuGradeId);
            $("#picImg").attr("src","/statics/uploadfiles/" + data.stuPic);
        }
    });

})

/*修改学员信息*/
$("#btnAdd").click(function(){
    //实现表单验证
    if($("#stuName").val().length == 0){
        alert("用户名不能为空！");
        return ;
    }
    if($("#stuBirthday").val().length == 0){
        alert("出生日期不能为空！");
        return ;
    }


    //实现添加功能
    $("#updateform").ajaxSubmit({
        url:"/upStu",
        type:"post",
        dataType:"json",
        success:function (data) {
            if(data.result == "1"){
                alert("修改成功！");
                document.location.href = "/index.html"
            }else  if(data.result == "0") {
                alert(data.info);
                $("input[type='file']").next().html(data.info);
            }
        }
    })
});
