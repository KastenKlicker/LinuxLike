package de.kastenklicker.linuxlike;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Objects;

public class Cd implements CommandExecutor {

    private final LinuxLike plugin;

    public Cd(LinuxLike plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            if (strings.length != 1) return false;

            if(!player.hasPermission("LinuxLike.cd")) {
                player.sendMessage(LinuxLike.NAME + "You don't have the Permission to do that!");
                return true;
            }

            File locFile = new File(plugin.getDataFolder(), "directories.yml");
            YamlConfiguration yc = YamlConfiguration.loadConfiguration(locFile);

            if (yc.getString(strings[0]) == null) {
                player.sendMessage(LinuxLike.NAME + "Directory not found!");
                return true;
            }

            Location location = new Location(
                    Bukkit.getWorld(Objects.requireNonNull(yc.getString(strings[0] + ".world"))),
                    yc.getDouble(strings[0] + ".x"),
                    yc.getDouble(strings[0] + ".y"),
                    yc.getDouble(strings[0] + ".z")
            );
            location.setPitch((float) yc.getDouble(".pitch"));
            location.setYaw((float) yc.getDouble(".yaw"));
            player.teleport(location);
            player.sendMessage(LinuxLike.NAME + "Changed to: " + strings[0]);

        }
        else commandSender.sendMessage(LinuxLike.NAME + "You must be a player to execute this command!");

        return true;
    }
}
