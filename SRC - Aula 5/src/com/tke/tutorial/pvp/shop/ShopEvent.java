package com.tke.tutorial.pvp.shop;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.tke.tutorial.pvp.Ptag;
import com.tke.tutorial.pvp.api.Criar;
import com.tke.tutorial.pvp.cash.Cash;

public class ShopEvent implements Listener {

	@EventHandler
	public void onShop(InventoryClickEvent e){
		if (!(e.getWhoClicked() instanceof Player)){
			return;
		}
		Player p = (Player)e.getWhoClicked();
		if (e.getInventory().getName().equals("§6§lShop")){
			e.setCancelled(true);
			if (e.getCurrentItem() == null) return;
			if (e.getCurrentItem().getType() == Material.AIR) return;
			if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
			ItemStack item = e.getCurrentItem();
			switch (item.getItemMeta().getDisplayName()) {
			case "§c§lAPLHA §b§lCHESTPLATE":
				if (Cash.contains(p.getName(), 10000)){
					p.getInventory().addItem(Criar.add(Material.DIAMOND_CHESTPLATE, "§c§lAPLHA §b§lCHESTPLATE", new String[] {"", "§7 Peitoral §b§lRARO"}, Enchantment.PROTECTION_ENVIRONMENTAL, 10));
					p.updateInventory();
					p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
					Cash.retirar(p.getName(), 10000);
				} else {
					p.sendMessage(Ptag.prefix + "§cVocê não tem dinheiro suficientes!");
					return;
				}
				break;
			case "§c§lAPLHA §b§lSWORD":
				if (Cash.contains(p.getName(), 15000)){
					p.getInventory().addItem(Criar.add(Material.DIAMOND_SWORD, "§c§lAPLHA §b§lSWORD", Enchantment.DAMAGE_ALL, 10));
					p.updateInventory();
					p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
					Cash.retirar(p.getName(), 15000);
				} else {
					p.sendMessage(Ptag.prefix + "§cVocê não tem dinheiro suficientes!");
					return;
				}
				break;
			case "§cTeste":
				Teste.addItem(p);
				break;
			default:
				return;
			}

		}
	}

}
