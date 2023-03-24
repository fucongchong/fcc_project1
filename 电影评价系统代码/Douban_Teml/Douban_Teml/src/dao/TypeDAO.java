package dao;

import java.util.ArrayList;
import entity.Type;

public interface TypeDAO {
	public boolean insert(Type type);
	// public boolean update(Type type); // ֻ��һ��������ôupdate
	public boolean delete(String type);
	public Type get(String type);
	public ArrayList<Type> getTypeByMID(int mid);
}
