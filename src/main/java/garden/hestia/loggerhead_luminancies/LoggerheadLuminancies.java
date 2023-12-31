package garden.hestia.loggerhead_luminancies;

import garden.hestia.loggerhead_luminancies.block.ScuteLanternBlock;
import garden.hestia.loggerhead_luminancies.block.entity.ScuteLanternBlockEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.PlaceableOnWaterItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class LoggerheadLuminancies implements ModInitializer {
    private static final String ID = "loggerhead_luminancies";

    public static final Block SCUTE_LANTERN = Registry.register(Registries.BLOCK, LoggerheadLuminancies.id("scute_lantern"), new ScuteLanternBlock(FabricBlockSettings.copyOf(Blocks.SEA_LANTERN).nonOpaque().noCollision()));
    public static final BlockEntityType<ScuteLanternBlockEntity> SCUTE_LANTERN_BLOCK_ENTITY_TYPE = Registry.register(Registries.BLOCK_ENTITY_TYPE, LoggerheadLuminancies.id("scute_lantern"), BlockEntityType.Builder.create(ScuteLanternBlockEntity::new, SCUTE_LANTERN).build(Util.getChoiceType(TypeReferences.BLOCK_ENTITY, "scute_lantern")));
    public static final BlockItem SCUTE_LANTERN_ITEM = Registry.register(Registries.ITEM, LoggerheadLuminancies.id("scute_lantern"), new PlaceableOnWaterItem(SCUTE_LANTERN, new FabricItemSettings()));
    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addBefore(Items.SEA_LANTERN, SCUTE_LANTERN_ITEM);
        });
    }

    public static Identifier id(String path)
    {
        return new Identifier(ID, path);
    }
}
