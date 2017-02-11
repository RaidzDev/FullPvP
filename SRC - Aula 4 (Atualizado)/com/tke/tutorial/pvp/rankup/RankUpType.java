package com.tke.tutorial.pvp.rankup;

import java.util.HashMap;

public enum RankUpType {

	SOLDADO,CAPITAO,CORONEL,MARECHAL;
	
	public static HashMap<String, RankUpType> rank = new HashMap<String, RankUpType>();
	
	public static void setRank(String name, RankUpType type){
		if (rank.containsKey(name)){
			rank.remove(name);
		}
		Rank.crank.set(name, type.toString().toUpperCase());
		Rank.crank.saveConfig();
		rank.put(name, type);
	}
	
	public static boolean containsRank(String name){
		return rank.containsKey(name);
	}
	
	public static boolean containsRank(String name, RankUpType type){
		if (containsRank(name)){
			if (rank.get(name) == type || rank.get(name).equals(type)){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static void removeRank(String name){
		if (containsRank(name)){
			rank.remove(name);
			Rank.crank.set(name, null);
			Rank.crank.saveConfig();
		}
	}
	
}
