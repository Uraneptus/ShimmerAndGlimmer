package com.uraneptus.shimmerandglimmer.common.items;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.MaterialColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BioluminescentDyeItem extends FilledItem {

    private final int dyeColor;
    private static MaterialColor materialColor;
    private final float[] textureDiffuseColors;

    public BioluminescentDyeItem(Item.Properties pProperties) {
        super(Items.BLACK_DYE, pProperties);
        this.dyeColor = 5308359;
        materialColor = MaterialColor.COLOR_CYAN;
        int i = (dyeColor & 16711680) >> 16;
        int j = (dyeColor & '\uff00') >> 8;
        int k = (dyeColor & 255);
        this.textureDiffuseColors = new float[]{(float)i / 255.0F, (float)j / 255.0F, (float)k / 255.0F};
    }

    //TODO This has later to be done using a custom sheep entity or using mixins
    /*
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pTarget, InteractionHand pHand) {
        if (pTarget instanceof Sheep sheep) {
            if (sheep.isAlive() && !sheep.isSheared() && sheep.getColor() != this.dyeColor) {
                sheep.level.playSound(pPlayer, sheep, SoundEvents.DYE_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
                if (!pPlayer.level.isClientSide) {
                    sheep.setColor(this.dyeColor);
                    pStack.shrink(1);
                }

                return InteractionResult.sidedSuccess(pPlayer.level.isClientSide);
            }
        }

        return InteractionResult.PASS;
    }

     */

    public int getDyeColor() {
        return this.dyeColor;
    }

    public static MaterialColor getMaterialColor() {
        return materialColor;
    }

    public float[] getTextureDiffuseColors() {
        return this.textureDiffuseColors;
    }
}