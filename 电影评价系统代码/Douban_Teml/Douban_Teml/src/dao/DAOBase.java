package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOBase implements DAO{
 
    public Connection getConnection() {
    	
        Connection conn=null;
        try{
            conn=DBConnection.getConnection();
        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public void closeConnection(Connection conn, PreparedStatement psmt, ResultSet rs ) {
        DBConnection.release(conn,psmt,rs);
     }

	@Override
	public void closeConnection(Connection conn, Statement psmt, ResultSet rs) {
		 DBConnection.release(conn,psmt,rs);
		
	}
}
