package info.itsthesky.core.utils;

import info.itsthesky.api.utils.DataList;
import info.itsthesky.api.utils.DataObject;
import info.itsthesky.api.utils.Savable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayDataList implements DataList {

	private final List<Object> values;

	public ArrayDataList(List<Object> values) {
		this.values = values;
	}

	public ArrayDataList() {
		this(new ArrayList<>());
	}

	public ArrayDataList(DataObject dataObject) {
		this.values = new ArrayList<>();


	}

	@Override
	public @NotNull List<Object> getValues() {
		return new ArrayList<>(values);
	}

	@Override
	public <T> @Nullable T get(int index) {
		return get(index, null);
	}

	@Override
	public @NotNull DataList add(@NotNull Object value) {
		values.add(value);
		return this;
	}

	@Override
	public <T> @Nullable T get(int index, @Nullable T def) {
		return values.size() > index ? (T) values.get(index) : def;
	}

	@Override
	public int size() {
		return values.size();
	}

	@Override
	public JSONArray saveToJSON() {
		final JSONArray array = new JSONArray();
		for (Object value : values) {

			if (value instanceof Savable || value instanceof DataObject) {
				final DataObject obj = value instanceof Savable ? ((Savable) value).save() : (DataObject) value;
				array.put(obj.saveToJSON());
			} else if (value instanceof DataList)
				array.put(((DataList) value).saveToJSON());
			else array.put(value);

		}
		return array;
	}

	@NotNull
	@Override
	public Iterator<Object> iterator() {
		return values.iterator();
	}
}
