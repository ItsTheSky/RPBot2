package info.itsthesky.api.utils;

import info.itsthesky.core.utils.ArrayDataList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

import java.util.List;

/**
 * Represents a list that can be saved permanently and loaded later.
 */
public interface DataList extends Iterable<Object> {

	static DataList empty() {
		return new ArrayDataList();
	}

	@NotNull List<Object> getValues();

	/**
	 * Get the value of a specific index.
	 * @param index The index to get.
	 * @param <T> The type of the value.
	 * @return The value of the index.
	 */
	@Nullable <T> T get(int index);

	/**
	 * Gets the value of a specific index, or a default value if the index doesn't exist.
	 * @param index The index to get.
	 * @param def The default value.
	 * @return The value of the index, or the default value if the index doesn't exist.
	 */
	@Nullable <T> T get(int index, @Nullable T def);

	@NotNull DataList add(@NotNull Object value);

	/**
	 * Get the size of this list.
	 * @return The size of this list.
	 */
	int size();

	JSONArray saveToJSON();
}
