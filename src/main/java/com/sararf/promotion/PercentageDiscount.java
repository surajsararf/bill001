package com.sararf.promotion;

import com.sararf.dto.Item;

public class PercentageDiscount implements Promotion {
	private double discount;
	private int minQuantity;
	private String itemName;

	public PercentageDiscount(double discount, int minQuantity, String itemName) {
		this.discount = discount;
		this.minQuantity = minQuantity;
		this.itemName = itemName;
	}

	@Override
	public void apply(Item item) {
		if (item.getName().equals(itemName) && item.getQuantity() >= minQuantity) {
			double discountAmount = item.getTotalPrice() * discount / 100;
			item.setTotalPrice(item.getTotalPrice() - discountAmount);
		}
	}
}

