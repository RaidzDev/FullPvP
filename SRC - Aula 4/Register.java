package com.tke.tutorial.pvp;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

import com.tke.tutorial.pvp.cash.Cash;
import com.tke.tutorial.pvp.cash.CashCommand;
import com.tke.tutorial.pvp.cash.ShopCommand;
import com.tke.tutorial.pvp.rankup.Rank;
import com.tke.tutorial.pvp.rankup.RankCommand;
import com.tke.tutorial.pvp.shop.ShopEvent;

public class Register {

	public Register(Main pl) {
		RegisterEvents(pl);
		RegisterCommands(pl);
	}
	
	void C(CommandExecutor classe, String comando, Main pl){
		pl.getCommand(comando).setExecutor(classe);
	}


	void E(Listener classe, Main pl){
		Bukkit.getPluginManager().registerEvents(classe, pl);
	}


	void RegisterEvents(Main pl){
		E(new Evento(), pl);
		E(new ShopEvent(), pl);
		E(new Rank(), pl);
	}
	
	void RegisterCommands(Main pl){
		C(new HomeCommand(), "sethome", pl);
		C(new HomeCommand(), "home", pl);
		C(new HomeCommand(), "listhomes", pl);
		C(new HomeCommand(), "delhome", pl);
		C(new CashCommand(), "cash", pl);
		C(new ShopCommand(), "shop", pl);
		C(new RankCommand(), "npc", pl);
	}
	
}
