package info.itsthesky.api.utils;

import info.itsthesky.core.utils.ArrayDataList;
import info.itsthesky.core.utils.MapDataObject;
import net.dv8tion.jda.internal.utils.Checks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a data object, containing information that can be saved permanently.
 */
public interface DataObject {

	static DataObject empty() {
		return new MapDataObject();
	}

	static DataList createList(List<?> elements) {
		return new ArrayDataList((List<Object>) elements);
	}

	/**
	 * Get the data of this object.
	 * @return The data of this object.
	 */
	@NotNull Map<String, Object> getMap();

	/**
	 * Check if this object contains a specific key.
	 * @param key The key to check.
	 * @return True if the key exists, false otherwise.
	 */
	boolean contains(@NotNull String key);

	/**
	 * Get the value of a specific key.
	 * @param key The key to get.
	 * @param <T> The type of the value.
	 * @return The value of the key.
	 */
	@Nullable <T> T get(@NotNull String key);

	@Nullable <T> T getOpt(@Nullable String key);

	// ########### SAMPLE GETTERS ########### //

	default boolean getBoolean(@NotNull String key) {
		return getOrDefault(key, false);
	}

	default byte getByte(@NotNull String key) {
		return getOrDefault(key, (byte) 0);
	}

	default short getShort(@NotNull String key) {
		return getOrDefault(key, (short) 0);
	}

	default int getInt(@NotNull String key) {
		return getOrDefault(key, 0);
	}

	default long getLong(@NotNull String key) {
		return getOrDefault(key, 0L);
	}

	default float getFloat(@NotNull String key) {
		return getOrDefault(key, 0F);
	}

	default double getDouble(@NotNull String key) {
		return getOrDefault(key, 0D);
	}

	default char getChar(@NotNull String key) {
		return getOrDefault(key, '\0');
	}

	default String getString(@NotNull String key) {
		return getOrDefault(key, "");
	}

	default DataObject getObject(@NotNull String key) {
		return getOrDefault(key, empty());
	}

	default DataList getList(@NotNull String key) {
		return getOrDefault(key, createList(List.of()));
	}

	// ########### SAMPLE GETTERS END ########### //

	/**
	 * Gets the value of a specific key, or a default value if the key doesn't exist.
	 * @param key The key to get.
	 * @param def The default value.
	 * @return The value of the key, or the default value if the key doesn't exist.
	 * @param <T> The type of the value.
	 */
	default <T> T getOrDefault(@NotNull String key, @Nullable T def) {
		Checks.notNull(key, "key");

		return contains(key) ? Objects.requireNonNull(get(key)) : def;
	};

	/**
	 * Set the value of a specific key.
	 * @param key The key to set.
	 * @param value The value to set.
	 * @param <T> The type of the value.
	 */
	<T> DataObject put(@NotNull String key, @NotNull T value);

	/**
	 * Set the value of a specific key. If the key or the value is null, nothing will happen.
	 * @param key The key to set.
	 * @param value The value to set.
	 * @param <T> The type of the value.
	 */
	<T> DataObject putOpt(@Nullable String key, @Nullable T value);

	/**
	 * Remove a specific key.
	 * @param key The key to remove.
	 */
	DataObject remove(@NotNull String key);

	default JSONObject saveToJSON() {
		final JSONObject json = new JSONObject();

		for (Map.Entry<String, Object> entry : getMap().entrySet()) {
			final String key = entry.getKey();
			final Object value = entry.getValue();

			if (value instanceof Savable || value instanceof DataObject) {
				final DataObject obj = value instanceof Savable ? ((Savable) value).save() : (DataObject) value;
				json.put(key, obj.saveToJSON());
			} else if (value instanceof DataList)
				json.put(key, ((DataList) value).saveToJSON());
			else json.put(key, value);
		}

		return json;
	};

	default void saveToFile(@NotNull File file) throws IOException {
		Checks.notNull(file, "file");

		Files.write(file.toPath(), saveToJSON().toString(4).getBytes());
	}

}
