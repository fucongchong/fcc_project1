package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public interface  DAO {
    public Connection getConnection();
    public void closeConnection(Connection conn, Statement psmt, ResultSet rs );
	void closeConnection(Connection conn, PreparedStatement psmt, ResultSet rs);

}
