package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection {

	   public static Connection getConnection() throws Exception{
	    	Connection conn=null;
	    	
	    	//����Sqlserver���ݿ���������sqljdbc4.jar����ʡ�Ա��䣬sqljdbc.jar������
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	   
	    	//��������
	   	    String dburl="jdbc:sqlserver://localhost:1433;databaseName=douban";
	    	String sqlUser="cjh";
	    	String sqlPwd="123";    	
	    	conn=DriverManager.getConnection(dburl,sqlUser,sqlPwd);
	 /*
	    	//����ʹ�������dburl��������
	    	String dburl="jdbc:sqlserver://localhost:1433;databaseName=txdatabase;user=sa;password=123";
	    	conn=DriverManager.getConnection(dburl);
	 */   	
	    	return conn;
	    }
		
	    //�ͷ���Դ
	    public static void release(Connection conn,Statement psmt,ResultSet rs)
	    {
	          try {
	        	  if(rs!=null)
	        		 rs.close();
	        	  if(psmt!=null)
				     psmt.close();
	        	  if(conn!=null)
		          conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  
	      }
	 

	
}
