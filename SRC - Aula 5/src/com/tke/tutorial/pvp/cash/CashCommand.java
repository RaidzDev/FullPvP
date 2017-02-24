package com.tke.tutorial.pvp.cash;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CashCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {

		if (cmd.getName().equalsIgnoreCase("cash")){
			Player p = (Player)sender;
			if (args.length == 0){
				if (p.hasPermission("pvp.cash")){
					p.sendMessage("§cUse: §f/cash §7(set, add, retirar)");
				}
				p.sendMessage("§bSeus cash: §f" + Cash.get(p.getName()));
				return true;
			}

			if (args.length > 0){
				if (!p.hasPermission("pvp.cash")){
					p.sendMessage("§cVocê não tem permissão!");
					return true;
				}
				if (args[0].equalsIgnoreCase("set")){
					if (args.length == 1){
						p.sendMessage("§cUse: §f/cash set §7(player, valor)");
						return true;
					}
					String target = args[1];
					String numero = args[2];
					if (!Cash.cash.contains(target)){
						p.sendMessage("Este jogador não existe!");
						return true;
					}
					Integer valor;
					try {
						valor = Integer.parseInt(numero);
					} catch (NumberFormatException e) {
						p.sendMessage("§cDigite um valor válido!");
						return true;
					}
					Cash.set(target, valor);
					p.sendMessage("§bVocê setou os cash do jogador §f" + target + "§b para §f" + valor);
				}
				if (args[0].equalsIgnoreCase("add")){
					if (args.length == 1){
						p.sendMessage("§cUse: §f/cash add §7(player, valor)");
						return true;
					}
					String target = args[1];
					String numero = args[2];
					if (!Cash.cash.contains(target)){
						p.sendMessage("Este jogador não existe!");
						return true;
					}
					Integer valor;
					try {
						valor = Integer.parseInt(numero);
					} catch (NumberFormatException e) {
						p.sendMessage("§cDigite um valor válido!");
						return true;
					}
					Cash.add(target, valor);
					p.sendMessage("§bVocê adicionou §f" + valor + "§b cash para o jogador §f" + target);
				}
				if (args[0].equalsIgnoreCase("retirar")){
					if (args.length == 1){
						p.sendMessage("§cUse: §f/cash retirar §7(player, valor)");
						return true;
					}
					String target = args[1];
					String numero = args[2];
					if (!Cash.cash.contains(target)){
						p.sendMessage("Este jogador não existe!");
						return true;
					}
					Integer valor;
					try {
						valor = Integer.parseInt(numero);
					} catch (NumberFormatException e) {
						p.sendMessage("§cDigite um valor válido!");
						return true;
					}
					Cash.retirar(target, valor);
					p.sendMessage("§bVocê retirou §f" + valor + "§b de cash do jogador §f" + target);
				}
			}
		}

		return false;
	}

}
