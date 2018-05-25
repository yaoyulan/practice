$(function(){

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



});


//添加按钮
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
      $("#addform").ajaxSubmit({
          url:"/addstu",
          type:"post",
          dataType:"json",
          success:function (data) {


              if(data.result == "1"){
                  alert("添加成功！");
                  document.location.href = "/index.html"
              }else  if(data.result == "0") {
                    alert(data.info);
                    $("input[type='file']").next().html(data.info);
              }
          }
      })
});





