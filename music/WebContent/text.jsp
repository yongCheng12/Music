<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function addCar(){
		
		//把A元素追加到B元素身上
		var formObj = document.getElementById("formId");
		//alert(formObj);
		formObj.action="shop_car.jsp";
		//动态创建标签
		var inputObj = document.createElement("input");
		inputObj.type = "text";
		inputObj.name = "myValue";
		inputObj.value = "admin";
		
		//追加元素
		formObj.appendChild(inputObj);
		//隐式提交，自动提交
		formObj.submit();
	}
	function buyGood(){
		var formObj = document.getElementById("formId");
		//alert(formObj);
		formObj.action="buy_good.jsp";
		formObj.submit();
	}

</script>
</head>
<body>
	<form id="formId" method="post" >
		<input type="text" name="" /><br />
		<input type="text" name="" /><br />
		<input type="text" name="" /><br />
		<input type="text" name="" /><br />
		
	</form>
	
		<input type="button" value="加入购物车" onclick="addCar()"/>
		<input type="button" value="直接购买" onclick="buyGood()"/>
</body>
</html>