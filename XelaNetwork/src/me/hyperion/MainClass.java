package me.hyperion;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MainClass extends FileManager implements Listener{
	
	@Override
	public void onEnable()
	{
		//Initialize FileManager
		initFileManager();
		getServer().getPluginManager().registerEvents(this, this);
		//Iterate
		/*Collection<? extends Player> Players = getServer().getOnlinePlayers();
		BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                Object[] a = Players.toArray();
            }
        }, 0L, 20L);
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("XelaNetwork Score Manager has been enabled!");*/
	}
	@Override
	public void onDisable()
	{
		
	}
	
	public void refreshScore(Player player)
	{
		player.setLevel(getScore(player));
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent event)
	{
		this.getLogger().info("Player Joined");
		Player player = event.getPlayer();
		Boolean Created = checkCreated(player);
		if(!Created)
		{
			this.getLogger().severe("Player file not created! Creating file now!");
			createFile(player);
		}
	}
	public boolean onCommand(CommandSender sender, Command cmd,String label, String[] args)
	{
		String command = cmd.getName();
		if(command.equalsIgnoreCase("refreshScore") && sender instanceof Player){
			refreshScore((Player)sender);
		}else if(command.equalsIgnoreCase("setScore") && sender instanceof Player){
			try{
				setScore((Player)sender,Integer.parseInt(args[0]));
			}catch(ArrayIndexOutOfBoundsException e){
				((Player)sender).sendMessage("Sets the score of the current player");
				((Player)sender).sendMessage("/setscore <desired score>");
				e.printStackTrace();
			}
			refreshScore((Player)sender);
		}
		return false;
	}
	
}
