package mod.darkness.items;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderPlayerEvent;

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

    @SubscribeEvent
    public void onPlayerRenderPre(RenderPlayerEvent.Pre event) {
        EntityPlayer player = event.entityPlayer;
        if (player.getCurrentArmor(2) != null) {
            ItemStack armor = player.getCurrentArmor(2);
            if (ItemCloak.isCloak(armor)) {
                event.setCanceled(true);
            }
        }
    }
}
