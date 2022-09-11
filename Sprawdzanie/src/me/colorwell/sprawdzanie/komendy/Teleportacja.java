package me.colorwell.sprawdzanie.komendy;



import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.util.concurrent.Service.Listener;

import me.colorwell.sprawdzanie.Main;
import me.colorwell.sprawdzanie.utils.Utils;




public class Teleportacja extends Listener implements CommandExecutor {

	private Main plugin;
	
	public Teleportacja(Main pl) {
		plugin = pl;
	}
	
	public static boolean Sprawdzany = false;
	public static Player nickname;
	public static Player targetplayer;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		 

		Player p = (Player) sender;
		

		String dclink = "https://discord.gg/XJxSAA4bUc";
		
		if(args.length == 1) {
			if (label.equalsIgnoreCase("sprawdz")) {
				Player targetplayer = Bukkit.getPlayerExact(args[0]);
				Teleportacja.targetplayer = targetplayer;
				nickname = targetplayer;
				
				if(Sprawdzany) {
					p.sendMessage(Utils.chat("&cGracz jest juz sprawdzany!"));
					return true;
				}
				
				
				if(sender instanceof Player) {
					if(args[0].equalsIgnoreCase(sender.getName())){
							p.sendMessage(Utils.chat("&cNie mozesz sam siebie sprawdzic!"));
						} else {
							if(args[0] == "cheaty") {
								p.sendMessage(Utils.chat("&cNie ma osoby na serwerze lub podales zly nickname!"));
							} if(targetplayer == null ) {
								p.sendMessage(Utils.chat("&cNie ma takiej osoby na serwerze lub podales niepoprawny nickname!"));
							}
								else {
							
									
									Sprawdzany = true;
									
								//-------------------
							int id = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
								@Override
							public void run() {
								targetplayer.sendTitle(Utils.chat("&4&lJESTES SPRAWDZANY"), Utils.chat("&4[!] &8UDAJ SIE NA NASZEGO DISCORDA &4[!]"));
								}
							}, 0, 20);
							Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
								@Override
							public void run() {
								Bukkit.getScheduler().cancelTask(id);
							}	
							}, 40);
								//---------------
							double x = (double) plugin.getConfig().get("Locations.SprawdzarkaX");
							double y = (double) plugin.getConfig().get("Locations.SprawdzarkaY");
							double z = (double) plugin.getConfig().get("Locations.SprawdzarkaZ");
							Location loc = new Location(p.getWorld(), x, y, z);
							p.teleport(loc);
							targetplayer.teleport(p);
							
							
							
							Bukkit.broadcastMessage(Utils.chat("&4&l✦SPRAWDZANIE✦"));
							Bukkit.broadcastMessage(Utils.chat("&8Sprawdzany Gracz: " + "&c"+targetplayer.getDisplayName()));
							Bukkit.broadcastMessage(Utils.chat("&8Admin Sprawdzajacy: " + "&c" + p.getDisplayName()));
							Bukkit.broadcastMessage(Utils.chat("&cGracz jest posadzony o cheaty!"));
							Bukkit.broadcastMessage(Utils.chat("&4&l✦SPRAWDZANIE✦"));
							targetplayer.sendMessage(Utils.chat("&4&l✦Jestes Sprawdzany✦"));
							targetplayer.sendMessage(Utils.chat("&8Udaj sie na naszego discorda: " + "&c" + dclink));
							targetplayer.sendMessage(Utils.chat("&8Przyznanie sie do cheatow ="  + "&c3d BAN"));
							targetplayer.sendMessage(Utils.chat("&8Cheaty(bez przyznania sie) =" + "&c7d BAN"));
							targetplayer.sendMessage(Utils.chat("&8Brak wspolpraczy =" + "&cPERM"));
							targetplayer.sendMessage(Utils.chat("&4&l✦Jestes Sprawdzany✦"));
								}				
	}
					
					
					
				} 
				}
		
		} else {
			p.sendMessage(Utils.chat("&4&l✦SPRAWDZANIE KOMENDY✦"));
			p.sendMessage(Utils.chat("&c/sprawdz [GRACZ] &8- Przenosi Gracza oraz osobe wywolujaca komende do sprawdzarki"));
			p.sendMessage(Utils.chat("&c/czysty [GRACZ] &8 - Teleportuje gracza na spawn")); 
			p.sendMessage(Utils.chat("&c/setsprawdz &8 - Ustawia lokacje sprawdzarki")); 
			p.sendMessage(Utils.chat("&c/setczysty &8 - Ustawia lokacje spawnu")); 
			p.sendMessage(Utils.chat("&4&l✦SPRAWDZANIE KOMENDY✦"));
		}
		
		
		return false;
	}
	
	
	
	
	
}








