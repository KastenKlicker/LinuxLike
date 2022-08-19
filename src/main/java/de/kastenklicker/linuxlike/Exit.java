package de.kastenklicker.linuxlike;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Exit implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player player) player.kick(Component.text("Hope to see you soon!"));
        else commandSender.sendMessage(LinuxLike.NAME + "You must be a player to execute this command!");

        return true;
    }
}
