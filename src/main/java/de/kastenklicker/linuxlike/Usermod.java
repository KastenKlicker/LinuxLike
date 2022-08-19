package de.kastenklicker.linuxlike;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Usermod implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (strings.length == 3 && strings[0].equals("-aG") && (strings[1].equals("sudo") || strings[1].equals("wheel"))) {

            Bukkit.dispatchCommand(commandSender, "op " + strings[2]);
            return true;
        }
        return false;
    }
}
