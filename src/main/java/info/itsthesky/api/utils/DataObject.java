package info.itsthesky.api.utils;

import info.itsthesky.core.utils.MapDataObject;
import net.dv8tion.jda.internal.utils.Checks;
import org.dom4j.Branch;
import org.dom4j.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Objects;

/**
 * Represents a data object, containing information that can be saved permanently.
 */
public interface DataObject {

	static DataObject empty() {
		return new MapDataObject();
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

	/**
	 * Gets an XML representation of this object.
	 * @return The XML representation of this object.
	 */
	default void saveToXML(@NotNull Branch document) {
		Checks.notNull(document, "document");

		for (Map.Entry<String, Object> entry : getMap().entrySet()) {
			final String key = entry.getKey();
			final Object value = entry.getValue();

			if (value instanceof Savable || value instanceof DataObject) {
				final DataObject obj = value instanceof Savable ? ((Savable) value).save() : (DataObject) value;

				final Element element = document.addElement(key)
						.addAttribute("type", "savable")
						.addAttribute("class", value.getClass().getName());
				obj.saveToXML(element);
			} else {
				document.addElement(key)
						.addAttribute("type", "single")
						.addAttribute("class", value.getClass().getSimpleName().toLowerCase())
						.setText(value.toString());
			}
		}
	};

	static DataObject loadFromXML(@NotNull Element element) {
		Checks.notNull(element, "element");

		final DataObject dataObject = DataObject.empty();
		for (Element child : element.elements()) {
			if (child.attributeValue("type").equals("savable")) {
				final String className = child.attributeValue("class");
				try {
					final Class<?> clazz = Class.forName(className);
					final Object savable = clazz.getConstructor(DataObject.class);
					dataObject.put(child.getName(), savable);
				} catch (ClassNotFoundException | NoSuchMethodException e) {
					e.printStackTrace();
				}
			} else {
				final String type = child.attributeValue("class");
				switch (type) {
					case "string" -> dataObject.put(child.getName(), child.getText());
					case "integer" -> dataObject.put(child.getName(), Integer.parseInt(child.getText()));
					case "long" -> dataObject.put(child.getName(), Long.parseLong(child.getText()));
					case "double" -> dataObject.put(child.getName(), Double.parseDouble(child.getText()));
					case "float" -> dataObject.put(child.getName(), Float.parseFloat(child.getText()));
					case "boolean" -> dataObject.put(child.getName(), Boolean.parseBoolean(child.getText()));
					default -> throw new IllegalArgumentException("Unknown type: " + type);
				}
			}
		}
		return dataObject;
	}

}
