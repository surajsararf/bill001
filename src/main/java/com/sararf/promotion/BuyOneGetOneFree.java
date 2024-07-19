package com.sararf.promotion;

import com.sararf.dto.Item;

public class BuyOneGetOneFree implements Promotion {
	private String itemName;

	public BuyOneGetOneFree(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public void apply(Item item) {
		if (item.getName().equalsIgnoreCase(itemName) && item.getQuantity() > 1) {
			double discount = (item.getQuantity() / 2) * item.getPrice();
			item.setTotalPrice(item.getTotalPrice() - discount);
		}
	}
}

