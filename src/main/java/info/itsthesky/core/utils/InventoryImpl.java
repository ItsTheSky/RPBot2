package info.itsthesky.core.utils;

import info.itsthesky.api.items.Item;
import info.itsthesky.api.items.ItemStack;
import info.itsthesky.api.players.Player;
import info.itsthesky.api.utils.DataObject;
import info.itsthesky.api.utils.Inventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {

	private final @Nullable Player owner;
	private final @NotNull List<ItemStack> items;
	private final int size;
	private final boolean playerInventory;

	public InventoryImpl(@NotNull List<ItemStack> items, int size) {
		this(null, items, size);
	}

	public InventoryImpl(@Nullable Player owner, @NotNull List<ItemStack> items, int size) {
		this.owner = owner;
		this.items = items;
		this.size = size;
		this.playerInventory = owner != null;
	}

	public InventoryImpl(@NotNull DataObject dataObject) {
		this.owner = null;
		this.playerInventory = owner != null;
		this.size = dataObject.getInt("size");

		this.items = new ArrayList<>();
		for (Object sample : dataObject.getList("items")) {
			final DataObject object = (DataObject) sample;
			this.items.add(new ItemStack(object));
		}
	}

	@Override
	public boolean isPlayerInventory() {
		return playerInventory;
	}

	@Override
	public @NotNull List<ItemStack> getItems() {
		return new ArrayList<>(items);
	}

	@Override
	public void addItem(@NotNull ItemStack item) {
		addItem(item.getItem(), item.getAmount());
	}

	@Override
	public void addItem(@NotNull Item item, int amount) {
		for (ItemStack stack : items) {
			if (stack.getItem().isSimilar(item)) {
				stack.setAmount(stack.getAmount() + amount);
				return;
			}
		}
		items.add(new ItemStack(item, amount));
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public BufferedImage draw() {
		return null;
	}

	@Override
	public DataObject save() {
		return DataObject.empty()
				.put("size", size)
				.put("items", DataObject.createList(items));
	}

	@Override
	public String toString() {
		return "InventoryImpl{" +
				"owner=" + owner +
				", items=" + items +
				", size=" + size +
				", playerInventory=" + playerInventory +
				'}';
	}
}
