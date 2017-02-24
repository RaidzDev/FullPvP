package com.tke.tutorial.pvp.shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.tke.tutorial.pvp.api.Criar;

public class ShopInv {

	public static void open(Player p){
		Inventory inv = Bukkit.createInventory(null, 6*9, "§6§lShop");
		
		ItemStack sword = Criar.add(Material.DIAMOND_SWORD, "§c§lAPLHA §b§lSWORD", Enchantment.DAMAGE_ALL, 10);
		ItemStack peitoral = Criar.add(Material.DIAMOND_CHESTPLATE, "§c§lAPLHA §b§lCHESTPLATE", new String[] {"", "§7 Peitoral §b§lRARO"}, Enchantment.PROTECTION_ENVIRONMENTAL, 10);
		ItemStack beacon = Criar.add(Material.BEACON, "§cTeste");
		
		
		
		inv.setItem(12, sword);
		inv.setItem(16, peitoral);
		inv.setItem(49, beacon);
		
		
		p.openInventory(inv);
		p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1F, 1.5F);
	}
	
	
	
}
