package info.itsthesky.api.players;

import info.itsthesky.api.quests.PlayerQuest;
import info.itsthesky.api.quests.Quest;
import info.itsthesky.api.users.UserData;
import info.itsthesky.api.utils.Inventory;
import info.itsthesky.api.utils.Savable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

/**
 * A player is an object that is linked to an {@link UserData} but that stores player-related data, such as inventory, level, etc...
 */
public interface Player extends Savable {

	/**
	 * Gets the {@link UserData} linked to this player.
	 * @return The {@link UserData} linked to this player.
	 */
	@NotNull UserData getUserData();

	/**
	 * Gets the player's inventory.
	 * @return The player's inventory.
	 */
	@NotNull Inventory getInventory();

	/**
	 * Gets all the quest of this player.
	 * @return All the quest of this player.
	 */
	@NotNull List<PlayerQuest> getQuests();

	/**
	 * Get the {@link PlayerQuest quest} of this player with the specified ID.
	 * @param questId The ID of the quest to get.
	 * @return The quest of this player with the specified ID.
	 */
	@Nullable PlayerQuest getQuest(@NotNull String questId);

	/**
	 * Get the {@link PlayerQuest quest} of this player with the specified {@link Quest}.
	 * @param quest The quest to get.
	 * @return The quest of this player with the specified {@link Quest}.
	 */
	@NotNull PlayerQuest getQuest(@NotNull Quest quest);

	/**
	 * Gets all the tags of the player.
	 * @return All the tags of the player.
	 */
	@NotNull List<PlayerTag> getTags();

	/**
	 * Check if the player has the specified tag.
	 * @param tagClass The tag to check.
	 * @return true if the player has the specified tag.
	 */
	<T extends PlayerTag> boolean hasTag(@NotNull Class<T> tagClass);

	/**
	 * Gets the tag of the specified class.
	 * @param tagClass The class of the tag to get.
	 * @return The tag of the specified class.
	 */
	<T extends PlayerTag> T getTag(@NotNull Class<T> tagClass);

	/**
	 * Adds the specified tag to the player.
	 * @param tag The tag to add.
	 */
	void addTag(@NotNull PlayerTag tag);

	/**
	 * Removes the specified tag from the player.
	 * @param tag The tag to remove.
	 */
	<T extends PlayerTag> void removeTag(@NotNull Class<T> tag);

	/**
	 * Edits a tag of the player.
	 * @param tagClass The class of the tag to edit.
	 * @param changer The changer to edit the tag.
	 */
	<T extends PlayerTag> void editTag(@NotNull Class<T> tagClass, @NotNull Consumer<T> changer);

}
