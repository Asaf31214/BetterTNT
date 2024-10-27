package org.siverek.bettertnt.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.siverek.bettertnt.Bettertnt;

public class ModItems {
    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(Bettertnt.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }
    public static final Item ENHANCED_GUNPOWDER = register(
            new Item(new Item.Settings()),
            "enhanced_gunpowder"
    );
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.ENHANCED_GUNPOWDER));
    }
}