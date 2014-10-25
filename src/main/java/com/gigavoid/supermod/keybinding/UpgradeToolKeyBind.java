package com.gigavoid.supermod.keybinding;

import com.gigavoid.supermod.SuperMod;
import com.gigavoid.supermod.gui.UpgradeToolGui;
import com.gigavoid.supermod.item.ProgressivePickaxeItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.item.ItemStack;
import org.lwjgl.input.Keyboard;

/**
 * Created by ineentho on 2014-10-25.
 */
public class UpgradeToolKeyBind extends SuperKeyBinding {
    public UpgradeToolKeyBind() {
        super("Upgrade Tool", Keyboard.KEY_P, "Super Mod");
    }

    @Override
    public void Pressed() {
        EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
        ItemStack currentItem = player.inventory.getCurrentItem();
        if (currentItem != null && currentItem.getItem() instanceof ProgressivePickaxeItem) {
            ProgressivePickaxeItem pickaxe = (ProgressivePickaxeItem) currentItem.getItem();
            player.openGui(SuperMod.instance, 20, player.getEntityWorld(), player.serverPosX, player.serverPosY, player.serverPosZ);
        }
    }
}
