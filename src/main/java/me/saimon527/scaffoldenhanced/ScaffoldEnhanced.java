package me.saimon527.scaffoldenhanced;

import me.saimon527.scaffoldenhanced.commands.ScaffoldCommand;
import me.saimon527.scaffoldenhanced.listeners.ClickListener;
import me.saimon527.scaffoldenhanced.listeners.PlayerJoinListener;
import me.saimon527.scaffoldenhanced.listeners.PlayerMoveListener;
import me.saimon527.scaffoldenhanced.listeners.PlayerQuitListener;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ScaffoldEnhanced extends JavaPlugin {
    public Map<UUID, Boolean> scaffoldEnabled;
    public Map<UUID, Material> scaffoldBlock;
    public static ScaffoldEnhanced plugin;


    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        this.scaffoldEnabled = new HashMap<>();
        this.scaffoldBlock = new HashMap<>();

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        getServer().getPluginManager().registerEvents(new ClickListener(), this);

        getCommand("scaffold").setExecutor(new ScaffoldCommand());

        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ScaffoldEnhanced getScaffoldPlugin() {
        return plugin;
    }
}
