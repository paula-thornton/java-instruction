package ui;

import java.io.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import util.Console;

import business.Product;

public class ProductFileMgrApp {

	private static List<Product> products = new ArrayList<>();
	private static File productsFile;

	public static void main(String[] args) throws IOException {

		Path productsPath = Paths.get("products.txt");
		if (Files.notExists(productsPath)) {
			Files.createFile(productsPath);
		}

		// create an instance of a file
		productsFile = productsPath.toFile();

		// read data from an input file
		BufferedReader in = new BufferedReader(new FileReader(productsFile));

		// read data from the stream and print to console
		String line = in.readLine();
		while (line != null) {

			// System.out.println(line);
			String[] fields = line.split("\t");
			String code = fields[0];
			String desc = fields[1];
			String price = fields[2];
			double priceDbl = Double.parseDouble(price);
			Product p = new Product(code, desc, priceDbl);
			System.out.println(p);
			products.add(p);

			line = in.readLine();
		}

		in.close();

		// Add a new product
		System.out.println("Add a new product: ");
		String code = Console.getString("Enter code: ");
		String desc = Console.getString("Enter description: ");
		double price = Console.getDouble("Enter price: ");

		Product pdt = new Product(code, desc, price);
		products.add(pdt);
		saveAll();

		System.out.println("New list of products:");
		for (Product p : products) {
			System.out.println(p);
		}
	}

	private static boolean saveAll() {
		try (PrintWriter out = new PrintWriter(new BufferedWriter(
				               new FileWriter(productsFile)))) {

			for (Product p : products) {
				out.print(p.getCode() + "\t");
				out.print(p.getDescription() + "\t");
				out.println(p.getPrice());
			}
			out.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

}
