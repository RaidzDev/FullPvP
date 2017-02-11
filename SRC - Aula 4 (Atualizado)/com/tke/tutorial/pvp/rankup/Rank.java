package com.tke.tutorial.pvp.rankup;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import com.tke.tutorial.pvp.Ptag;
import com.tke.tutorial.pvp.api.Config;
import com.tke.tutorial.pvp.cash.Cash;

public class Rank implements Listener{

	@EventHandler
	public void onRankUP(InventoryClickEvent e){
		if (!(e.getWhoClicked() instanceof Player)) return;
		Player p = (Player)e.getWhoClicked();
		if (e.getInventory().getTitle().equals("§b§lRANK §6§lUP")){
			e.setCancelled(true);
			if (e.getCurrentItem() == null) return;
			if (e.getCurrentItem().getType() == Material.AIR) return;
			if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
			ItemStack item = e.getCurrentItem();
			switch (item.getItemMeta().getDisplayName()) {
			case "§9§lCAPITAO":
				if (RankUpType.rank.get(p.getName()) != RankUpType.SOLDADO){
					p.sendMessage(Ptag.prefix + "§cVocê precisa ser Soldado para upar para Capitão!");
					return;
				}
				if (!Cash.contains(p.getName(), 50000)){
					p.sendMessage(Ptag.prefix + "§cVocê precisa de 50.000 para poder UPAR de Rank");
					return;
				}
				Cash.retirar(p.getName(), 50000);
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("§7[§6§lRANK§b§lUP§7] §7: §f" + p.getName() + "§b Upou para §9§lCAPITAO");
				Bukkit.broadcastMessage("");
				RankUpType.setRank(p.getName(), RankUpType.CAPITAO);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
				p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
				p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
				break;
			case "§6§lCORONEL":
				if (RankUpType.rank.get(p.getName()) != RankUpType.CAPITAO){
					p.sendMessage(Ptag.prefix + "§cVocê precisa ser Capitão para upar para Coronel!");
					return;
				}
				if (!Cash.contains(p.getName(), 100000)){
					p.sendMessage(Ptag.prefix + "§cVocê precisa de 100.000 para poder UPAR de Rank");
					return;
				}
				Cash.retirar(p.getName(), 100000);
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("§7[§6§lRANK§b§lUP§7] §7: §f" + p.getName() + "§b Upou para §6§lCORONEL");
				Bukkit.broadcastMessage("");
				RankUpType.setRank(p.getName(), RankUpType.CORONEL);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
				p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
				p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
				break;
			case "§c§lMARECHAL":
				if (RankUpType.rank.get(p.getName()) != RankUpType.CORONEL){
					p.sendMessage(Ptag.prefix + "§cVocê precisa ser Coronel para upar para Marechal!");
					return;
				}
				if (!Cash.contains(p.getName(), 150000)){
					p.sendMessage(Ptag.prefix + "§cVocê precisa de 150.000 para poder UPAR de Rank");
					return;
				}
				Cash.retirar(p.getName(), 150000);
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("§7[§6§lRANK§b§lUP§7] §7: §f" + p.getName() + "§b Upou para §c§lMARECHAL");
				Bukkit.broadcastMessage("");
				RankUpType.setRank(p.getName(), RankUpType.MARECHAL);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
				p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
				p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
				break;
			default:
				break;
			}

		}
	}

	@EventHandler
	public void onVillagerDano(EntityDamageByEntityEvent e){
		if (!(e.getEntity() instanceof Villager)) return;
		Villager villager = (Villager)e.getEntity();
		if (villager.getCustomName() != null){
			if (villager.getCustomName().contains("§6§lRANK §b§lUP")){
				e.setCancelled(true);
				if (e.getDamager() instanceof Player && e.getDamager().isOp()){
					Player p = (Player)e.getDamager();
					if (p.getItemInHand().getType() == Material.GOLD_SWORD){
						villager.damage(1000);
					}
				}
			}
		}
	}

	@EventHandler
	public void onInteracao(PlayerInteractEntityEvent e){
		if (e.getRightClicked() instanceof Villager){
			Villager villager = (Villager)e.getRightClicked();
			Player p = e.getPlayer();
			if (villager.getCustomName() != null){
				if (villager.getCustomName().contains("§6§lRANK §b§lUP")){
					e.setCancelled(true);
					RankInv.open(p);
				}
			}
		}
	}

	public static Config crank = new Config("rank.yml");

	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if (crank.contains(p.getName())){
			RankUpType.setRank(p.getName(), RankUpType.valueOf(crank.getString(p.getName())));
		} else {
			RankUpType.setRank(p.getName(), RankUpType.SOLDADO);
		}
	}

































}
