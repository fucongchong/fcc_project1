package test;

import dao.DAOFactory;
import dao.TagDAO;
import daoImpl.TagDAOImpl;
import entity.Tag;

public class TagDAOImplTest {
	static Tag tag = new Tag();
	static TagDAOImpl tagDAO = (TagDAOImpl) DAOFactory.getTagDAO();
	
	public void testInsert() {
		tag.setTag("����");
		tagDAO.insert(tag);
	}
	
	public void testGet() {
		System.out.println(tagDAO.get("����").getTag());
	}
	
	public void testDelete() {
		tagDAO.delete("����");
	}
	
	
}
