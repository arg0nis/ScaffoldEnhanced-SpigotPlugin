package me.saimon527.scaffoldenhanced.commands;

import me.saimon527.scaffoldenhanced.ScaffoldEnhanced;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ScaffoldCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {

            ScaffoldEnhanced plugin = ScaffoldEnhanced.getScaffoldPlugin();

            Player p = (Player) sender;

            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("block")) {
                    Inventory blockGui = Bukkit.createInventory(p, 18, ChatColor.AQUA + "Choose block for scaffold.");
                    ItemStack[] blocks = {new ItemStack(Material.GOLD_BLOCK), new ItemStack(Material.DIAMOND_BLOCK), new ItemStack(Material.EMERALD_BLOCK)
                    , new ItemStack(Material.LAPIS_BLOCK), new ItemStack(Material.REDSTONE_BLOCK), new ItemStack(Material.IRON_BLOCK)
                    , new ItemStack(Material.COAL_BLOCK), new ItemStack(Material.OAK_LOG), new ItemStack(Material.OAK_LEAVES)
                    , new ItemStack(Material.YELLOW_CONCRETE), new ItemStack(Material.LIME_CONCRETE), new ItemStack(Material.LIGHT_BLUE_CONCRETE)
                    , new ItemStack(Material.PURPLE_CONCRETE), new ItemStack(Material.YELLOW_WOOL), new ItemStack(Material.ORANGE_WOOL)
                    , new ItemStack(Material.CYAN_WOOL), new ItemStack(Material.BLUE_WOOL), new ItemStack(Material.WHITE_WOOL)};

                    blockGui.setContents(blocks);
                    p.openInventory(blockGui);



                    return true;
                }
            }

            if(args.length == 0) {
                if(plugin.scaffoldEnabled.get(p.getUniqueId())) {
                    plugin.scaffoldEnabled.replace(p.getUniqueId(), false);
                    p.sendMessage("Scaffold" + ChatColor.RED + " disabled.");
                } else {
                    plugin.scaffoldEnabled.replace(p.getUniqueId(), true);
                    p.sendMessage("Scaffold" + ChatColor.GREEN + " enabled.");
                }
            }
        }

        return true;
    }
}
