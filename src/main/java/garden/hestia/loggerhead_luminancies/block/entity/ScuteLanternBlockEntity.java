package garden.hestia.loggerhead_luminancies.block.entity;

import garden.hestia.loggerhead_luminancies.LoggerheadLuminancies;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ScuteLanternBlockEntity extends BlockEntity {
    public long timeAlive = 0;

    public static <T extends BlockEntity> void clientTick(World world, BlockPos pos, BlockState blockState, T blockEntity) {
        if (blockEntity instanceof ScuteLanternBlockEntity self) {
            self.timeAlive++;
        }
    }

    public ScuteLanternBlockEntity(BlockPos pos, BlockState state) {
        super(LoggerheadLuminancies.SCUTE_LANTERN_BLOCK_ENTITY_TYPE, pos, state);
    }
}
