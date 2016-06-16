package me.hyperion.mngr;

import java.io.File;

import org.bukkit.entity.Player;
import me.hyperion.mngr.ScoreManager;

public class UIManager{
	File dataFolder = new File("");
	public UIManager(File file){
		dataFolder = file;
	}
	ScoreManager ScoreManager = new ScoreManager(dataFolder);
	public void refreshScore(Player player)
	{
		player.setLevel(ScoreManager.getScore(player));
	}
}
