package me.saimon527.scaffoldenhanced.listeners;

import me.saimon527.scaffoldenhanced.ScaffoldEnhanced;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        ScaffoldEnhanced plugin = ScaffoldEnhanced.getScaffoldPlugin();
        Player p = (Player) e.getPlayer();
        if(plugin.scaffoldEnabled.get(p.getUniqueId()) != null && plugin.scaffoldEnabled.get(p.getUniqueId())) {
            Location loc = p.getLocation();
            loc.setY(loc.getY() - 1);
            loc.getBlock().setType(plugin.scaffoldBlock.get(p.getUniqueId()));
        }
    }
}
