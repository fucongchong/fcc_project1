package test;

import dao.DAOFactory;
import dao.TagDAO;
import daoImpl.TagDAOImpl;
import entity.Tag;

public class TagDAOImplTest {
	static Tag tag = new Tag();
	static TagDAOImpl tagDAO = (TagDAOImpl) DAOFactory.getTagDAO();
	
	public void testInsert() {
		tag.setTag("¾çÇé");
		tagDAO.insert(tag);
	}
	
	public void testGet() {
		System.out.println(tagDAO.get("¾çÇé").getTag());
	}
	
	public void testDelete() {
		tagDAO.delete("¾çÇé");
	}
	
	
}
