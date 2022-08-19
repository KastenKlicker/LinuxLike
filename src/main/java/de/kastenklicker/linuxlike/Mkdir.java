package de.kastenklicker.linuxlike;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class Mkdir implements CommandExecutor {

    private final LinuxLike plugin;

    public Mkdir(LinuxLike plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            if (strings.length != 1) return false;

            if(!player.hasPermission("LinuxLike.mkdir")) {
                player.sendMessage(LinuxLike.NAME + "You don't have the Permission to do that!");
                return true;
            }

            File locFile = new File(plugin.getDataFolder(), "directories.yml");
            YamlConfiguration yc = YamlConfiguration.loadConfiguration(locFile);

            Location location = player.getLocation();

            yc.set(strings[0] + ".world", player.getWorld().getName());
            yc.set(strings[0] + ".x", location.getX());
            yc.set(strings[0] + ".y", location.getY());
            yc.set(strings[0] + ".z", location.getZ());
            yc.set(strings[0] + ".yaw", location.getYaw());
            yc.set(strings[0] + ".pitch", location.getPitch());

            try {
                yc.save(locFile);
            } catch (IOException e) {
                e.printStackTrace();
                commandSender.sendMessage(LinuxLike.NAME + "Failed to create new directory!");
                return true;
            }

            player.sendMessage(LinuxLike.NAME + "Created new directory!");
        }
        else commandSender.sendMessage(LinuxLike.NAME + "You must be a player to execute this command!");

        return true;
    }
}
