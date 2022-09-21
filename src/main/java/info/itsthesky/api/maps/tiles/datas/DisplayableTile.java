package info.itsthesky.api.maps.tiles.datas;

import info.itsthesky.api.maps.tiles.TileData;

import java.awt.image.BufferedImage;

/**
 * Means the tile can be shown somewhere
 */
public interface DisplayableTile extends TileData {

	/**
	 * Get the image of the tile to display.
	 * @return The image of the tile.
	 */
	BufferedImage display();

}
