package mod.darkness.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemCloak extends ItemArmor {
    public ItemCloak() {
        super(ArmorMaterial.CLOTH, 0, 1);
        setUnlocalizedName("cloak");
        setTextureName("cloak");
        setCreativeTab(CreativeTabs.tabCombat);
    }

    public static boolean isCloak(ItemStack armor) {
        return armor != null && armor.getItem() != null && armor.getItem() == ItemManager.itemCloak;

    }
}
