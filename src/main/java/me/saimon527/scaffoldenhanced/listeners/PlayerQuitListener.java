package me.saimon527.scaffoldenhanced.listeners;

import me.saimon527.scaffoldenhanced.ScaffoldEnhanced;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        ScaffoldEnhanced plugin = ScaffoldEnhanced.getScaffoldPlugin();

        plugin.scaffoldEnabled.remove(e.getPlayer().getUniqueId());
        plugin.scaffoldBlock.remove(e.getPlayer().getUniqueId());
    }
}
