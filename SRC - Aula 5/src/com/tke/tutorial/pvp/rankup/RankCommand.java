package com.tke.tutorial.pvp.rankup;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.tke.tutorial.pvp.Ptag;

public class RankCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) return true;
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("npc")){
			if (!p.isOp()){
				p.sendMessage(Ptag.prefix + "§cVocê não tem permissão!");
				return true;
			}
			
			Villager villager = (Villager)p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
			villager.setAdult();
			villager.setCustomName("§6§lRANK §b§lUP");
			villager.setCustomNameVisible(true);
			villager.setProfession(Profession.BLACKSMITH);
			villager.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99*99*99, 7));
		}
		return false;
	}

}
