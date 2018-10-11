package com.mcnsa.mcnsatools.util;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static void init(File configFile) {
        Configuration config = new Configuration(configFile);

        config.load();


        config.save();
    }
}
