package com.tke.tutorial.pvp.rankup;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import com.tke.tutorial.pvp.api.Criar;

public class RankInv {

	public static void open(Player p){
		Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§b§lRANK §6§lUP");
		
		inv.setItem(1, Criar.add(Material.IRON_CHESTPLATE, "§9§lCAPITAO"));
		inv.setItem(2, Criar.add(Material.GOLD_CHESTPLATE, "§6§lCORONEL"));
		inv.setItem(3, Criar.add(Material.DIAMOND_CHESTPLATE, "§c§lMARECHAL"));
		
		
		p.openInventory(inv);
		p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1F, 1.5F);
		
	}
	
}
