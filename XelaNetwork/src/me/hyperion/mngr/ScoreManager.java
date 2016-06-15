package me.hyperion.mngr;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ScoreManager{
	FileManager FileManager = new FileManager();
	public boolean setScore(Player player,Integer score)
	{
		File PlayerFile = FileManager.getFile(player);
		try {
			FileConfiguration config = YamlConfiguration.loadConfiguration(PlayerFile);
			config.set("exp",score);
			config.save(PlayerFile);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public Integer getScore(Player player)
	{
		FileConfiguration config = YamlConfiguration.loadConfiguration(FileManager.getFile(player));
		return config.getInt("exp");
	}
}
