package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("--- TEST 1: seller findById ---");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println();
		System.out.println("--- TEST 2: seller findByDepartment ---");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller s : list) {
			System.out.println(s);
		}
		System.out.println();
		System.out.println("--- TEST 3: seller findAll ---");
		list = sellerDao.findAll();
		for (Seller s : list) {
			System.out.println(s);
		}
		System.out.println();
		System.out.println("--- TEST 4: seller insert ---");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 3000.0, new Department(1, null));
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New seller id: " + newSeller.getId());
		System.out.println();
		System.out.println("--- TEST 5: seller update ---");
		newSeller = sellerDao.findById(1);
		newSeller.setName("Martha");
		sellerDao.update(newSeller);
		System.out.println("Updated!");
	}

}
