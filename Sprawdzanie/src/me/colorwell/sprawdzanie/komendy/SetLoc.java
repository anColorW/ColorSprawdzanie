package me.colorwell.sprawdzanie.komendy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.colorwell.sprawdzanie.Main;
import me.colorwell.sprawdzanie.utils.Utils;

public class SetLoc implements CommandExecutor{

	private Main plugin;
	
	public SetLoc(Main pl) {
		plugin = pl;
	}
	
	public static double sprnewX;
	public static double sprnewY;
	public static double sprnewZ;
	
	public static double spawnnewX;
	public static double spawnnewY;
	public static double spawnnewZ;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		sprnewX = p.getLocation().getBlockX();
		sprnewY = p.getLocation().getBlockY();
		sprnewZ = p.getLocation().getBlockZ();
		
		spawnnewX = p.getLocation().getBlockX();
		spawnnewY = p.getLocation().getBlockY();
		spawnnewZ = p.getLocation().getBlockZ();
		
		if(args.length > 0) {
			p.sendMessage(Utils.chat("&4Zle uzyles komendy!"));
		} else {
			if (label.equalsIgnoreCase("setsprawdz")) {
				plugin.getConfig().set("Locations.SprawdzarkaX", sprnewX);
				plugin.getConfig().set("Locations.SprawdzarkaY", sprnewY);
				plugin.getConfig().set("Locations.SprawdzarkaZ", sprnewZ);
				p.sendMessage(Utils.chat("&aLokalizacja sprawdzarki zostala poprawnie ustawiona!"));
				
			} else {
				if(label.equalsIgnoreCase("setczysty")) {
					plugin.getConfig().set("Locations.SpawnX", spawnnewX);
					plugin.getConfig().set("Locations.SpawnY", spawnnewY);
					plugin.getConfig().set("Locations.SpawnZ", spawnnewZ);
					p.sendMessage(Utils.chat("&aLokalizacja spawnu zostala poprawnie ustawiona!"));
				} else {
					return true;
				}
			}
		}
			
		
		
		plugin.saveConfig();
		plugin.reloadConfig();
		return false;
	}
}
