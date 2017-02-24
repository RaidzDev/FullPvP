package com.tke.tutorial.pvp;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {

		final Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("sethome")){
			if (Home.homes.contains("Homes." + p.getName())){
				int quantidade = Home.homes.getConfig().getConfigurationSection("Homes." + p.getName()).getKeys(false).size();
				if ((quantidade > 10) && (!p.hasPermission("pvp.ignorarlimitehomes"))){
					p.sendMessage("§cVocê atingiu o limite de homes para jogadores normais");
					return true;
				}
			}
			if (args.length == 0){
				Home.criarHome(p.getName(), "Casa", p.getLocation());
				p.sendMessage("§fCasa §asetada com sucesso!");
				return true;
			}
			if (args.length == 1){
				String home = args[0];
				Home.criarHome(p.getName(), home, p.getLocation());
				p.sendMessage("§f" + home + " §asetada com sucesso!");
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("home")){
			if (args.length == 0){
				if (!Home.existeHome(p.getName(), "Casa")){
					p.sendMessage("§cSua home padrão não foi setada!");
					return true;
				}
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
					public void run() {
						p.teleport(Home.pegarHome(p.getName(), "Casa"));
						p.sendMessage("§aTeletransportado para: §fCasa");
					}
				}, 5*20);
			}
			if (args.length == 1){
				final String home = args[0];
				if (!Home.existeHome(p.getName(), home)){
					p.sendMessage("§cHome §f" + home + " não foi encontrada!");
					return true;
				}
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
					public void run() {
						p.teleport(Home.pegarHome(p.getName(), home));
						p.sendMessage("§aTeletransportado para: §f" + home);
					}
				}, 5*20);
			}
		}
		if (cmd.getName().equalsIgnoreCase("listhomes")){
			if (!Home.homes.contains("Homes." + p.getName())){
				p.sendMessage("§cVocê não contem nenhuma home!");
				return true;
			}
			StringBuilder sb = new StringBuilder();
			for (String homes : Home.homes.getConfig().getConfigurationSection("Homes." + p.getName()).getKeys(false)){
				sb.append("§e" + homes);
				sb.append("§f,");
			}
			p.sendMessage("§bSuas homes: " + sb.toString());
		}
		if (cmd.getName().equalsIgnoreCase("delhome")){
			String home = args[0];
			if (!Home.existeHome(p.getName(), home)){
				p.sendMessage("§f" + home + "§c não foi encontrada");
				return true;
			}
			Home.removeHome(p.getName(), home);
		}
		return false;
	}

}
