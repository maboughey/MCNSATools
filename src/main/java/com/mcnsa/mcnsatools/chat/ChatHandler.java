package com.mcnsa.mcnsatools.chat;

import com.mcnsa.mcnsatools.util.StringUtil;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.Iterator;
import java.util.List;

public class ChatHandler {

    public static void standardChat(String player, String message) {
        List<EntityPlayerMP> players = FMLCommonHandler.instance().getMinecraftServerInstance().getServer().getPlayerList().getPlayers();

        Iterator playerIterator = players.iterator();

        while (playerIterator.hasNext()) {
            EntityPlayerMP oplayer = (EntityPlayerMP) playerIterator.next();
            //TODO: rank
            String chatMessage = StringUtil.formatChat("G", "rank", player, message);
            chatMessage = StringUtil.colour(chatMessage);
            oplayer.sendMessage(new TextComponentTranslation(chatMessage));
        }
    }

    public static void privateMessage(EntityPlayerMP toPlayer, EntityPlayerMP fromPlayer, String message) {

        //Build the message
        //TODO: rank
        String privateMessage = StringUtil.formatMessage("rank", fromPlayer.getName(), message);
        privateMessage = StringUtil.colour(privateMessage);

        TextComponentTranslation finishedMessage = new TextComponentTranslation(privateMessage);

        //Send the message
        toPlayer.sendMessage(finishedMessage);
        fromPlayer.sendMessage(finishedMessage);

    }
}
