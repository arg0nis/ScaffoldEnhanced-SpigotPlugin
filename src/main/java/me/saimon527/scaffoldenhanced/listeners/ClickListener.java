package me.saimon527.scaffoldenhanced.listeners;

import me.saimon527.scaffoldenhanced.ScaffoldEnhanced;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickListener implements Listener {
    @EventHandler
    public void onPlayerClick(InventoryClickEvent e) {
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Choose block for scaffold.")) {
            e.setCancelled(true);

            ScaffoldEnhanced plugin = ScaffoldEnhanced.getScaffoldPlugin();

            plugin.scaffoldBlock.put(e.getWhoClicked().getUniqueId(), e.getCurrentItem().getType());

            e.getWhoClicked().sendMessage("Item Successfully " + ChatColor.GREEN + "set.");

            e.getWhoClicked().closeInventory();
        }
    }
}
