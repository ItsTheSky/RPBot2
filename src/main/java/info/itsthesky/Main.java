package info.itsthesky;

import info.itsthesky.api.items.Item;
import info.itsthesky.api.items.ItemData;
import info.itsthesky.api.items.ItemStack;
import info.itsthesky.api.utils.DataObject;
import info.itsthesky.api.utils.Inventory;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) throws IOException {

		Instances.init();

		/*
		Tests
		 */

		final Inventory inventory = Inventory.create(5, new ItemStack(new Item() {
			@Override
			public @NotNull String getId() {
				return "test";
			}

			@Override
			public @NotNull String getName() {
				return "test";
			}

			@Override
			public @NotNull String getDescription() {
				return "test";
			}

			@Override
			public @NotNull Category getCategory() {
				return Category.OTHER;
			}

			@Override
			public @NotNull Rarity getRarity() {
				return Rarity.COMMON;
			}

			@Override
			public @NotNull List<ItemData> getDatas() {
				return new ArrayList<>();
			}

			@Override
			public <T extends ItemData> @NotNull T getData(@NotNull Class<T> dataClass) {
				return null;
			}

			@Override
			public <T extends ItemData> boolean hasData(@NotNull Class<T> dataClass) {
				return false;
			}

			@Override
			public void addData(@NotNull ItemData data) {

			}

			@Override
			public <T extends ItemData> void editData(Class<T> dataClass, @NotNull Consumer<T> changer) {

			}
		}, 5));

		final DataObject data = inventory.save();
		data.saveToFile(new File("test.json"));
		System.out.println(inventory);
	}

}