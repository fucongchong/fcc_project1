package daoImpl;

import dao.DAOBase;
import dao.UserDAO;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAOImpl extends DAOBase implements UserDAO {
    @Override
    public boolean insertUser(User user) {
        String sql="insert into d_user values(?,?,?,?,?,?,?)";
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,user.getUid());
            pstmt.setString(2,user.getUsername());
            pstmt.setString(3,user.getEmail());
            pstmt.setString(4,user.getPwd());
            pstmt.setString(5,user.getTel());
            pstmt.setString(6,user.getAddr());
            pstmt.setString(7,user.getGender());
            pstmt.executeUpdate();
            closeConnection(conn,pstmt,null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        String sql="update d_user set gender=?,username=?,email=?,pwd=?,tel=?,addr=? where uid=?";
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(7,user.getUid());
            pstmt.setString(2,user.getUsername());
            pstmt.setString(3,user.getEmail());
            pstmt.setString(4,user.getPwd());
            pstmt.setString(5,user.getTel());
            pstmt.setString(6,user.getAddr());
            pstmt.setString(1,user.getGender());
            pstmt.executeUpdate();
            closeConnection(conn,pstmt,null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(int uid) {
        String sql="delete from d_user where uid=?";
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,uid);
            pstmt.executeUpdate();
            closeConnection(conn,pstmt,null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUser(int uid) {
        String sql="select * from d_user where uid=\'"+uid+"\'";
        Statement stmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            User user=new User();
            while (rs.next()){
                user.setUid(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPwd(rs.getString("pwd"));
                user.setTel(rs.getString("tel"));
                user.setAddr(rs.getString("addr"));
                user.setGender(rs.getString("gender"));
            }
            closeConnection(conn,stmt,rs);
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<User> getUsers() {
        String sql="select * from d_user";
        Statement stmt=null;
        Connection conn=null;
        ArrayList<User> users=new ArrayList<User>();
        try{
            conn=getConnection();
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
                User user=new User();
                user.setUid(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPwd(rs.getString("pwd"));
                user.setTel(rs.getString("tel"));
                user.setAddr(rs.getString("addr"));
                user.setGender(rs.getString("gender"));
                users.add(user);
            }
            closeConnection(conn, stmt,rs);

            return users;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
