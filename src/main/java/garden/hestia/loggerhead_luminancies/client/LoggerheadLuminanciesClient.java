package garden.hestia.loggerhead_luminancies.client;

import garden.hestia.loggerhead_luminancies.LoggerheadLuminancies;
import garden.hestia.loggerhead_luminancies.client.render.ScuteLanternBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class LoggerheadLuminanciesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ScuteLanternBlockEntityRenderer.SCUTE_LANTERN_MODEL_LAYER, ScuteLanternBlockEntityRenderer::getTextureModelData);

        BlockEntityRendererFactories.register(LoggerheadLuminancies.SCUTE_LANTERN_BLOCK_ENTITY_TYPE, ScuteLanternBlockEntityRenderer::new);

    }
}
