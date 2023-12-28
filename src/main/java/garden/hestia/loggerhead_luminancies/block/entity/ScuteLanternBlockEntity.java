package garden.hestia.loggerhead_luminancies.block.entity;

import garden.hestia.loggerhead_luminancies.LoggerheadLuminancies;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class ScuteLanternBlockEntity extends BlockEntity {

    public ScuteLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(LoggerheadLuminancies.SCUTE_LANTERN_BLOCK_ENTITY_TYPE, blockPos, blockState);
    }
}
