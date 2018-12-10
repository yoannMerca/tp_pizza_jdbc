package dao;

import java.util.ArrayList;

import execption.SavePizzaException;
import execption.StockageException;
import execption.UpdatePizzaException;
import model.Pizza;

public interface IPizzaDao {
		void createPizza(Pizza piz) throws SavePizzaException;
		void updatePizza(Pizza piz) throws UpdatePizzaException;
		void deletePizza(int id) throws StockageException;
		ArrayList<Pizza> getAllPizza();
		Pizza findOnePizza(int id);

}
