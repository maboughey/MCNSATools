package com.mcnsa.mcnsatools.permissions;

import com.mojang.authlib.GameProfile;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.IPermissionHandler;
import net.minecraftforge.server.permission.context.IContext;

import javax.annotation.Nullable;
import java.util.Collection;

public class PermissionHandler implements IPermissionHandler {
    @Override
    public void registerNode(String node, DefaultPermissionLevel level, String desc) {

    }

    @Override
    public Collection<String> getRegisteredNodes() {
        return null;
    }

    @Override
    public boolean hasPermission(GameProfile profile, String node, @Nullable IContext context) {
        return false;
    }

    @Override
    public String getNodeDescription(String node) {
        return null;
    }
}
