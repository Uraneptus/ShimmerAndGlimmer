package com.uraneptus.glowworms.common.blocks;

import com.uraneptus.glowworms.core.other.tags.GlowwormsBlockTags;
import com.uraneptus.glowworms.core.registry.GlowwormsBlocks;
import com.uraneptus.glowworms.core.registry.GlowwormsItems;
import com.uraneptus.glowworms.core.registry.GlowwormsParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

//TODO this can probably be improved a bit, especially for the bonemeal part
public class GlowwormsBlock extends Block implements BonemealableBlock {
    public static final EnumProperty<GlowwormState> GLOWWORM_STATE = EnumProperty.create("glowworm_state", GlowwormState.class);
    public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
    public static final VoxelShape BASE_MIDDLE_SHAPE = Block.box(1.8D, 0.0D, 1.8D, 14.2D, 16.0D, 14.2D);
    public static final VoxelShape END_SHAPE = Block.box(1.8D, 6.0D, 1.8D, 14.2D, 16.0D, 14.2D);

    public GlowwormsBlock(Properties pProperties) {
        super(pProperties.lightLevel((lightEmission) -> 10));
        this.registerDefaultState(this.stateDefinition.any().setValue(GLOWWORM_STATE, GlowwormState.END).setValue(AGE, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(GLOWWORM_STATE).add(AGE);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockState blockAbove = pLevel.getBlockState(pPos.above());
        return blockAbove.is(GlowwormsBlockTags.GLOWWORMS_PLACEABLE) || blockAbove.is(GlowwormsBlockTags.GLOWWORMS);
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        BlockState blockAbove = pLevel.getBlockState(pCurrentPos.above());
        BlockState blockBelow = pLevel.getBlockState(pCurrentPos.below());
        if  (!this.canSurvive(pState, pLevel, pCurrentPos)) {
            pLevel.scheduleTick(pCurrentPos, this, 2);
        } else if (!blockBelow.is(GlowwormsBlockTags.GLOWWORMS)) {
            return pState.setValue(GLOWWORM_STATE, GlowwormState.END);
        } else if (blockAbove.is(GlowwormsBlockTags.GLOWWORMS_PLACEABLE)) {
            return pState.setValue(GLOWWORM_STATE, GlowwormState.BASE);
        } else {
            return pState.setValue(GLOWWORM_STATE, GlowwormState.MIDDLE);
        }
        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        GlowwormState glowwormState = pState.getValue(GLOWWORM_STATE);
        VoxelShape voxelshape;
        if (glowwormState == GlowwormState.BASE || glowwormState == GlowwormState.MIDDLE) {
            voxelshape = BASE_MIDDLE_SHAPE;
        } else {
            voxelshape = END_SHAPE;
        }
        return voxelshape;
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        BlockState blockBelow = pLevel.getBlockState(pPos.below());
        if (blockBelow.isAir() && pState.getValue(GLOWWORM_STATE) == GlowwormState.END) {
            if (pRandom.nextInt(5) == 0) {
                double d0 = pPos.getX() + pRandom.nextDouble();
                double d1 = ((float)(pPos.getY() + 1) - 0.6875F);
                double d2 = pPos.getZ() + pRandom.nextDouble();
                pLevel.addParticle(GlowwormsParticleTypes.HANGING_GLOW_GOO.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!this.canSurvive(pState, pLevel, pPos)) {
            pLevel.destroyBlock(pPos, true);
        }
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        BlockPos blockpos = pPos.relative(Direction.DOWN);
        BlockState blockstate = this.defaultBlockState().setValue(AGE, 0).setValue(GLOWWORM_STATE, GlowwormState.END);
        if (!this.isMaxAge(pState) && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(pLevel, blockpos, pLevel.getBlockState(blockpos),pRandom.nextDouble() < 0.1D)) {
            if (pLevel.getBlockState(blockpos).isAir()) {
                pLevel.setBlockAndUpdate(blockpos, blockstate);
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(pLevel, blockpos, pLevel.getBlockState(blockpos));
            }
        }
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        pEntity.makeStuckInBlock(pState, new Vec3(0.85D, 0.95F, 0.85D));
    }

    @Override
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return new ItemStack(GlowwormsItems.GLOWWORMS.get());
    }

    public int getMaxAge() {
        return 15;
    }

    protected int getAge(BlockState state) {
        return state.getValue(AGE);
    }

    public BlockState getStateForAge(int age) {
        return this.defaultBlockState().setValue(AGE, age);
    }

    public boolean isMaxAge(BlockState state) {
        return state.getValue(AGE) >= this.getMaxAge();
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !this.isMaxAge(state);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return pLevel.getBlockState(pPos.relative(Direction.DOWN)).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        BlockPos blockpos = pPos.relative(Direction.DOWN);
        int i = Math.min(pState.getValue(AGE) + Mth.nextInt(pRandom, 0, 2), 15);

        for(int k = 0; k < 1; ++k) {
            pLevel.setBlockAndUpdate(blockpos, this.defaultBlockState().setValue(AGE, i));
            blockpos = blockpos.relative(Direction.DOWN);
            i = Math.min(i + 1, 15);
        }
    }

    public enum GlowwormState implements StringRepresentable {
        BASE("base"),
        MIDDLE("middle"),
        END("end");

        private final String name;

        GlowwormState(String pName) {
            this.name = pName;
        }

        public String toString() {
            return this.name;
        }

        public String getSerializedName() {
            return this.name;
        }
    }
}