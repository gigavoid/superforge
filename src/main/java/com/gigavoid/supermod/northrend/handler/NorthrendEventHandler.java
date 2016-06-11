package com.gigavoid.supermod.northrend.handler;

import com.gigavoid.supermod.northrend.ModuleNorthrend;
import com.gigavoid.supermod.northrend.item.ItemNorthArmorPadded;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NorthrendEventHandler {

    int tickNum = 0;

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent e) {
        if (e.phase == TickEvent.Phase.START) {
            tickNum++;
        }
    }

    @SubscribeEvent
    public void livingUpdateEvent(PlayerEvent.LivingUpdateEvent e) {
        if (tickNum % 200 == 0 && e.entity instanceof EntityPlayer && e.entity.dimension == ModuleNorthrend.dimensionId) {
            ItemStack[] armor = {((EntityPlayer) e.entity).getCurrentArmor(0), ((EntityPlayer) e.entity).getCurrentArmor(1), ((EntityPlayer) e.entity).getCurrentArmor(2), ((EntityPlayer) e.entity).getCurrentArmor(3)};
            for(int i = 0; i < armor.length; i++){
                if (armor[i] == null){
                    e.entity.attackEntityFrom(ModuleNorthrend.freeze, 2f);
                }
                else if(!(armor[i].getItem() instanceof ItemNorthArmorPadded)){
                    e.entity.attackEntityFrom(ModuleNorthrend.freeze, 2f);
                }
            }
        }
    }
}
