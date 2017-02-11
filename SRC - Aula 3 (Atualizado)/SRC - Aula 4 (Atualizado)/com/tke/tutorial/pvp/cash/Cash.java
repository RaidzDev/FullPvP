package com.tke.tutorial.pvp.cash;

import com.tke.tutorial.pvp.api.Config;

public class Cash {

	public static Config cash = new Config("cash.yml");
	
	public static void set(String player, int valor){
		cash.set(player, valor);
		cash.saveConfig();
	}
	
	public static int get(String player){
		return cash.getInt(player);
	}
	
	public static void add(String player, int valor){
		set(player, get(player) + valor);
	}
	
	public static void retirar(String player, int valor){
		set(player, get(player) - valor);
	}
	
	public static boolean contains(String player, int valor){
		if (get(player) >= valor){
			return true;
		} else {
			return false;
		}
	}
	
}
