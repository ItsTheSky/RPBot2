package info.itsthesky.core.utils;

import info.itsthesky.api.utils.DataObject;
import net.dv8tion.jda.internal.utils.Checks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class MapDataObject implements DataObject {

	private final Map<String, Object> map;

	public MapDataObject() {
		this.map = new HashMap<>();
	}

	@Override
	public @NotNull Map<String, Object> getMap() {
		return map;
	}

	@Override
	public boolean contains(@NotNull String key) {
		Checks.notNull(key, "key");

		return map.containsKey(key);
	}

	@Override
	public <T> DataObject put(@NotNull String key, @NotNull T value) {
		Checks.notNull(key, "key");
		Checks.notNull(value, "value");

		map.put(key, value);
		return this;
	}

	@Override
	public <T> DataObject putOpt(@Nullable String key, @Nullable T value) {
		if (key == null || value == null) return this;

		map.put(key, value);
		return this;
	}

	@Override
	public <T> @Nullable T get(@NotNull String key) {
		Checks.notNull(key, "key");

		return (T) map.get(key);
	}

	@Override
	public <T> @Nullable T getOpt(@Nullable String key) {
		if (key == null) return null;

		return (T) map.get(key);
	}

	@Override
	public DataObject remove(@NotNull String key) {
		Checks.notNull(key, "key");

		map.remove(key);
		return this;
	}
}
