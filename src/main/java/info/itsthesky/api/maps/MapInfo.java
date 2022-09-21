package info.itsthesky.api.maps;

import info.itsthesky.api.players.Player;
import org.jetbrains.annotations.NotNull;

public interface MapInfo {

	@NotNull Player getPlayer();

	@NotNull Map getMap();

}
