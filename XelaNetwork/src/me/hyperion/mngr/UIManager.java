package me.hyperion.mngr;

import org.bukkit.entity.Player;
import me.hyperion.mngr.ScoreManager;

public class UIManager{
	ScoreManager ScoreManager = new ScoreManager();
	public void refreshScore(Player player)
	{
		player.setLevel(ScoreManager.getScore(player));
	}
}
