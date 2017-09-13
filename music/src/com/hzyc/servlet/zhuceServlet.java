package com.hzyc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.tools.JdbcTools;


public class zhuceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			 String name=request.getParameter("name");
			 String pwd=request.getParameter("password");
			 JdbcTools jd = new JdbcTools();
			 String sql ="insert into  user (name,pwd )values('"+name+"','"+pwd+"')";
			 jd.Update(sql);
			 System.out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
