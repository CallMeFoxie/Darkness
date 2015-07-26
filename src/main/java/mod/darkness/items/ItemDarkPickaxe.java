package mod.darkness.items;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.world.BlockEvent;

import java.util.Map;

public class ItemDarkPickaxe extends ItemPickaxe {

    protected ItemDarkPickaxe() {
        super(ToolMaterial.EMERALD);
        setUnlocalizedName("darkPickaxe");
        setTextureName("darkPickaxe");
    }

    @SuppressWarnings("unchecked")
    public static void updateFortuneModifier(EntityPlayer player, ItemStack stack) {
        if (stack == null || player == null)
            return;

        int x = (int) player.posX;
        int y = (int) player.posY;
        int z = (int) player.posZ;
        int lightLevel = player.worldObj.getBlockLightValue(x, y, z);

        if (stack.stackTagCompound == null)
            stack.stackTagCompound = new NBTTagCompound();

        int fortuneExtra = stack.getTagCompound().getInteger("fortuneInfused");
        int fortuneBase = stack.getTagCompound().getInteger("fortuneBase");

        Map<Integer, Integer> currentEnchants = EnchantmentHelper.getEnchantments(stack);

        if (lightLevel <= 4) { // 4 to enable during the night, 0 to enable only when mining in absolute darkness
            currentEnchants.put(Enchantment.fortune.effectId, fortuneBase + fortuneExtra);
        } else {
            if (fortuneBase != 0)
                currentEnchants.put(Enchantment.fortune.effectId, fortuneBase);
            else
                currentEnchants.remove(Enchantment.fortune.effectId);
        }

        EnchantmentHelper.setEnchantments(currentEnchants, stack);
    }


    @SubscribeEvent
    public void onBlockBreakEvent(BlockEvent.BreakEvent event) {
        if (event.getPlayer().getHeldItem() != null && event.getPlayer().getHeldItem().getItem() instanceof ItemDarkPickaxe) {
            ItemDarkPickaxe.updateFortuneModifier(event.getPlayer(), event.getPlayer().getHeldItem());
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (!event.player.worldObj.isRemote && event.phase == TickEvent.Phase.START && event.player.worldObj.getTotalWorldTime() % 10 == 0) {
            if (event.player.getHeldItem() != null && event.player.getHeldItem().getItem() instanceof ItemDarkPickaxe) {
                ItemDarkPickaxe.updateFortuneModifier(event.player, event.player.getHeldItem());
            }
        }
    }
}
