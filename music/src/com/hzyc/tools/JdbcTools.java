package com.hzyc.tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class JdbcTools {
	
	     Connection cnn;
	     Statement stm;
	     ResultSet rs;
	   public void getConnection(){
		   try {
			      Class.forName("com.mysql.jdbc.Driver");
			     cnn= DriverManager.getConnection("jdbc:mysql://localhost:3308/tf_29", "root", "mysql");
			     stm= cnn.createStatement();
			   
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	   }
	   public boolean Update(String sql){
		   try {
			getConnection();
			int result = stm.executeUpdate(sql);
			if(result!=1){
				return false;
			}
			
			   
			   
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return true;
	   }
	   //��������
		public int[] batch(LinkedList<String> sqlList){
			
			int [] array = new int[sqlList.size()];
			try {
				getConnection();
				//����sql���
				for(int i = 0;i < sqlList.size();i++){
					String sql = sqlList.get(i);
					stm.addBatch(sql);
				}
				
				
				array = stm.executeBatch();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				close();
			}
			
			
			return array;
		}
		public List<String[]> queryForTable(String sql){
			System.out.println("DbUtils>>queryForTable>>sql is:"+sql);
			List<String[]> rsList = new ArrayList<String[]>();
			try {
				getConnection();
				rs = stm.executeQuery(sql);
				//ͨ��rs�õ����ݿ��б�Ľṹ��Ŀ�ĵõ��ֶ���
				ResultSetMetaData rsmd = rs.getMetaData();
				while(rs.next()){
					//ȡ�����ݺ󣬽����ݴ洢��������
					String [] valueArray = new String[rsmd.getColumnCount()];
					for(int i = 0;i < rsmd.getColumnCount();i++){
						String columnName = rsmd.getColumnName(i+1);
						String columnValue = rs.getString(columnName);
						
						//���ֶ�ֵ�洢��������
						valueArray[i] = columnValue;
						
					}
					
					rsList.add(valueArray);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				close();
			}
			
			return rsList;
		}
		
		
		
		
		
		
	   public ArrayList<HashMap<String,String>>qury(String sql) {
	   ArrayList<HashMap<String,String>> rsList = new ArrayList<HashMap<String,String>>();
	    try {
			getConnection();
			rs= stm.executeQuery(sql);
			ResultSetMetaData rsmd =rs.getMetaData();
			
			while(rs.next()){
				HashMap<String,String>rsMap=new HashMap<String,String>();
				for(int i=1;i<=rsmd.getColumnCount();i++){
					String  ColumnName = rsmd.getColumnName(i);
					String  ColumnValue= rs.getString(ColumnName);
					rsMap.put(ColumnName,ColumnValue);
				}
				rsList.add(rsMap);
			}
		} catch (Exception e) {
			
		}
	   finally{
		   close();
	   }
	   return rsList;
	   }
	   public void close(){
		   try { 
			   if(rs!=null){
				   rs.close();
			   }
			   if(stm!=null){
				   stm.close();
			   }
			   if(cnn!=null){
				   cnn.close();
			   }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	   }
}
	   
