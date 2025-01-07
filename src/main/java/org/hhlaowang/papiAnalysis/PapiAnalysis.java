package org.hhlaowang.papiAnalysis;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PapiAnalysis extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) { //
            new PapiExplain().register(); //
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
