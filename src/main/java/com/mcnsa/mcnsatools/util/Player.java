package com.mcnsa.mcnsatools.util;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.Iterator;
import java.util.List;

public class Player {

    public static EntityPlayerMP getByUsername(String username) {
        List<EntityPlayerMP> playerList = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers();
        Iterator<EntityPlayerMP> playerListIt = playerList.iterator();

        while (playerListIt.hasNext()) {
            EntityPlayerMP player = playerListIt.next();
            if (player.getName().startsWith(username)) {
                return player;
            }
        }

        return null;
    }
}
