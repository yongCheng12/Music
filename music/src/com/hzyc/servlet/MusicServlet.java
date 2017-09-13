package com.hzyc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hzyc.tools.JdbcTools;


public class MusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		try {
			    System.out.println("123");
				response.setCharacterEncoding("utf-8");
				//2.获取返回数据的流--->Ajax返回数据是以流的方式返回数据
				//在Ajax的servlet中不能有重定向或者请求转发的代码，原因是Ajax默认返回请求页面。
				JdbcTools jd=new JdbcTools();
				String sql="select * from  music";
				ArrayList<HashMap<String,String>> rslist=jd.qury(sql);
				Gson g=new Gson();
				String value=g.toJson(rslist);
				PrintWriter writer = response.getWriter();
				//3.使用print()返回数据,只能返回字符串类型的数据
				writer.print(value);		
				//4.强制刷新数据流
				writer.flush();
				//5.关闭流
				writer.close();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	

	}

}
