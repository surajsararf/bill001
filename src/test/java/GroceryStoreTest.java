import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sararf.dto.Item;
import com.sararf.promotion.BuyOneGetOneFree;
import com.sararf.promotion.PercentageDiscount;
import com.sararf.promotion.Promotion;
import com.sararf.store.GroceryStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GroceryStoreTest {
	private List<Item> items;
	private List<Promotion> promotions;
	private double taxRate;

	@BeforeEach
	public void setup() {
		items = new ArrayList<>();
		promotions = new ArrayList<>();
		taxRate = 5.0;
	}

	@Test
	public void testCalculateTotalWithPromotions() {
		items.add(new Item("Milk", 2, 1.50));
		items.add(new Item("Bread", 3, 2.00));
		promotions.add(new BuyOneGetOneFree("Milk"));
		promotions.add(new PercentageDiscount(10, 2, "Bread"));

		GroceryStore store = new GroceryStore(items, promotions, taxRate);
		double total = store.calculateTotal();

		assertEquals(7.25, total);
	}

	@Test
	public void testCalculateTotalWithoutPromotions() {
		items.add(new Item("Eggs", 12, 0.10));
		items.add(new Item("Cheese", 1, 5.00));

		GroceryStore store = new GroceryStore(items, promotions, taxRate);
		double total = store.calculateTotal();

		assertEquals(5.46, total);
	}
}
