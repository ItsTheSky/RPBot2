package info.itsthesky.api.quests.objectives;

import info.itsthesky.api.quests.Quest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents an objective of a quest.
 */
public interface Objective {

	/**
	 * Get the quest linked to this objective.
	 * @return The quest linked to this objective.
	 */
	@NotNull Quest getQuest();

	/**
	 * Get the name of the objective.
	 * <br> This should return a literal-string value.
	 * @return The name of the objective.
	 */
	String getName();

	/**
	 * Gets the description of the objective.
	 * @return The description of the objective.
	 */
	String getDescription();

	/**
	 * Gets the possibly-null next objective of this objective.
	 * @return The possibly-null next objective of this objective.
	 */
	@Nullable Objective getNextObjective();

	/**
	 * Gets the possibly-null previous objective of this objective.
	 * @return The possibly-null previous objective of this objective.
	 */
	@Nullable Objective getPreviousObjective();

	void setNextObjective(@Nullable Objective objective);

	void setPreviousObjective(@Nullable Objective objective);
}
