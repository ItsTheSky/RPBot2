package info.itsthesky.api.items;

import info.itsthesky.api.utils.DataObject;
import info.itsthesky.api.utils.Savable;
import info.itsthesky.api.utils.Similar;
import net.dv8tion.jda.internal.utils.Checks;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an item stack, aka an item with a quantity.
 */
public class ItemStack implements Savable, Similar<ItemStack> {

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

	public ItemStack(@NotNull DataObject data) {
		Checks.notNull(data, "Data");
		// TODO: 21/09/2022 Load the item stack from a data object
		this.item = null;

		this.amount = data.getInt("amount");
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

	@Override
	public boolean isSimilar(ItemStack other) {
		return item.isSimilar(other.getItem());
	}

	@Override
	public DataObject save() {
		return DataObject.empty()
				.put("item", item.getId())
				.put("amount", amount);
	}
}
