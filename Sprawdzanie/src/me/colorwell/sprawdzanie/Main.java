package me.colorwell.sprawdzanie;


import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.colorwell.sprawdzanie.Eventy.Banowanie;
import me.colorwell.sprawdzanie.komendy.Czysty;
import me.colorwell.sprawdzanie.komendy.SetLoc;
import me.colorwell.sprawdzanie.komendy.Teleportacja;


public class Main extends JavaPlugin implements CommandExecutor {
	
	public static Main instance;
	
	public static double sprX;
	public static double sprY;
	public static double sprZ;
	
	public static double spwnX;
	public static double spwnY;
	public static double spwnZ;
	

	
	
	public static FileConfiguration cfg;
	
	public void onEnable() {
		getCommand("sprawdz").setExecutor(new Teleportacja(this));
		getCommand("czysty").setExecutor(new Czysty(this));
		getCommand("setsprawdz").setExecutor(new SetLoc(this));
		getCommand("setczysty").setExecutor(new SetLoc(this));
		getServer().getPluginManager().registerEvents(new Banowanie(), this);
		instance = this;
		 reloadConfig();
	}
	
	
	public void loadloc() {
		cfg.addDefault("Locations.SprawdzarkaX", -28.457);
		cfg.addDefault("Locations.SprawdzarkaY", 64);
		cfg.addDefault("Locations.SprawdzarkaZ", 300.628);
		
		cfg.addDefault("Locations.SpawnX", -28.457);
		cfg.addDefault("Locations.SpawnY", 64);
		cfg.addDefault("Locations.SpawnZ", 300.628);
		cfg.options().copyDefaults(true);
		saveConfig();
		reloadConfig();
	}
	
	public void loaddbl() {
		sprX = cfg.getDouble("Locations.SprawdzarkaX");
		sprY = cfg.getDouble("Locations.SprawdzarkaY");
		sprZ = cfg.getDouble("Locations.SprawdzarkaZ");
		
		spwnX = cfg.getDouble("Locations.SpawnX");
		spwnY = cfg.getDouble("Locations.SpawnY");
		spwnZ = cfg.getDouble("Locations.SpawnZ");
	}
	
	public static Main getInstance() {
        return instance;
    }
	
	
	
	
}
