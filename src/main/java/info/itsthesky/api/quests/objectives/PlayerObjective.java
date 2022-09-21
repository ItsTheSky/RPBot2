package info.itsthesky.api.quests.objectives;

import info.itsthesky.api.quests.PlayerQuest;
import info.itsthesky.api.utils.Savable;
import org.jetbrains.annotations.NotNull;

/**
 * Represents the data of an objective of a quest for a player.
 */
public interface PlayerObjective extends Savable {

	@NotNull PlayerQuest getPlayerQuest();

	@NotNull Objective getObjective();

	@NotNull ObjectiveState getState();

}
