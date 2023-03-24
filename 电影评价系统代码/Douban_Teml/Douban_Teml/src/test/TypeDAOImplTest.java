package test;

import dao.DAOFactory;
import daoImpl.TypeDAOImpl;
import entity.Type;

public class TypeDAOImplTest {
	static Type type = new Type();
	static TypeDAOImpl typeDAO = (TypeDAOImpl) DAOFactory.getTypeDAO();
	
	public void testInsert() {
		type.setTypename("类别");
		typeDAO.insert(type);
	}
	
	public  void testGet() {
		System.out.println(typeDAO.get("类别").getTypename());
	}
	
	public void testDelete() {
		typeDAO.delete("类别");
	}
	
}
