package com.mcnsa.mcnsatools.chat;

import com.mcnsa.mcnsatools.McnsaTools;
import com.mcnsa.mcnsatools.util.StringUtil;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.SERVER)
public class ChatListener {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onChat(ServerChatEvent event) {
        //TODO: Rank
        String chatMessage = StringUtil.formatChat("G", "rank", event.getUsername(), event.getMessage());
        chatMessage = StringUtil.colour(chatMessage);
        event.setComponent(new TextComponentTranslation(chatMessage));

    }
}
