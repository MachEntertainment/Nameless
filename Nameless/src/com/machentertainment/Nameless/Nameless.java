package com.machentertainment.Nameless;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.kitteh.tag.TagAPI;



public class Nameless extends JavaPlugin implements Listener{
	
	public ArrayList<Player> tagPlayers = new ArrayList<Player>();
	
	//TODO
	//Herochat integration, Permissions integration
	
	@Override
	public void onEnable(){
		PluginManager pm = this.getServer().getPluginManager();
		
		getServer().getPluginManager().registerEvents(this, this);
		getLogger().info("Tags Plugin " + this.getDescription().getVersion() + " Has Been Enabled!");
		getLogger().info(this.getDescription().getDescription());
		
		pm.registerEvents(new NamelessTagHandler(this), this);
	}
	@Override
	public void onDisable(){
		getLogger().severe("And the shadows recede revealing those who lurk in them.");
		getLogger().info("Tags Plugin" + this.getDescription().getVersion() +" Has Been Disabled!");
	}
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "You must be a player to use this command.  FUCK OFF!!");
		}
		
		Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("nameless")){
			
			if(args[0].equalsIgnoreCase("hide")){
			
				tagPlayers.add(player);
				TagAPI.refreshPlayer(player);
				player.sendMessage(ChatColor.GREEN + "Your name has removed. You are now nameless.");
			
				return true;
			}
			
			if(args[0].equalsIgnoreCase("unhide")){
				
				tagPlayers.remove(player);
				TagAPI.refreshPlayer(player);
				player.sendMessage(ChatColor.GREEN + "You step out of the shadows.");
			
				return true;
			}
			
			if(args[0].equalsIgnoreCase("list")){
				
				player.sendMessage(ChatColor.GREEN + "Players lurking in the shadows:");
				for(Player p : tagPlayers){
					player.sendMessage(ChatColor.RED + p.getName());
				}
				
				return true;
			}
			
			return false;
		}
		
		
		return false;
	}
}