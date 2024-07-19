package com.sararf;

import com.sararf.dto.Item;
import com.sararf.promotion.BuyOneGetOneFree;
import com.sararf.promotion.PercentageDiscount;
import com.sararf.promotion.Promotion;
import com.sararf.store.GroceryStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		String filePath = "/input.txt";
		List<Item> items = new ArrayList<>();
		List<Promotion> promotions = new ArrayList<>();
		double taxRate = 0.0;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				Main.class.getResourceAsStream(filePath)))) {
			String line;
			Boolean isPromotions = false;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (line.startsWith("Item:")) {
					isPromotions = false;
					fetchItems(line, items);
				} else if ((line.startsWith("Promotions:") || isPromotions)
						&& !line.startsWith("Tax:") && !line.startsWith("Item:")) {
					isPromotions = true;
					if (line.isEmpty()) {
						continue;
					}
					fetchPromotion(line, promotions);
				} else if (line.startsWith("Tax:")) {
					isPromotions = false;
					taxRate = getTaxRate(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		GroceryStore store = new GroceryStore(items, promotions, taxRate);
		store.calculateTotal();
	}

	private static double getTaxRate(String line) {
		double taxRate;
		taxRate = Double.parseDouble(line.split(": ")[1].replace("%", "").trim());
		return taxRate;
	}

	private static void fetchPromotion(String line, List<Promotion> promotions) {
		Pattern bogoPattern = Pattern.compile("- Buy one get one free on (.+)");
		Matcher bogoMatcher = bogoPattern.matcher(line);
		if (bogoMatcher.find()) {
			String itemName = bogoMatcher.group(1);
			promotions.add(new BuyOneGetOneFree(itemName));
			return;
		}
		Pattern pattern = Pattern.compile("- (\\d+)% off on (\\w+) if quantity > (\\d+)");
		Matcher matcher = pattern.matcher(line);
		if (matcher.find()) {
			double discount = Double.parseDouble(matcher.group(1));
			String itemName = matcher.group(2);
			int minQuantity = Integer.parseInt(matcher.group(3));
			promotions.add(new PercentageDiscount(discount, minQuantity, itemName));
		}
	}

	private static void fetchItems(String line, List<Item> items) {
		String[] parts = line.split(", ");
		String name = parts[0].split(":")[1].replace("\"", "").trim();
		int quantity = Integer.parseInt(parts[1].split(":")[1].trim());
		double price = Double.parseDouble(parts[2].split(":")[1].trim());
		items.add(new Item(name, quantity, price));
	}
}