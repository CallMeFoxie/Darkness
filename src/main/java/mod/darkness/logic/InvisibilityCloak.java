package mod.darkness.logic;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mod.darkness.items.ItemCloak;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderPlayerEvent;

public class InvisibilityCloak {
    public static InvisibilityCloak INSTANCE;

    public InvisibilityCloak() {
        INSTANCE = this;
    }

    /*
        @SubscribeEvent
        public void onPlayerTickPre(TickEvent.PlayerTickEvent event) {
            if (event.phase != TickEvent.Phase.START)
                return;

            EntityPlayer player = event.player;
            if (player.getCurrentArmor(2) != null) {
                ItemStack armor = player.getCurrentArmor(2);
                if (ItemCloak.isCloak(armor)) {
                    player.addPotionEffect(new PotionEffect(Potion.invisibility.getId(), 10));
                }
            }
        }
    */
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
