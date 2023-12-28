package garden.hestia.loggerhead_luminancies.block;

import com.mojang.serialization.MapCodec;
import garden.hestia.loggerhead_luminancies.block.entity.ScuteLanternBlockEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
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
}
