package me.yh.azimanmod;

import me.yh.azimanmod.item.aziman;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Azimanmod implements ModInitializer {

    public static String MOD_ID = "azimanmod";

    public static Item AZIMAN_ITEM = new aziman(new Item.Settings().food(new FoodComponent.Builder().hunger(5).snack().build()));
    public static Item AZIMAN_MATTYA_ITEM = new aziman(new Item.Settings().food(new FoodComponent.Builder().hunger(5).snack().build()));

    @Override
    public void onInitialize() {
        // アイテム登録
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "aziman_item"), AZIMAN_ITEM);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "aziman_mattya_item"), AZIMAN_MATTYA_ITEM);
        // タブへ追加
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((entries -> entries.add(AZIMAN_ITEM)));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((entries -> entries.add(AZIMAN_MATTYA_ITEM)));

    }
}