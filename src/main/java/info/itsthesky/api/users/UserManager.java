package info.itsthesky.api.users;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.internal.utils.Checks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

/**
 * Represents a manager for every user data.
 */
public interface UserManager {

	/**
	 * Gets all the cached user data.
	 * @return The list of all the cached user data.
	 */
	@NotNull List<UserData> getAll();

	/**
	 * Get the user data of a specific user from the cached users.
	 * @param user The user to get the data from.
	 * @return The nullable user data.
	 * @see #getOrCreateUserData(User)
	 */
	@Nullable UserData getUserData(@NotNull User user);

	/**
	 * Create a new user data for a specific user.
	 * @param user The user to create the data for.
	 * @return The never-null created user data.
	 * @throws IllegalArgumentException If the user data already exists. Use {@link #getOrCreateUserData(User)} instead.
	 */
	@NotNull UserData createUserData(@NotNull User user);

	/**
	 * Save all the user data into files.
	 * @throws IOException If an error occurred while saving the files.
	 */
	void saveAll() throws IOException;

	/**
	 * Load all the user data from files.
	 * @throws IOException If an error occurred while loading the files.
	 */
	void loadAll() throws IOException;

	/**
	 * Get or create a new user data for a specific user.
	 * @param user The user to get or create the data for.
	 * @return The never-null user data.
	 */
	default @NotNull UserData getOrCreateUserData(@NotNull User user) {
		Checks.notNull(user, "User");
		final UserData userData = getUserData(user);
		return userData == null ? createUserData(user) : userData;
	}

}
