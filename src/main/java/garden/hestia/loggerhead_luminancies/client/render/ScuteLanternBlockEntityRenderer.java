package garden.hestia.loggerhead_luminancies.client.render;

import garden.hestia.loggerhead_luminancies.LoggerheadLuminancies;
import garden.hestia.loggerhead_luminancies.block.entity.ScuteLanternBlockEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;

public class ScuteLanternBlockEntityRenderer implements BlockEntityRenderer<ScuteLanternBlockEntity> {
    public static final EntityModelLayer SCUTE_LANTERN_MODEL_LAYER = new EntityModelLayer(LoggerheadLuminancies.id("scute_lantern"), "main");
    public static final SpriteIdentifier SCUTE_LANTERN_TEXTURE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, LoggerheadLuminancies.id("block/scute_lantern"));

    private final ModelPart root;

    public ScuteLanternBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        this.root = context.getLayerModelPart(SCUTE_LANTERN_MODEL_LAYER);
    }
    @Override
    public void render(ScuteLanternBlockEntity blockEntity, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, int overlay) {
        long time = blockEntity.getWorld().getTime();
        double tick = time + tickDelta;
        double yOffset = Math.sin(tick/10.0F)/5.0F - 0.4F;
        matrixStack.translate(0, yOffset, 0);
        this.root.render(matrixStack, SCUTE_LANTERN_TEXTURE.getVertexConsumer(vertexConsumerProvider, RenderLayer::getEntitySolid), light, overlay);
    }

    public static TexturedModelData getTextureModelData() {
        ModelData data = new ModelData();
        data.getRoot().addChild("main", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F), ModelTransform.NONE);
        return TexturedModelData.of(data, 64, 64);
    }
}
