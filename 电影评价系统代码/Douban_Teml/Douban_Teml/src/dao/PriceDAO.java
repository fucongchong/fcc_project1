package dao;


import entity.Price;


public interface PriceDAO {
    public boolean insertPrice(Price price);
    public boolean updatePrice(Price pricer);
    public boolean deletePrice(int pid);
    public Price getPrice(int pid);
   
}
