package info.itsthesky.api.utils;

import info.itsthesky.api.items.Item;
import info.itsthesky.api.items.ItemStack;
import info.itsthesky.api.players.Player;
import info.itsthesky.core.utils.InventoryImpl;
import net.dv8tion.jda.internal.utils.Checks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a bunch of items that can be picked up.
 *
 */
public interface Inventory extends Iterable<ItemStack>, Savable {

	static @NotNull Inventory create(@Nullable Player owner, int size, ItemStack... content) {
		Checks.notNegative(size, "size");
		Checks.noneNull(content, "content");

		return new InventoryImpl(owner, new ArrayList<>(Arrays.asList(content)), size);
	}

	static @NotNull Inventory create(int size, ItemStack... content) {
		return create(null, size, content);
	}

	/**
	 * Check if this inventory is the player's inventory.
	 * @return true if this inventory is the player's inventory.
	 */
	boolean isPlayerInventory();

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

	void addItem(@NotNull Item item, int amount);

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
