package info.itsthesky.api.players;

import info.itsthesky.api.items.ItemStack;
import info.itsthesky.api.utils.Savable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a bunch of items that can be picked up.
 *
 */
public interface Inventory extends Iterable<ItemStack>, Savable {

	/**
	 * Check if this inventory is the player's inventory.
	 * @return true if this inventory is the player's inventory.
	 */
	boolean isPlayerInventory();

	/**
	 * Gets the item at the specified slot.
	 * @param slot The slot to get the item from.
	 * @return The item at the specified slot.
	 */
	@Nullable ItemStack getItem(int slot);

	/**
	 * Gets the content of this inventory.
	 * @return The content of this inventory.
	 */
	@NotNull List<ItemStack> getItems();

	/**
	 * Add an item to the inventory.
	 * @param item The item to add.
	 */
	void addItem(@NotNull ItemStack item);

	/**
	 * Add several items to the inventory.
	 * @param items The items to add.
	 */
	default void addItems(@NotNull ItemStack... items) {
		for (ItemStack item : items)
			addItem(item);
	}

	/**
	 * Gets the inventory's size.
	 * @return The inventory's size.
	 */
	int getSize();

	/**
	 * Draw this inventory with all its items.
	 * @return The image of this inventory.
	 */
	BufferedImage draw();

	@NotNull
	@Override
	default Iterator<ItemStack> iterator() {
		return getItems().iterator();
	}
}
