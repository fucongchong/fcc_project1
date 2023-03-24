package dao;

import entity.User;

import java.util.ArrayList;
import java.util.List;


public interface UserDAO {
    public boolean insertUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(int uid);
    public User getUser(int uid);
    public ArrayList<User> getUsers();
}
