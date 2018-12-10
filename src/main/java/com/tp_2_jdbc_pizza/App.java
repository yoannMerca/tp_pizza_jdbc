package com.tp_2_jdbc_pizza;

import java.util.Scanner;

import dao.CategorieDao;
import dao.PizzaDao;
import execption.DeletePizzaException;
import execption.SavePizzaException;
import execption.StockageException;
import execption.UpdatePizzaException;
import model.Categorie;
import model.Pizza;

public class App{
    public static void main( String[] args ){
       PizzaDao myPizza = new PizzaDao();
       CategorieDao myCat = new CategorieDao();
     //pour mettre fin a la boucle 
     		boolean end = false;
     		int id_cat;
     		Categorie cat;
     		Pizza piz;
     		Scanner scan = new Scanner(System.in);
     		/**
     		 * boucle tant pour afficher le menu tant que l'utilisateur ne tape pas 99 
     		 * */
     		//scan.nextLine();
     		while(!end) {
     			System.out.println("----------------------");
     			System.out.println("\"***** Pizzeria Administration *****\r\n" + 
     					"1. Lister les pizzas\r\n" + 
     					"2. Ajouter une nouvelle pizza\r\n" + 
     					"3. Mettre à jour une pizza\r\n" + 
     					"4. Supprimer une pizza\r\n"+
     					"5. reset ma liste de pizza\r\n" + 
     					"99. Sortir");
     			int value = Integer.parseInt(scan.nextLine());
     			switch (value) {
     			/**
     			 * affiche la liste des pizzas
     			 */
     			case 1:
     				
     				for (Pizza pizza : myPizza.getAllPizza()) {
						System.out.println(pizza.toString());
					}
     				break;
     			/*
     			 * 
     			 * Ajoute une nouvelle pizza
     			 * 
     			 */
     			case 2:
     				/*  Veuillez saisir le code :
     					Veuillez saisir le nom (sans espace) :
     					Veuillez saisir le prix :
     				*/
     				System.out.println("----------------------");
     				System.out.println("Ajout d’une nouvelle pizza");		
     				System.out.println("Veuillez saisir le code");
     				String code = scan.nextLine();
     				System.out.println("Veuillez saisir le nom (sans espace) :");
     				String name = scan.nextLine();
     				System.out.println("Veuillez le prix:");
     				Double price = Double.valueOf(scan.nextLine());
     				System.out.println("Veuillez saisir la categorie \n\r"
     						+ "° tapez 1 pour Fromage \r\n"
     						+ "° 2 pour Viande \r\n"
     						+ "° 3 pour Poisson \r\n"
     						+ "° 4 pour Autre");
     				
     				id_cat = Integer.parseInt(scan.nextLine());
     				cat  = myCat.getOneCategorie(id_cat);
     				piz = new Pizza(code, name, price, cat);
     			
					try {
						myPizza.createPizza(piz);
					} catch (SavePizzaException e) {
						System.out.println(e.getMessage());
					}
     			
     				break;
     			/*
     			 * 
     			 * Mise a jour d'une pizza	
     			 */
     			case 3:
     				
     				System.out.println("----------------------");
     				System.out.println("Mise à jour d’une pizza");
     				System.out.println("Veuillez saisir l'id de la pizza à modifier");
     				int id = Integer.parseInt(scan.nextLine()) ;
     				System.out.println("Veuillez saisir le nouveau code");
     				code = scan.nextLine();
     				System.out.println("Veuillez saisir le nouveau nom :");
     				name = scan.nextLine();
     				System.out.println("Veuillez le nouveau prix:");
     				price = Double.valueOf(scan.nextLine());
     				System.out.println("Veuillez saisir la categorie \n\r"
     						+ "° tapez 1 pour Fromage \r\n"
     						+ "° 2 pour Viande \r\n"
     						+ "° 3 pour Poisson \r\n"
     						+ "° 4 pour Autre \r\n\"");
     				id_cat = Integer.parseInt(scan.nextLine());
     				cat  = myCat.getOneCategorie(id_cat);
     				piz = new Pizza(id,code, name,price,cat );
     				try {
     					myPizza.updatePizza(piz);
     				} catch (UpdatePizzaException e) {    				
     					System.err.println(e.getMessage()+" update");
     				}
     				break;
     			/*
     			 * 
     			 * Supprime une pizza
     			 */
     			case 4:
     				System.out.println("----------------------");
     				System.out.println("Suppression d’une pizza");
     			
     				System.out.println("Veuillez saisir le id de la pizza à supprimer");
     				id = Integer.parseInt(scan.nextLine());
					try {
						myPizza.deletePizza(id);
					} catch (DeletePizzaException e1) {
						System.out.println(e1.getMessage());
					}
     				break;	
     			/*
     			 * 
     			 * Fin de la boucle (valeur par defaut)
     			 */
     			case 5:
     				try {
     					myPizza.resetAllPizza();
     					} catch (Exception e) {
     					System.err.println(e);
     				}
     				break;	
     			case 99:
     			default:
     				System.out.println("----------------------");
     				System.out.println("Au revoir");
     				scan.close();
     				end =true;
     				break;
     			}
     			
     		}
     	}
}
