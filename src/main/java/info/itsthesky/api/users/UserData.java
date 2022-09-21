package info.itsthesky.api.users;

import info.itsthesky.api.players.Player;
import info.itsthesky.api.utils.DataObject;
import info.itsthesky.api.utils.Savable;
import net.dv8tion.jda.api.entities.User;
import org.jetbrains.annotations.NotNull;

/**
 * Represents the data of a specific user.
 */
public interface UserData extends Savable {

	/**
	 * Get the manager of this {@link UserData}
	 * @return The manager of this user data.
	 */
	@NotNull UserManager getManager();

	/**
	 * Gets the user who is represented by this data.
	 * @return The user.
	 */
	@NotNull User getUser();

	/**
	 * Gets the player linked to this user data.
	 * @return The player linked to this user data.
	 */
	@NotNull Player getPlayer();

	@Override
	default DataObject save() {
		return getPlayer().save();
	};
}
