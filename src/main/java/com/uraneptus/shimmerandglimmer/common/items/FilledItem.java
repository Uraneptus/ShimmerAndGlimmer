package com.uraneptus.shimmerandglimmer.common.items;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilledItem extends Item {
    private final Item itemToFollow;
    private static final Map<Item, List<Item>> itemIndexes = new HashMap<>();

    public FilledItem(Item itemToFollow, Properties pProperties) {
        super(pProperties);
        this.itemToFollow = itemToFollow;
        if (!itemIndexes.containsKey(itemToFollow)) {
            itemIndexes.put(itemToFollow, new ArrayList<>());
        }
        itemIndexes.get(itemToFollow).add(this);
    }

    @Override
    public void fillItemCategory(CreativeModeTab pCategory, NonNullList<ItemStack> pItems) {
        if (this.allowedIn(pCategory)) {
            List<Item> tabItems = pItems.stream().map(ItemStack::getItem).toList();

            if (tabItems.contains(this.itemToFollow)) {
                pItems.add(tabItems.indexOf(this.itemToFollow) + 1 + itemIndexes.get(itemToFollow).indexOf(this), new ItemStack(this));
            }
        }
    }
}
