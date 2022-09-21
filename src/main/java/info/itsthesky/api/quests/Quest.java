package info.itsthesky.api.quests;

import info.itsthesky.api.quests.objectives.Objective;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Represents a quest that can be completed by a player.
 */
public interface Quest {

	/**
	 * Get the name of the quest.
	 * @return The name of the quest.
	 */
	String getName();

	/**
	 * Gets all the objectives of this quest.
	 * @return All the objectives of this quest.
	 */
	@NotNull List<Objective> getObjectives();

	/**
	 * Gets the quest's type.
	 * @return The quest's type.
	 */
	@NotNull QuestType getType();

	/**
	 * Gets the quest's description.
	 * @return The quest's description.
	 */
	@NotNull String getDescription();

	/**
	 * Check if the quest can be repeated.
	 * @return True if the quest can be repeated, false otherwise.
	 */
	boolean isRepeatable();

	/**
	 * Organize the quest's objectives by linking each other to the next or previous one.
	 */
	default void organizeObjectives() {
		List<Objective> objectives = getObjectives();
		for (int i = 0; i < objectives.size(); i++) {
			Objective objective = objectives.get(i);
			if (i == 0) {
				objective.setPreviousObjective(null);
			} else {
				objective.setPreviousObjective(objectives.get(i - 1));
			}
			if (i == objectives.size() - 1) {
				objective.setNextObjective(null);
			} else {
				objective.setNextObjective(objectives.get(i + 1));
			}
		}
	}

	enum QuestType {
		MAIN,
		SIDE,
		DAILY,
		WEEKLY
	}

}
