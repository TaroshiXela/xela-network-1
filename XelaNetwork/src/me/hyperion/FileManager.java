package me.hyperion;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FileManager extends JavaPlugin{
	public void initFileManager()
	{
		File configFolder = new File(getDataFolder(),"config.yml");
		if(!configFolder.exists())
		{
			getDataFolder().mkdirs();
		}
	}
	public boolean checkCreated(Player player)
	{
		File Playerfile = new File(getDataFolder()+File.separator+player.getUniqueId()+".yml");
		return Playerfile.exists();
	}
	public boolean createFile(Player player)
	{
		File Playerfile = new File(getDataFolder()+File.separator+player.getUniqueId()+".yml");
		try {
			Playerfile.createNewFile();
			FileConfiguration config = new YamlConfiguration();
			config.set("exp",0);
			config.save(Playerfile);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	public boolean setScore(Player player,Integer score)
	{
		File PlayerFile = new File(getDataFolder()+File.separator+player.getUniqueId()+".yml");
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
		FileConfiguration config = YamlConfiguration.loadConfiguration(new File(getDataFolder()+File.separator+player.getUniqueId()+".yml"));
		return config.getInt("exp");
	}
	
}
