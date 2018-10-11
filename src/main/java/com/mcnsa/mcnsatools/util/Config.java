package com.mcnsa.mcnsatools.util;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static boolean isDefault;

    //Database stuff
    static String databaseHost;
    static String databaseName;
    static String databaseUser;
    static String databasePassword;

    //Message strings
    static String chatMessageFormat;
    static String privateMessageFormat;



    public static void init(File configFile) {
        Configuration config = new Configuration(configFile);

        config.load();
        isDefault = config.get("Default Check", "Set to false to enable mod", true).getBoolean();

        //Database
        databaseHost = config.get("Database", "Database Host", "localhost").getString();
        databaseName = config.get("Database", "Database Name", "permissions").getString();
        databaseUser = config.get("Database", "Database User", "user").getString();
        databasePassword = config.get("Database", "Database Password", "password").getString();

        //Message Formatting
        chatMessageFormat = config.get("Message Formatting", "Chat Message", "&7[%rank%&7] &f%player%: &7%message%").getString();
        privateMessageFormat = config.get("Message Formatting", "Private Message", "&7[MSG][%rank%&7] &f%player%: &7%message%").getString();

        config.save();
    }
}
