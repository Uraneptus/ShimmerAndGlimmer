package com.uraneptus.shimmerandglimmer.core.events;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import com.uraneptus.shimmerandglimmer.common.items.BioluminescentDyeItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ShimmerAndGlimmer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SAGPlayerEvents {

    @SubscribeEvent
    public static void onRightClickEntity(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        InteractionHand hand = event.getHand();
        Block block = level.getBlockState(pos).getBlock();
        BlockEntity blockentity = level.getBlockEntity(pos);
        Item item = player.getItemInHand(hand).getItem();

        if (block instanceof SignBlock) {
            if (blockentity instanceof SignBlockEntity signBlockEntity) {
                if (item instanceof BioluminescentDyeItem) {
                    signBlockEntity.setHasGlowingText(true);
                }
            }
        }
    }
}
