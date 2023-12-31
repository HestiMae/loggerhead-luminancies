package garden.hestia.loggerhead_luminancies.block;

import com.mojang.serialization.MapCodec;
import garden.hestia.loggerhead_luminancies.block.entity.ScuteLanternBlockEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class ScuteLanternBlock extends BlockWithEntity {
    public static final MapCodec<ScuteLanternBlock> CODEC = createCodec(ScuteLanternBlock::new);

    public ScuteLanternBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public BlockRenderType getRenderType(BlockState blockState) {
        return BlockRenderType.INVISIBLE;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ScuteLanternBlockEntity(blockPos, blockState);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState blockState, BlockView blockView, BlockPos blockPos, ShapeContext shapeContext) {
        return VoxelShapes.cuboid(0, -0.2, 0, 1, 0.4, 1);
    }

    @Override
    public boolean canPlaceAt(BlockState blockState, WorldView worldView, BlockPos blockPos) {
        BlockPos below = blockPos.down();
        return worldView.getFluidState(blockPos).getFluid() == Fluids.EMPTY && worldView.getFluidState(below).getFluid() == Fluids.WATER;
    }
}
