package test;

import dao.DAOFactory;
import daoImpl.TypeDAOImpl;
import entity.Type;

public class TypeDAOImplTest {
	static Type type = new Type();
	static TypeDAOImpl typeDAO = (TypeDAOImpl) DAOFactory.getTypeDAO();
	
	public void testInsert() {
		type.setTypename("���");
		typeDAO.insert(type);
	}
	
	public  void testGet() {
		System.out.println(typeDAO.get("���").getTypename());
	}
	
	public void testDelete() {
		typeDAO.delete("���");
	}
	
}
