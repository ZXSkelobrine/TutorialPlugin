package zx.tutorial.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public String message[] = new String[2];
    public boolean uc = false;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        message[0] = this.getConfig().getString("messageP");
        message[1] = this.getConfig().getString("messageS");
        uc = this.getConfig().getBoolean("useCustom");
        getLogger().info("Plugin has been enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin has been disabled");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player;
        boolean server = false;
        //player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("hello")) {
            if (sender instanceof Player) {
                if (uc) {
                    sender.sendMessage(message[0]);
                } else {
                    sender.sendMessage("Hello. You are a player");
                }
            } else {
                server = true;
                if (uc) {
                    sender.sendMessage(message[1]);
                } else {
                    sender.sendMessage("Hello. You are a server");
                }
            }
            return true;
        }
        return false;
    }
}
