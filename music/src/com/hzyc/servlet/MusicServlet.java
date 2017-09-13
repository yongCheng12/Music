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
				//2.��ȡ�������ݵ���--->Ajax���������������ķ�ʽ��������
				//��Ajax��servlet�в������ض����������ת���Ĵ��룬ԭ����AjaxĬ�Ϸ�������ҳ�档
				JdbcTools jd=new JdbcTools();
				String sql="select * from  music";
				ArrayList<HashMap<String,String>> rslist=jd.qury(sql);
				Gson g=new Gson();
				String value=g.toJson(rslist);
				PrintWriter writer = response.getWriter();
				//3.ʹ��print()��������,ֻ�ܷ����ַ������͵�����
				writer.print(value);		
				//4.ǿ��ˢ��������
				writer.flush();
				//5.�ر���
				writer.close();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	

	}

}
