import daoImpl.UserDAOImpl;
import daoImpl.commentDAOImpl;
import entity.User;
import test.MovieDaoImplTest;
import test.TagDAOImplTest;
import test.TheaterDAOlmplTest;
import test.UserDAOImplTest;

public class Test {
	public static void main(String[] args) throws Exception {
		// User����
		UserDAOImplTest userDAOImplTest = new UserDAOImplTest();
		//userDAOImplTest.testInsertUser();
		// userDAOImplTest.testDeleteUser();
		UserDAOImpl userDAOImpl=new UserDAOImpl();
		userDAOImpl.insertUser(new User(3,"����","","123","","","��"));
		userDAOImpl.insertUser(new User(4,"��С��","","123","","","��"));
		userDAOImpl.insertUser(new User(5,"��С��","","123","","","Ů"));
		userDAOImpl.insertUser(new User(6,"��С��","","123","","","��"));
		userDAOImplTest.testGetUsers();;

		// Theater ����
		  TheaterDAOlmplTest theaterDAOlmplTest=new TheaterDAOlmplTest();
		  //theaterDAOlmplTest.testInsertTheater();
		  theaterDAOlmplTest.testUpdateTheater();
		  theaterDAOlmplTest.testGetTheater();
		//Movie����  
		 MovieDaoImplTest movieDaoImplTest=new MovieDaoImplTest();
		  movieDaoImplTest.testInsert(); 
		  movieDaoImplTest.testDelete();
		 
		/*
		 * TagDAOImplTest tagDAOImplTest=new TagDAOImplTest();
		 * tagDAOImplTest.testInsert(); tagDAOImplTest.testDelete();
		 */

		
		/*
		 * CommentDAOImplTest comment=new CommentDAOImplTest(); //
		 * comment.testInsertComment(); comment.testUpdateComment();
		 * comment.testGetComment();
		 */
		 
		 

	}
}
