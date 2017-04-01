package edu.mum.hw2.control;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw2.domain.CD;
import edu.mum.hw2.domain.Order;
import edu.mum.hw2.domain.OrderLine;
import edu.mum.hw2.domain.Product;


public class Application {

	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {

		addMovies();
		printMoviesReport();
		emf.close();
	}

	private static void printMoviesReport() {
		// TODO Auto-generated method stub

	}

	private static void addMovies() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			// Product
			Product item1 = new Product();
			
			item1.setName("Pencil 4B");
			item1.setDescription("Yellow with eraser");

			Product item2 = new Product();
			
			item2.setName("Sharpner");
			item2.setDescription("Plastic");
			
			CD item3 = new CD();
			item3.setArtist("Abba");
			item3.setDescription("Oldies");
			item3.setName("Greatest Hits");
			
			// Line
			OrderLine line1 = new OrderLine();
			line1.setProduct(item1);
			line1.setQuantity(100);

			OrderLine line2 = new OrderLine();
			line2.setProduct(item2);
			line2.setQuantity(1);

			OrderLine line3 = new OrderLine();
			line3.setProduct(item3);
			line3.setQuantity(1);

			// Order
			Order order = new Order();
			order.setDate(new Date());
			order.getLines().add(line1);
			order.getLines().add(line2);
			order.getLines().add(line3);

			em.persist(order);
			
			tx.commit();
			
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
	}

	private static byte [] loadCover(String filename) {
        Path p = FileSystems.getDefault().getPath(filename);
        byte [] fileData = null;
        try {
			fileData = Files.readAllBytes(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileData;
	}

}
