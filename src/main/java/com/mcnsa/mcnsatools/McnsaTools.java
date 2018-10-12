package com.mcnsa.mcnsatools;


import com.mcnsa.mcnsatools.chat.ChatHandler;
import com.mcnsa.mcnsatools.chat.commands.MsgCommand;
import com.mcnsa.mcnsatools.util.Config;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.Logger;

@Mod(modid = McnsaTools.MODID, name = McnsaTools.NAME, version = McnsaTools.VERSION, acceptableRemoteVersions = "*")
public class McnsaTools {

    static final String MODID = "mcnsatools";
    static final String NAME = "MCNSA Tools";
    static final String VERSION = "0.1";

    public static Logger logger;
    static ChatHandler chatHandler;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        //Setup the logger
        logger = event.getModLog();

        //Load config file
        Config.init(event.getSuggestedConfigurationFile());

        //Default check
        if (Config.isDefault)
            logger.error("Default settings are loaded. Please edit configuration file at: "+event.getSuggestedConfigurationFile().toString());



    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {

        //register chat commands
        event.registerServerCommand(new MsgCommand());
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
