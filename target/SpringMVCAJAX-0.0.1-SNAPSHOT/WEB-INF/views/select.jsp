<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</head>
<body>
<label for="provinceSelector">省份:</label>
<select class="form-control" id="provinceSelector">
    <option>请选择省份....</option>
    <c:forEach items="${provinceList}" var="pro">
        <option value="${pro.provinceId}">${pro.provinceName}</option>
    </c:forEach>
</select>
<label for="citySelector">省份:</label>
<select class="form-control" id="citySelector">
    <option>请选择城市....</option>
</select>
<label for="districtSelector">省份:</label>
<select class="form-control" id="districtSelector">
    <option>请选择城区....</option>
</select>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        //TODO 初始化所有省数据（利用 $.ajax API实现省数据加载）

        //选择省
        $("#provinceSelector").change(function (e) {
                var provinceId= $("#provinceSelector").val(); // 获取选中的值
                //通过 省份 id ，获取省份下面的城市
                //1. 清空 原有的 城市和区县内容
            $("#citySelector").empty();
            var opt={
                url: "http://localhost:8080/select/cityJson",
                type:"get",
                data:"provinceId="+provinceId,
                dataType: "json",
                success: function(data)  {
                    if(data.city.length>0){
                        $.each(data.city,function(index, item){
                            console.log(item.cityId);
                            $("#citySelector").append("<option value='"+item.cityId+"'>"+item.cityName+"</option>");
                        })
                    }
                }
            };
            $.ajax(opt);
                })

        $("#citySelector").change(function (e) {
            var cityId= $("#citySelector").val(); // 获取选中的值
            //通过 省份 id ，获取省份下面的城市
            //1. 清空 原有的 城市和区县内容
            $("#districtSelector").empty();
            var opt={
                url: "http://localhost:8080/select/districtJson",
                type:"get",
                data:"cityId="+cityId,
                dataType: "json",
                success: function(data)  {
                    if(data.district.length>0){
                        $.each(data.district,function(index, item){
                            console.log(item.districtName);
                            $("#districtSelector").append("<option value='"+item.districtId+"'>"+item.districtName+"</option>");
                        })
                    }
                }
            };
            $.ajax(opt);
        })
})

</script>
</body>
</html>