package me.colorwell.sprawdzanie.Eventy;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;

import me.colorwell.sprawdzanie.komendy.Teleportacja;
import me.colorwell.sprawdzanie.utils.Utils;


public class Banowanie implements Listener{

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if(Teleportacja.Sprawdzany == true) {
			if(p.getName() == Teleportacja.nickname.getName()) {
				p.setBanned(true);
				String bumper = StringUtils.repeat("\n", 4);
				Bukkit.broadcastMessage(Utils.chat("&b[Nazwa Serwera]&7 - &c Gracz " + p.getDisplayName() + " wylogowal sie podczas sprawdzania"));
				Teleportacja.Sprawdzany = false;
				p.kickPlayer((Utils.chat("&b[NAZWA SERWERA] &4&lZOSTALES ZBANOWANY &b[NAZWA SERWERA]") +
						bumper 
						+ "&7Uwazasz ze twoj ban byl niesluszny?\nWejdz na naszego discorda! \n" + "&bDISCORDLINK" + bumper + "&b[NAZWA SERWERA] &4&lZOSTALES ZBANOWANY &b[NAZWA SERWERA]"));		
			}
		}	
	}
	
	@EventHandler(priority = EventPriority.HIGH)
    public void onPlayerBanned (PlayerLoginEvent event) {
		Player player = event.getPlayer();
		String bumper = StringUtils.repeat("\n", 4);		
	
	if (event.getResult() == Result.KICK_BANNED)
	{
	  String msg = Utils.chat("&b[NAZWA SERWERA] &4&lZOSTALES ZBANOWANY &b[NAZWA SERWERA]" + bumper + "&7Uwazasz ze twoj ban byl niesluszny?\nWejdz na naszego discorda! \n" + "&bDISCORDLINK" + bumper + "&b[NAZWA SERWERA] &4&lZOSTALES ZBANOWANY &b[NAZWA SERWERA]" );	
	  if (msg != null)
	      event.setKickMessage(msg);
	}
	}
}
