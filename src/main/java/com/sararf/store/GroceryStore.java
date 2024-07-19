package com.sararf.store;

import com.sararf.dto.Item;
import com.sararf.promotion.Promotion;

import java.util.List;

public class GroceryStore {
	private List<Item> items;
	private List<Promotion> promotions;
	private double taxRate;

	public GroceryStore(List<Item> items, List<Promotion> promotions, double taxRate) {
		this.items = items;
		this.promotions = promotions;
		this.taxRate = taxRate;
	}

	public double calculateTotal() {
		double subtotal = 0.0;
		for (Item item : items) {
			for (Promotion promotion : promotions) {
				promotion.apply(item);
			}
			subtotal += item.getTotalPrice();
			System.out.println(item.getName() + ": " + item.getTotalPrice());
		}

		double tax = subtotal * taxRate / 100;
		double total = subtotal + tax;

		System.out.printf("Subtotal: %.2f%n", subtotal);
		System.out.printf("Tax: %.2f%n", tax);
		System.out.printf("Total: %.2f%n", total);

		return total;
	}
}

