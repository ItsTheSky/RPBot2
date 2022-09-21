package info.itsthesky.api.items;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

/**
 * Represents an Item in the game that players can have.
 */
public interface Item {

	/**
	 * Get the unique identifier of this item.
	 * @return The unique identifier of this item.
	 */
	@NotNull String getId();

	/**
	 * Get the name of this item.
	 * @return The name of this item.
	 */
	@NotNull String getName();

	/**
	 * Get the description of this item.
	 * @return The description of this item.
	 */
	@NotNull String getDescription();

	/**
	 * Get the category of this item.
	 * @return The category of this item.
	 */
	@NotNull Category getCategory();

	/**
	 * Get the rarity of this item.
	 * @return The rarity of this item.
	 */
	@NotNull Rarity getRarity();

	/**
	 * Get every {@link ItemData} of this item.
	 * @return Every {@link ItemData} of this item.
	 */
	@NotNull List<ItemData> getDatas();

	/**
	 * Get the {@link ItemData} of this item with the given item data class.
	 * @param dataClass The class of the item data.
	 * @param <T> The type of the item data.
	 * @throws IllegalArgumentException If the item data class is not registered.
	 */
	@NotNull <T extends ItemData> T getData(@NotNull Class<T> dataClass);

	/**
	 * Check if this item has the given item data.
	 * @param dataClass The class of the item data.
	 * @param <T> The type of the item data.
	 */
	<T extends ItemData> boolean hasData(@NotNull Class<T> dataClass);

	/**
	 * Register a new item data to this item.
	 * @param data The item data to register.
	 * @throws IllegalArgumentException If the item data class is already registered.
	 */
	void addData(@NotNull ItemData data);

	/**
	 * Change a data of this item.
	 * @param changer The consumer that will change the data.
	 * @throws IllegalArgumentException If the item data class is not registered.
	 */
	<T extends ItemData> void editData(Class<T> dataClass, @NotNull Consumer<T> changer);

	enum Category {
		WEAPON,
		ARMOR,
		CONSUMABLE,
		OTHER
	}

	enum Rarity {
		COMMON,
		UNCOMMON,
		RARE,
		EPIC,
		LEGENDARY,
		ARTIFACT
	}

}
