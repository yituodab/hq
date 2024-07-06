package com.eihei.hq.utils;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public class Keybinding {
    public static final String KEY_CATEGORY_HQ = "key.categor.hq";
    public static final String KEY_X_STRING = "key.hq.x";

    public static final KeyMapping HQ_KEY_MAPPING = new KeyMapping(KEY_X_STRING, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_X, KEY_CATEGORY_HQ);

}
