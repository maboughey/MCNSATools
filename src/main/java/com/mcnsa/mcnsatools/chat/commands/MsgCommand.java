package com.mcnsa.mcnsatools.chat.commands;

import com.mcnsa.mcnsatools.chat.ChatHandler;
import com.mcnsa.mcnsatools.util.Player;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class MsgCommand implements ICommand {
    @Override
    public String getName() {
        return "msg";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/msg [player] [message]";
    }

    @Override
    public List<String> getAliases() {
        List<String> aliases = new ArrayList<String>();
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        //Check for correct usage
        if (args.length < 2) {
            sender.sendMessage(new TextComponentTranslation(TextFormatting.RED+"Usage: /msg [player] [message]"));
            return;
        }

        //Try and get the player
        EntityPlayerMP player = Player.getByUsername(args[0]);
        if (player == null) {
            sender.sendMessage(new TextComponentTranslation(TextFormatting.RED+"Could not find player \""+args[0]+"\""));
            return;
        }

        //Build the message
        StringBuilder messageSB= new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            messageSB.append(args[i]);
            if (i < args.length)
                messageSB.append(" ");
        }
        String message = messageSB.toString();

        ChatHandler.privateMessage(player, sender, message);
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        //TODO: Permission
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        //TODO: Return list of online players
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
