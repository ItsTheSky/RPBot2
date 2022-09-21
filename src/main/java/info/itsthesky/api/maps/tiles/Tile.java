package info.itsthesky.api.maps.tiles;

import info.itsthesky.api.maps.Map;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Represents a tile in a map.
 */
public interface Tile {

	/**
	 * Gets the map of this tile.
	 * @return The map.
	 */
	@NotNull Map getMap();

	/**
	 * Gets the x position of this tile.
	 * @return The x position.
	 */
	int getX();

	/**
	 * Gets the y position of this tile.
	 * @return The y position.
	 */
	int getY();

	/**
	 * Gets a list containing every data of this tile.
	 * @return The list of data.
	 */
	@NotNull List<TileData> getTileData();

	/**
	 * Get a tile data by its class.
	 * @param type The class of the tile data.
	 * @return The tile data.
	 * @throws IllegalArgumentException If the tile data is not found.
	 */
	@NotNull <T extends TileData> T getTileData(@NotNull Class<T> type);

	/**
	 * Check if this tile has a tile data.
	 * @param type The class of the tile data.
	 * @return True if the tile data is found, therefore {@link #getTileData(Class)} will not throw an exception.
	 */
	boolean hasTileData(@NotNull Class<TileData> type);

}
