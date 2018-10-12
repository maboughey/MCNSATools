package com.mcnsa.mcnsatools.chat;

import com.mcnsa.mcnsatools.McnsaTools;
import com.mcnsa.mcnsatools.util.StringUtil;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentTranslation;

public class ChatHandler {


    public static void privateMessage(EntityPlayerMP toPlayer, ICommandSender fromPlayer, String message) {

        //Build the message
        //TODO: rank
        String privateMessage = StringUtil.formatMessage("&c", fromPlayer.getName(), message);
        privateMessage = StringUtil.colour(privateMessage);

        TextComponentTranslation finishedMessage = new TextComponentTranslation(privateMessage);

        //Send the message
        toPlayer.sendMessage(finishedMessage);
        fromPlayer.sendMessage(finishedMessage);

        //Send to console
        McnsaTools.logger.info("[PRIVATE_MSG]"+privateMessage);

    }
}
