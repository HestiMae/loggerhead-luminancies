package garden.hestia.loggerhead_luminancies.block;

import com.mojang.serialization.MapCodec;
import garden.hestia.loggerhead_luminancies.block.entity.ScuteLanternBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ScuteLanternBlock extends BlockWithEntity {
    public static final MapCodec<ScuteLanternBlock> CODEC = createCodec(ScuteLanternBlock::new);

    public ScuteLanternBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return world.isClient() ? ScuteLanternBlockEntity::clientTick : null;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
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
}
