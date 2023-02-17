package com.uraneptus.glowworms.common.blocks;

import com.uraneptus.glowworms.core.registry.GlowwormsBlocks;
import com.uraneptus.glowworms.core.registry.GlowwormsItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class Glowworms extends GrowingPlantHeadBlock implements BonemealableBlock {
    public static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public Glowworms(Properties pProperties) {
        super(pProperties.lightLevel((lightEmission) -> 8), Direction.DOWN, SHAPE, false, 0.1D);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        BlockState blockBelow = pLevel.getBlockState(pPos.below());
        if (blockBelow.isAir()) {
            if (pRandom.nextInt(5) == 0) {
                double d0 = pPos.getX() + pRandom.nextDouble();
                double d1 = ((float)(pPos.getY() + 1) - 0.6875F);
                double d2 = pPos.getZ() + pRandom.nextDouble();
                pLevel.addParticle(ParticleTypes.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource pRandom) {
        return 1;
    }

    @Override
    protected boolean canGrowInto(BlockState pState) {
        return pState.isAir();
    }

    @Override
    protected Block getBodyBlock() {
        return GlowwormsBlocks.GLOWWORMS_PLANT.get();
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return new ItemStack(GlowwormsItems.GLOWWORMS.get());
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }
}
