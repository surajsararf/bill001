import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sararf.dto.Item;
import com.sararf.promotion.PercentageDiscount;
import com.sararf.promotion.Promotion;
import org.junit.jupiter.api.Test;

public class PercentageDiscountTest {
	@Test
	public void testApplyPromotion() {
		Item item = new Item("Bread", 3, 2.00);
		Promotion promotion = new PercentageDiscount(10, 2, "Bread");
		promotion.apply(item);
		assertEquals(5.40, item.getTotalPrice());
	}

	@Test
	public void testApplyPromotionNoDiscount() {
		Item item = new Item("Bread", 1, 2.00);
		Promotion promotion = new PercentageDiscount(10, 2, "Bread");
		promotion.apply(item);
		assertEquals(2.00, item.getTotalPrice());
	}
}
