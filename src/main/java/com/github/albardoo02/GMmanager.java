package com.github.albardoo02;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class GMmanager extends JavaPlugin {

    public static GMmanager instance;

    public GMmanager() {
        instance = this;
    }

    public static GMmanager getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        getLogger().info("GMmanager has been enabled.");

        this.saveDefaultConfig();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("gm")) {
                if (args.length == 0) {
                    for (String line : GMmanager.getInstance().getConfig().getStringList("GameMode.Help")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                    }
                }

                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("0")) {
                        if(!player.hasPermission("gm.survival"))
                        for (String line : GMmanager.getInstance().getConfig().getStringList("GameMode.Error")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                        }

                        else {
                            player.setGameMode(GameMode.SURVIVAL);
                            for (String line : GMmanager.getInstance().getConfig().getStringList("GameMode.Survival")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                            }
                        }
                    }

                    if (args[0].equalsIgnoreCase("1")) {
                        if(!player.hasPermission("gm.creative"))
                            for (String line : GMmanager.getInstance().getConfig().getStringList("GameMode.Error")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                            }

                        else {
                            player.setGameMode(GameMode.CREATIVE);
                            for (String line : GMmanager.getInstance().getConfig().getStringList("GameMode.Creative")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                            }
                        }
                    }

                    if (args[0].equalsIgnoreCase("2")) {
                        if(!player.hasPermission("gm.adventure"))
                            for (String line : GMmanager.getInstance().getConfig().getStringList("GameMode.Error")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                            }

                        else {
                            player.setGameMode(GameMode.ADVENTURE);
                            for (String line : GMmanager.getInstance().getConfig().getStringList("GameMode.Adventure")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                            }
                        }
                    }

                    if (args[0].equalsIgnoreCase("3")) {
                        if(!player.hasPermission("gm.spectator"))
                            for (String line : GMmanager.getInstance().getConfig().getStringList("GameMode.Error")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                            }

                        else {
                            player.setGameMode(GameMode.SPECTATOR);
                            for (String line : GMmanager.getInstance().getConfig().getStringList("GameMode.Spectator")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                            }
                        }
                    }

                    if (args[0].equalsIgnoreCase("reload")) {
                        if(!player.hasPermission("gm.reload"))
                            for (String line : GMmanager.getInstance().getConfig().getStringList("GameMode.Error")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                            }

                        else {
                            this.reloadConfig();
                            for (String line : GMmanager.getInstance().getConfig().getStringList("GameMode.Reload")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                            }

                        }
                    }

                    if (args[0].equalsIgnoreCase("help")) {
                        if(!player.hasPermission("gm.help"))
                            for (String line : GMmanager.getInstance().getConfig().getStringList("GameMode.Error")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                            }

                        else {
                            for (String line : GMmanager.getInstance().getConfig().getStringList("GameMode.Help")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                            }

                        }
                    }
                }
            }
        }
        return true;
    }
}