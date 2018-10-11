package com.mcnsa.mcnsatools.util;

import net.minecraft.util.text.TextFormatting;

public class StringUtil {

    public static String colour(String message) {
        message = message.replaceAll("&0", TextFormatting.BLACK.toString());
        message = message.replaceAll("&1", TextFormatting.DARK_BLUE.toString());
        message = message.replaceAll("&2", TextFormatting.DARK_GREEN.toString());
        message = message.replaceAll("&3", TextFormatting.DARK_AQUA.toString());
        message = message.replaceAll("&4", TextFormatting.DARK_RED.toString());
        message = message.replaceAll("&5", TextFormatting.DARK_PURPLE.toString());
        message = message.replaceAll("&6", TextFormatting.GOLD.toString());
        message = message.replaceAll("&7", TextFormatting.GRAY.toString());
        message = message.replaceAll("&8", TextFormatting.DARK_GRAY.toString());
        message = message.replaceAll("&9", TextFormatting.BLUE.toString());
        message = message.replaceAll("&a", TextFormatting.GREEN.toString());
        message = message.replaceAll("&b", TextFormatting.AQUA.toString());
        message = message.replaceAll("&c", TextFormatting.RED.toString());
        message = message.replaceAll("&d", TextFormatting.LIGHT_PURPLE.toString());
        message = message.replaceAll("&e", TextFormatting.YELLOW.toString());
        message = message.replaceAll("&f", TextFormatting.WHITE.toString());
        message = message.replaceAll("&r", TextFormatting.RESET.toString());
        return message;
    }

    public static String formatChat(String channel, String rank, String player, String message) {
        String chatMessage = Config.chatMessageFormat.replaceAll("%channel%", channel);
        chatMessage = chatMessage.replaceAll("%rank%", rank);
        chatMessage = chatMessage.replaceAll("%player%", player);
        chatMessage = chatMessage.replaceAll("%message%", message);

        return chatMessage;

    }

    public static String formatMessage(String rank, String player, String message){
        String chatMessage = Config.privateMessageFormat.replaceAll("%rank%", rank);
        chatMessage = chatMessage.replaceAll("%player%", player);
        chatMessage = chatMessage.replaceAll("%message%", message);

        return chatMessage;
    }
}
