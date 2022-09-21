package info.itsthesky.api.maps;

import info.itsthesky.api.players.Player;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

/**
 * Manage maps for players.
 */
public interface MapManager {

	/**
	 * Gets the map of the player.
	 * @param player The player to get the map from.
	 * @return The map of the player.
	 */
	@NotNull Map getMap(@NotNull Player player);

	/**
	 * Generate a whole new map for the player.
	 * @param player The player to generate the map for.
	 * @return The generated map.
	 */
	@NotNull Map generateMap(@NotNull Player player);

	/**
	 * Gets all the loaded maps.
	 * @return All the loaded maps.
	 */
	@NotNull List<MapInfo> getLoadedMaps();

	/**
	 * Force a load of all the maps.
	 * @throws IOException If an I/O error occurs while loading the maps.
	 */
	void loadMaps() throws IOException;

	/**
	 * Force a save of all the maps.
	 * @throws IOException If an I/O error occurs while saving the maps.
	 */
	void saveMaps() throws IOException;

}
