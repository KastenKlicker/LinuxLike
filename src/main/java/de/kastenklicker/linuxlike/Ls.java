package de.kastenklicker.linuxlike;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class Ls implements CommandExecutor {

    private final LinuxLike plugin;

    public Ls(LinuxLike plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!commandSender.hasPermission("LinuxLike.ls")) {
            commandSender.sendMessage(LinuxLike.NAME + "You don't have the Permission to do that!");
            return true;
        }

        File locFile = new File(plugin.getDataFolder(), "directories.yml");
        YamlConfiguration yc = YamlConfiguration.loadConfiguration(locFile);

        int i = 1;
        commandSender.sendMessage(LinuxLike.NAME + "§7List of all §6directories§7:");
        for (String key : yc.getKeys(true)) {
            if (!key.contains(".")) {
                commandSender.sendMessage("§7" + i + ". §6" + key);
                i++;
            }
        }

        return true;
    }
}
