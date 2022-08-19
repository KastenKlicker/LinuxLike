package de.kastenklicker.linuxlike;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Dpkg implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (strings.length == 1) {
            if ((s.equals("dpkg") && strings[0].equals("-l")) || (s.equals("pacman") && strings[0].equals("-Q"))) {
                Bukkit.dispatchCommand(commandSender, "plugins");
                return true;
            }
        }
        return false;
    }
}
