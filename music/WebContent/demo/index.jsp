<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="../plugin/css/style.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
    <script type="text/javascript" src="../plugin/jquery-jplayer/jquery.jplayer.js"></script>
    <script type="text/javascript" src="../plugin/ttw-music-player-min.js"></script>
    <script type="text/javascript" src="js/myplaylist.js"></script>

    <script type="text/javascript">
        
        $(document).ready(function(){
           var description = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce id tortor nisi. Aenean sodales diam ac lacus elementum scelerisque. Suspendisse a dui vitae lacus faucibus venenatis vel id nisl. Proin orci ante, ultricies nec interdum at, iaculis venenatis nulla. ';
           var xmlhttp = new XMLHttpRequest();
           
           xmlhttp.onreadystatechange = function(){
          	 if(xmlhttp.readyState == 4){
          		
          		var data=xmlhttp.responseText;
          		 var dataArray = eval("("+data+")"); 
          		myPlaylist.length=dataArray.length;
   				 for(var i=0;i<dataArray.length;i++){ 					
   					myPlaylist[i].mp3=dataArray[i].mp3;	
   					myPlaylist[i].oga=dataArray[i].oga;	
   					myPlaylist[i].title=dataArray[i].title;	
   					myPlaylist[i].artist=dataArray[i].artist;	
   					myPlaylist[i].rating=dataArray[i].rating;	
   					myPlaylist[i].buy=dataArray[i].buy;	
   					myPlaylist[i].price=dataArray[i].price;	
   					myPlaylist[i].duration=dataArray[i].duration;	
   					myPlaylist[i].cover=dataArray[i].cover;	
   					alert(myPlaylist[i].mp3);
   					alert(myPlaylist.length);
   				 }
          	 }
           };
         //open("跳转方式：method","跳转的目标页面jsp/Serlvet",是否异步执行)
   		xmlhttp.open("post","../MusicServlet",true);
   		//4.设置请求头部信息
   		 
   		xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
   		//5.发送参数，以键值对的方式传参
   		xmlhttp.send(null);
   		 alert("123");
   		     
            $('body').ttwMusicPlayer(
            		myPlaylist, {  
                autoPlay:false,               
                description:description,
                jPlayer:{
                    swfPath:'../plugin/jquery-jplayer' //You need to override the default swf path any time the directory structure changes
                }
            
            });}
        
        );
    </script>
</head>
<body>

<div id="title"></div>
<a href="http://www.codebasehero.com/download?file=music-player" id="download">Download Here</a>
</body>
</html>