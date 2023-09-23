package me.saimon527.scaffoldenhanced.listeners;

import me.saimon527.scaffoldenhanced.ScaffoldEnhanced;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        ScaffoldEnhanced plugin = ScaffoldEnhanced.getScaffoldPlugin();
        Player p = e.getPlayer();
        plugin.scaffoldEnabled.put(p.getUniqueId(), false);
        plugin.scaffoldBlock.put(p.getUniqueId(), Material.COAL_BLOCK);
    }
}
