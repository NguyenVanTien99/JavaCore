package training.main;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import training.dao.BillDAO;
import training.dao.ItemDAO;
import training.dao.impl.BillDAOImpl;
import training.dao.impl.ItemDAOImpl;
import training.model.Bill;
import training.model.Item;
import training.util.UserInputUtil;

public class BillManagement {
	static BillDAO billDAO = new BillDAOImpl();
	static ItemDAO itemDAO = new ItemDAOImpl();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Bill> bills = new ArrayList<>();
		List<Item> items = new ArrayList<>();
		String billCode;
		String loop = "";
		Item item = null;
		String choice = "";

		do {
			getMenu();
			System.out.println("Enter your choose");
			choice = scanner.nextLine();

			switch (choice) {
			case "1":
				Bill bill = new Bill();

				try {
					do {
						bill.setBillCode(UserInputUtil.checkBillCode(scanner));
					} while (billDAO.findBillsByBillCode(bill.getBillCode()) != null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Enter customer name:");
				bill.setCustomerName(scanner.nextLine());

				System.out.println("Enter discount:");
				bill.setDiscount(UserInputUtil.inputTypeFloat(scanner.nextLine()));

				bill.setCreatedDate(getCurrentDate());

				boolean check = false;
				
				try {
					check = billDAO.saveBill(bill);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (check) {
					System.out.println("Saved success!");
				}

				break;

			default:
				break;
			}

		} while (true);

	}

	public static void getMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1. Create new bill");
		System.out.println("2. Add one or more item(s) into a specific bill");
		System.out.println("3. Delete one or more item(s) from a bill");
		System.out.println("4. Display all bills, sorted by created date");
		System.out.println("5. Display customer's bills, sorted by created date");
		System.out.println("6. Display items from a specific bill");
		System.out.println("7. Exit");
	}

	public static String getCurrentDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date(0));
	}

}