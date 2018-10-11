package com.mcnsa.mcnsatools.chat;

import com.mcnsa.mcnsatools.McnsaTools;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.SERVER)
public class ChatListener {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onChat(ServerChatEvent event) {
        if (event.isCancelable()) {
            event.setCanceled(true);
        }

        String message = event.getMessage();
        String player = event.getUsername();

        McnsaTools.chatHandler.standardChat(player, message);
    }
}
