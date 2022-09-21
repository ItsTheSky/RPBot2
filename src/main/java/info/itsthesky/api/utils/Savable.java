package info.itsthesky.api.utils;

import net.dv8tion.jda.internal.utils.Checks;
import org.dom4j.Branch;
import org.jetbrains.annotations.NotNull;

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

	default void saveToXML(@NotNull Branch element) {
		Checks.notNull(element, "element");

		save().saveToXML(element);
	}

}
