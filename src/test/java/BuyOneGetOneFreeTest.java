import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sararf.dto.Item;
import com.sararf.promotion.BuyOneGetOneFree;
import com.sararf.promotion.Promotion;
import org.junit.jupiter.api.Test;

public class BuyOneGetOneFreeTest {
	@Test
	public void testApplyPromotion() {
		Item item = new Item("Milk", 2, 1.50);
		Promotion promotion = new BuyOneGetOneFree("Milk");
		promotion.apply(item);
		assertEquals(1.50, item.getTotalPrice());
	}

	@Test
	public void testApplyPromotionNoDiscount() {
		Item item = new Item("Bread", 3, 2.00);
		Promotion promotion = new BuyOneGetOneFree("Milk");
		promotion.apply(item);
		assertEquals(6.00, item.getTotalPrice());
	}
}
