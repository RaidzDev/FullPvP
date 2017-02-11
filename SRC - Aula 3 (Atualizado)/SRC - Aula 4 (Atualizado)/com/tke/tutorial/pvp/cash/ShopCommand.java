package com.tke.tutorial.pvp.cash;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tke.tutorial.pvp.shop.ShopInv;

public class ShopCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		
		if (!(sender instanceof Player)) return true;
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("shop")){
			ShopInv.open(p);
		}
		return false;
	}
	
	

}
