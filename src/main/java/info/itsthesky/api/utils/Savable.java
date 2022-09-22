package info.itsthesky.api.utils;

import org.json.JSONObject;

/**
 * Represents an object that can be saved and loaded.
 * Any classes that implements this should have a constructor with a {@link DataObject} as parameter.
 */
public interface Savable {

	/**
	 * Save the object into a data object.
	 * @return the data object
	 */
	DataObject save();

	default JSONObject saveToJSON() {
		return save().saveToJSON();
	}

}
