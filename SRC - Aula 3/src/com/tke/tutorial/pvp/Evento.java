package com.tke.tutorial.pvp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.tke.tutorial.pvp.cash.Cash;

public class Evento implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if (!Cash.cash.contains(p.getName())){
			Cash.set(p.getName(), 0);
		}
	}
	
}
