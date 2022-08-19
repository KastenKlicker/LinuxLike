package de.kastenklicker.linuxlike;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

/**
 * @author KastenKlicker
 *
 * Main class of LinuxLike
 */
public class LinuxLike extends JavaPlugin {

    public static String NAME = "§6LinuxLike §8» §7";

    @Override
    public void onEnable() {

        Logger logger = this.getLogger();
        logger.info("+ + + + + + + + + + + + + + + +");
        logger.info("+                             +");
        logger.info("+ LinuxLike by KastenKlicker  +");
        logger.info("+                             +");
        logger.info("+ + + + + + + + + + + + + + + +");

        //bstats
        int pluginId = 16189;
        Metrics metrics = new Metrics(this, pluginId);

        Objects.requireNonNull(getCommand("man")).setExecutor(new Man());
        Objects.requireNonNull(getCommand("dpkg")).setExecutor(new Dpkg());
        Objects.requireNonNull(getCommand("poweroff")).setExecutor(new Poweroff());
        Objects.requireNonNull(getCommand("adduser")).setExecutor(new Adduser());
        Objects.requireNonNull(getCommand("exit")).setExecutor(new Exit());
        Objects.requireNonNull(getCommand("deluser")).setExecutor(new Deluser());
        Objects.requireNonNull(getCommand("usermod")).setExecutor(new Usermod());
        Objects.requireNonNull(getCommand("cd")).setExecutor(new Cd(this));
        Objects.requireNonNull(getCommand("mkdir")).setExecutor(new Mkdir(this));
        Objects.requireNonNull(getCommand("ls")).setExecutor(new Ls(this));
        Objects.requireNonNull(getCommand("rm")).setExecutor(new Rm(this));
    }
}
