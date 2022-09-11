package me.colorwell.sprawdzanie.komendy;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.colorwell.sprawdzanie.Main;
import me.colorwell.sprawdzanie.utils.Utils;

public class Czysty implements CommandExecutor{
	
	private Main plugin;
	
	public Czysty(Main pl) {
		plugin = pl;
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		
		
		if(args.length == 1) {
			if (label.equalsIgnoreCase("czysty")) {
			if(args[0].equalsIgnoreCase(p.getDisplayName())) {
				p.sendMessage(Utils.chat("&cNie mozesz sam siebie oznaczyc czystym!"));
			} else {
				if(Teleportacja.targetplayer == null) {
					p.sendMessage(Utils.chat("&cNie ma takiej osoby na serwerze lub podales niepoprawny nickname!"));
				} else {
					if(Teleportacja.targetplayer == Teleportacja.nickname && Teleportacja.Sprawdzany) {
						double x = (double) plugin.getConfig().get("Locations.SpawnX");
						double y = (double) plugin.getConfig().get("Locations.SpawnY");
						double z = (double) plugin.getConfig().get("Locations.SpawnZ");
						Location loc = new Location(p.getWorld(), x, y, z);
						p.teleport(loc);
						Teleportacja.targetplayer.teleport(loc);
						Teleportacja.targetplayer.sendTitle(null, null);
						Teleportacja.Sprawdzany = false;
						Bukkit.broadcastMessage(Utils.chat("&4Gracz " + "&l" + Teleportacja.targetplayer.getDisplayName() + "&r&4 nie jest sprawdzany!"));
					} else {
						p.sendMessage(Utils.chat("&cNie ma takiej osoby na serwerze lub podales niepoprawny nickname!"));
					}
					
					
				}
			}
		}
	}else {
		p.sendMessage(Utils.chat("&4&l✦SPRAWDZANIE KOMENDY✦"));
		p.sendMessage(Utils.chat("&c/sprawdz [GRACZ] &8- Przenosi Gracza oraz osobe wywolujaca komende do sprawdzarki"));
		p.sendMessage(Utils.chat("&c/czysty [GRACZ] &8 - Teleportuje gracza na spawn")); 
		p.sendMessage(Utils.chat("&c/setsprawdz [GRACZ] &8 - Ustawia lokacje sprawdzarki")); 
		p.sendMessage(Utils.chat("&c/setczysty [GRACZ] &8 - Ustawia lokacje spawnu")); 
		p.sendMessage(Utils.chat("&4&l✦SPRAWDZANIE KOMENDY✦"));
	}
		return false;
	}

}
