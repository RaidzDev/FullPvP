package com.tke.tutorial.pvp.shop;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import com.tke.tutorial.pvp.api.Config;
import com.tke.tutorial.pvp.api.Criar;

public class Teste {

	public static HashMap<String, Long> tempo = new HashMap<String, Long>();
	public static Config config = new Config("delays.yml");
	
	public static void addItem(Player p){
		if (tempo.containsKey(p.getName())){
			if (Passou(p)){
				tempo.remove(p.getName());
			} else {
				p.sendMessage(getTempo(p) + "§cpara pegar o kit novamente");
				return;
			}
		}
		Date atual = new Date();
		atual.setSeconds(atual.getSeconds() + 30);
		
		tempo.put(p.getName(), atual.getTime());
		p.getInventory().addItem(Criar.add(Material.ANVIL, "§b§lXUXU BLZ 22", Enchantment.DAMAGE_ALL, 100));
		p.sendMessage("§aVocê pegou o kit");
	}
	
	public static boolean Passou(Player p){
		Date vencimento = new Date(tempo.get(p.getName()));
		Date atual = new Date();
		if (atual.after(vencimento)){
			return true;
		} else {
			return false;
		}
	}
	
	public static String getTempo(Player p){
		Date vencimento = new Date(tempo.get(p.getName()));
		Date atual = new Date();
		
		long variacao = atual.getTime() - vencimento.getTime();
		long varsegundos = variacao / 1000 % 60;
		long varminutos = variacao / 60000 % 60;
		long varhoras = variacao / 3600000  % 24;
		long vardias = variacao / 86400000  % 7;
		
		String segundos = String.valueOf(varsegundos).replaceAll("-", "");
		String minutos = String.valueOf(varminutos).replaceAll("-", "");
		String horas = String.valueOf(varhoras).replaceAll("-", "");
		String dias = String.valueOf(vardias).replaceAll("-", "");
		if (dias.equals("0") && horas.equals("0") && minutos.equals("0")){
			return "§cVocê precisa aguardar §f" + segundos + "§cs ";
		}
		if (dias.equals("0") && horas.equals("0")){
			return "§cVocê precisa aguardar §f" + minutos + "§cm §f" + segundos + "§cs ";
		}
		if (dias.equals("0")){
			return "§cVocê precisa aguardar §f" + horas + "§ch §f" + minutos + "§cm §f" + segundos + "§cs ";
		}
		return "§cVocê precisa aguardar §f" + horas + "§ch §f" + minutos + "§cm §f" + segundos + "§cs ";
	}
	
	
}
