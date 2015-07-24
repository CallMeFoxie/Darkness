package darklib.smelting;

import darklib.ChancedStack;
import mod.darkness.items.ItemManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class FuelTemperature {
    public static final int TEMP_WOOD     = 593;
    public static final int TEMP_CHARCOAL = 1100;
    public static final int TEMP_DEFAULT  = 350;

    public static final float CHANCE_WOOD_ASH   = 0.3f;
    public static final float CHANCE_CHCOAL_ASH = 0.4f;

    public static final FuelEntry ENTRY_DEFAULT;
    public static final FuelEntry ENTRY_LOG;
    public static final FuelEntry ENTRY_PLANK;
    public static final FuelEntry ENTRY_CHARCOAL;

    static {
        ENTRY_CHARCOAL = new FuelEntry(TEMP_CHARCOAL,
                new ChancedStack(new ItemStack(ItemManager.itemAsh), CHANCE_CHCOAL_ASH));
        ENTRY_PLANK = new FuelEntry(TEMP_WOOD); // no ashes from logs
        ENTRY_LOG = new FuelEntry(TEMP_WOOD,
                new ChancedStack(new ItemStack(ItemManager.itemAsh), CHANCE_WOOD_ASH));
        ENTRY_DEFAULT = new FuelEntry(TEMP_DEFAULT);
    }

    public static void postinit() {

    }

    public static FuelEntry getFuelEntry(ItemStack inputStack) {
        int[] oreIDs = OreDictionary.getOreIDs(inputStack);
        for (int ore : oreIDs) {
            String oreName = OreDictionary.getOreName(ore);
            if (oreName.equals("logWood")) {
                return ENTRY_LOG;
            } else if (oreName.equals("plankWood")) {
                return ENTRY_PLANK;
            } else if (oreName.equals("charcoal")) {
                return ENTRY_CHARCOAL;
            } else if (inputStack.getItem().equals(Items.coal)) { // handle non-registered vanilla coal/charcoal
                return ENTRY_CHARCOAL;
            }
        }

        return ENTRY_DEFAULT;
    }

    public static class FuelEntry {
        public int          temperature;
        public ChancedStack outputStacks;

        public FuelEntry(int temperature, ChancedStack outputStacks) {
            this(temperature);
            this.outputStacks = outputStacks;
        }

        public FuelEntry(int temperature) {
            this.temperature = temperature;
        }
    }
}
