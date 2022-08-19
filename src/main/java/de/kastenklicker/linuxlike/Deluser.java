package de.kastenklicker.linuxlike;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Deluser implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        //Remove player from whitelist
        if (strings.length == 1)  {
            Bukkit.dispatchCommand(commandSender, "whitelist remove " + strings[0]);
            return true;
        }
        //Remove operator rights of player
        else if (strings.length == 2 && (strings[1].equals("sudo") || strings[1].equals("wheel"))) {
            Bukkit.dispatchCommand(commandSender, "deop " + strings[0]);
            return true;
        }
        return false;
    }
}
