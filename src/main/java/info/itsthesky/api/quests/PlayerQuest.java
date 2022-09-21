package info.itsthesky.api.quests;

import info.itsthesky.api.quests.objectives.Objective;
import info.itsthesky.api.utils.Savable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents the data of a quest for a player.
 */
public interface PlayerQuest extends Savable {

	/**
	 * Get the quest linked to this player quest.
	 * @return The quest linked to this player quest.
	 */
	@NotNull Quest getQuest();

	/**
	 * Check if this quest is completed or not.
	 * @return True if the quest is completed, false otherwise.
	 */
	boolean isCompleted();

	/**
	 * Check if this quest is started or not.
	 * @return True if the quest is started, false otherwise.
	 */
	boolean isStarted();

	/**
	 * Gets the current objective of this quest.
	 * <br> If {@link #isStarted()} returns false, this method will return null.
	 * @return The current objective of this quest.
	 */
	@Nullable Objective getCurrentObjective();

	/**
	 * Set the current objective of this quest.
	 * @param objective The new objective to set.
	 */
	void setCurrentObjective(@NotNull Objective objective);

	/**
	 * Start this quest.
	 */
	void start();

	/**
	 * Complete this quest.
	 */
	void complete();

	/**
	 * Complete the current objective of this quest.
	 */
	void completeObjective();
}
