package info.itsthesky.api.maps;

import info.itsthesky.api.maps.tiles.Tile;
import info.itsthesky.api.utils.Location;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Represents a map where a player can move.
 */
public interface Map {

	/**
	 * Gets the unique id of this map.
	 * @return The id.
	 */
	@NotNull String getId();

	/**
	 * Gets the name of this map.
	 * @return The name.
	 */
	@NotNull String getName();

	/**
	 * Gets the tiles composing the map.
	 * @return The tiles.
	 */
	@NotNull List<Tile> getTiles();

	/**
	 * Gets a specific {@link info.itsthesky.api.utils.Location} from this map.
	 * @param x The x position.
	 * @param y The y position.
	 * @return The location.
	 */
	@NotNull Location getLocation(int x, int y);

	/**
	 * Gets a specific {@link Tile} from this map.
	 * @param x The x position.
	 * @param y The y position.
	 * @return The tile.
	 */
	@NotNull Tile getTile(int x, int y);

}
