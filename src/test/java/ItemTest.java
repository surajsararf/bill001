import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sararf.dto.Item;
import org.junit.jupiter.api.Test;

public class ItemTest {
	@Test
	public void testItemCreation() {
		Item item = new Item("Milk", 2, 1.50);
		assertEquals("Milk", item.getName());
		assertEquals(2, item.getQuantity());
		assertEquals(1.50, item.getPrice());
		assertEquals(3.00, item.getTotalPrice());
	}
}
