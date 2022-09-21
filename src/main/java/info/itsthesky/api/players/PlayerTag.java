package info.itsthesky.api.players;

import info.itsthesky.api.utils.Savable;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a tag of a player.
 */
public interface PlayerTag extends Savable {

	/**
	 * Gets the name of the tag.
	 * @return The name of the tag.
	 */
	@NotNull String getName();

	/**
	 * Gets the unique id of the tag.
	 * @return The unique id of the tag.
	 */
	@NotNull String getId();

}
