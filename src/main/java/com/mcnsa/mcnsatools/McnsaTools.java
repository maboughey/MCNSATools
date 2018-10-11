package com.mcnsa.mcnsatools;


import com.mcnsa.mcnsatools.chat.ChatHandler;
import com.mcnsa.mcnsatools.util.Config;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.Logger;

@Mod(modid = McnsaTools.MODID, name = McnsaTools.NAME, version = McnsaTools.VERSION, acceptableRemoteVersions = "*")
public class McnsaTools {

    public static final String MODID = "mcnsatools";
    public static final String NAME = "MCNSA Tools";
    public static final String VERSION = "0.1";

    public static Logger logger;
    public static ChatHandler chatHandler;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        //Setup the logger
        logger = event.getModLog();

        //Load config file
        Config.init(event.getSuggestedConfigurationFile());

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Loading "+McnsaTools.NAME + " " + McnsaTools.VERSION);

        //Start Chat handler
        chatHandler = new ChatHandler();


    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @EventHandler
    public void stop(FMLServerStoppingEvent event) {

    }

}
