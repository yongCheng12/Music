package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.tools.JdbcTools;

public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 try {
			  String name= request.getParameter("name");
			  String pwd=request.getParameter("password");
			  String sql = "select pwd from user where name='"+name+"'";
			  System.out.println(sql);
			  JdbcTools jd=new JdbcTools();
			  ArrayList<HashMap<String,String>>rslist=jd.qury(sql);
			  Map<String,String> hmap=rslist.get(0);
			  String m=hmap.get("pwd");
			  System.out.println(m);
			  if(pwd.equals(m)){
				  request.getRequestDispatcher("demo/index.jsp").forward(request, response);
			  }else{
				  System.out.println("Ê§°Ü");
			  }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
