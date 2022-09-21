package info.itsthesky.api.utils;

import info.itsthesky.api.maps.Map;
import net.dv8tion.jda.internal.utils.Checks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a location within a map.
 * @author ItsTheSky
 */
public interface Location extends Savable {

	static Location of(int x, int y) {
		return of(null, x, y);
	}

	static Location of(@Nullable Map map, int x, int y) {
		return new LocationImpl(map, x, y);
	}

	static Location of(@NotNull DataObject object) {
		Checks.notNull(object, "object");

		return new LocationImpl(object);
	}

	/**
	 * The possibly-null map that this location was created from.
	 * @return The map.
	 */
	@Nullable Map getMap();

	/**
	 * The x position of this location.
	 * @return The x position.
	 */
	int getX();

	/**
	 * The y position of this location.
	 * @return The y position.
	 */
	int getY();

	final class LocationImpl implements Location {

		private final @Nullable Map map;
		private final int x;
		private final int y;

		private LocationImpl(@Nullable Map map, int x, int y) {
			this.map = map;
			this.x = x;
			this.y = y;
		}

		private LocationImpl(@NotNull DataObject object) {
			// TODO: 17/09/2022 Implements map loading
			this.map = null;

			this.x = object.getOrDefault("x", 0);
			this.y = object.getOrDefault("y", 0);
		}

		@Override
		public @Nullable Map getMap() {
			return map;
		}

		@Override
		public int getX() {
			return x;
		}

		@Override
		public int getY() {
			return y;
		}

		@Override
		public DataObject save() {
			return DataObject.empty()
					.put("x", x)
					.put("y", y)
					.putOpt(x != 0 ? null : "test", Location.of(6, 6));
		}

		@Override
		public String toString() {
			return "LocationImpl{" +
					"map=" + map +
					", x=" + x +
					", y=" + y +
					'}';
		}
	}

}
