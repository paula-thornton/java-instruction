package ui;

import java.io.*;
import java.io.IOException;
import java.nio.file.*;

import business.Product;

public class ProductFileDemoApp {

	public static void main(String[] args) throws IOException {
		
		Path productsPath = Paths.get("products.txt");
		if (Files.notExists(productsPath)) {
			Files.createFile(productsPath);
		}
		
		// create an instance of a file
		File productsFile = productsPath.toFile();
		
		// establish our print writer
		PrintWriter out = new PrintWriter(
				          new BufferedWriter(
				          new FileWriter(productsFile)));
		
		out.println("java\tMurach's Java Promgramming\t57.50");
		out.println("mysql\tMurach's MySql\t67.50");
		out.println("andr\tMurach's Android Promgramming\t47.50");
		
		out.close();
	
		// read data from an input file
		
		BufferedReader in = new BufferedReader(
				            new FileReader(productsFile));
		
		// read data from the stream and print to console
		String line = in.readLine();
		while (line != null) {

		//	System.out.println(line);
			String[] fields = line.split("\t");
			String code = fields[0];
			String desc = fields[1];
			String price = fields[2];
			double priceDbl = Double.parseDouble(price);
			Product p = new Product(code, desc, priceDbl);
			System.out.println(p);
			
			line = in.readLine();
		}	

		in.close();
	}

}
