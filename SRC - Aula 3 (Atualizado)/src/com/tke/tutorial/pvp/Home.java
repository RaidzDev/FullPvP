package com.tke.tutorial.pvp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import com.tke.tutorial.pvp.api.Config;

public class Home {

	public static Config homes = new Config("homes.yml");
	
	private static void setLocation(String player, String home, Location loc){
		homes.set("Homes." + player + "." + home + ".x", loc.getX());
		homes.set("Homes." + player + "." + home + ".y", loc.getY());
		homes.set("Homes." + player + "." + home + ".z", loc.getZ());
		homes.set("Homes." + player + "." + home + ".pitch", loc.getPitch());
		homes.set("Homes." + player + "." + home + ".yaw", loc.getYaw());
		homes.set("Homes." + player + "." + home + ".world", loc.getWorld().getName());
		homes.saveConfig();
	}
	
	private static Location getLocation(String player, String home){
		double x = homes.getDouble("Homes." + player + "." + home + ".x");
		double y = homes.getDouble("Homes." + player + "." + home + ".y");
		double z = homes.getDouble("Homes." + player + "." + home + ".z");
		long pitch = homes.getLong("Homes." + player + "." + home + ".pitch");
		long yaw = homes.getLong("Homes." + player + "." + home + ".yaw");
		World world = Bukkit.getWorld(homes.getString("Homes." + player + "." + home + ".world"));
		Location loc = new Location(world, x, y, z, yaw, pitch);
		return loc;
	}
	
	public static void criarHome(String player, String home, Location loc){
		setLocation(player, home, loc);
	}
	
	public static Location pegarHome(String player, String home){
		return getLocation(player, home);
	}
	
	public static boolean existeHome(String player, String home){
		return homes.contains("Homes." + player + "." + home);
	}
	
	public static void removeHome(String player, String home){
		homes.set("Homes." + player + "." + home, null);
		homes.saveConfig();
	}
	
	
}
