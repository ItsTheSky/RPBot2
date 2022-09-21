package info.itsthesky.api.items;

import net.dv8tion.jda.internal.utils.Checks;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an item stack, aka an item with a quantity.
 */
public class ItemStack {

	private final Item item;
	private int amount;

	public ItemStack(@NotNull Item item) {
		this(item, 1);
	}

	public ItemStack(@NotNull Item item, int amount) {
		Checks.notNull(item, "Item");
		Checks.notNegative(amount, "Amount");

		this.item = item;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Item getItem() {
		return item;
	}

	public int getAmount() {
		return amount;
	}
}
