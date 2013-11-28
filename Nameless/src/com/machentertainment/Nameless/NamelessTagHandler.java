package com.machentertainment.Nameless;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.kitteh.tag.PlayerReceiveNameTagEvent;

public class NamelessTagHandler implements Listener{
	
	private Nameless plugin;

	public NamelessTagHandler(Nameless plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onNameTag(PlayerReceiveNameTagEvent event){
		Player namelessPlayer = event.getNamedPlayer();
//		Player namelessPrey = event.getPlayer();
		
		if(plugin.tagPlayers.contains(namelessPlayer)){
			event.setTag(" ");
		}
	}
}
