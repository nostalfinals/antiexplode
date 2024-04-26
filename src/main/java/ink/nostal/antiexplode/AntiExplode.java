package ink.nostal.antiexplode;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

@SuppressWarnings("unused")
public class AntiExplode extends JavaPlugin implements Listener {

    private static int height;

    @Override
    public void onEnable() {
        File configFile = new File(getDataFolder(), "config.yml");

        if (!configFile.exists()) {
            saveDefaultConfig();
        }

        height = getConfig().getInt("height");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    public void entityExplodeEvent(EntityExplodeEvent event) {
        var location = event.getLocation();

        if (location.getY() > height) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void blockExplodeEvent(BlockExplodeEvent event) {
        var location = event.getBlock().getLocation();

        if (location.getY() > height) {
            event.setCancelled(true);
        }
    }

}
