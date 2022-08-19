package de.kastenklicker.linuxlike;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class Rm implements CommandExecutor {

    private final LinuxLike plugin;

    public Rm(LinuxLike plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length != 2 || !strings[0].equals("-rf")) return false;

        if(!commandSender.hasPermission("LinuxLike.rm")) {
            commandSender.sendMessage(LinuxLike.NAME + "You don't have the Permission to do that!");
            return true;
        }

        File locFile = new File(plugin.getDataFolder(), "directories.yml");
        YamlConfiguration yc = YamlConfiguration.loadConfiguration(locFile);

        if (yc.getString(strings[1]) == null) {
            commandSender.sendMessage(LinuxLike.NAME + "Directory not found!");
            return true;
        }

        yc.set(strings[1], null);
        try {
            yc.save(locFile);
        } catch (IOException e) {
            e.printStackTrace();
            commandSender.sendMessage(LinuxLike.NAME + "Failed to remove directory!");
            return true;
        }

        commandSender.sendMessage(LinuxLike.NAME + "Removed directory.");

        return true;
    }
}
