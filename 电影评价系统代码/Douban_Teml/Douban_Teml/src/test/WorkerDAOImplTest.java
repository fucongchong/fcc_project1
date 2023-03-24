package test;

import dao.DAOFactory;
import dao.WorkerDAO;
import daoImpl.WorkerDAOImpl;
import entity.Worker;

public class WorkerDAOImplTest {
	static Worker worker = new Worker();
	static WorkerDAOImpl workerDAO = (WorkerDAOImpl) DAOFactory.getWorkerDAO();
	
	public  void testInsert() {
		worker.setWid(100);
		worker.setCountry("china");
		worker.setName("dzy");
		workerDAO.insert(worker);
	}
	
	public void testUpdate() {
		worker.setWid(1);
		worker.setCountry("china");
		worker.setName("dzydzy7");
		workerDAO.update(worker);
	}
	
	public void testGet() {
		worker = workerDAO.get(1);
		System.out.println(worker.getName());
	}
	
	public  void testDelete() {
		workerDAO.delete(1);
	}
	
}
