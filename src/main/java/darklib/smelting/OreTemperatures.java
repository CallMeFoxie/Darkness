package darklib.smelting;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;

public class OreTemperatures {
    public static final int TEMP_UNKNOWN   = 600;
    public static final int TEMP_FOOD      = 150;
    public static final int TEMP_ALUMINIUM = 660;
    public static final int TEMP_COPPER    = 1085;
    public static final int TEMP_TIN       = 232;
    public static final int TEMP_IRON      = 1538;
    public static final int TEMP_GOLD      = 1064;
    public static final int TEMP_BRONZE    = 950;
    public static final int TEMP_ALUBRASS  = 670;
    public static final int TEMP_LEAD      = 327;
    public static final int TEMP_SILVER    = 962;

    private static HashMap<String, Integer> oreEntries;

    static {
        oreEntries = new HashMap<String, Integer>();
        oreEntries.put("aluminium", TEMP_ALUMINIUM);
        oreEntries.put("aluminum", TEMP_ALUMINIUM); // thanks Obama
        oreEntries.put("copper", TEMP_COPPER);
        oreEntries.put("tin", TEMP_TIN);
        oreEntries.put("bronze", TEMP_BRONZE);
        oreEntries.put("iron", TEMP_IRON);
        oreEntries.put("gold", TEMP_GOLD);
        oreEntries.put("aluminiumBrass", TEMP_ALUBRASS);
        oreEntries.put("aluminumBrass", TEMP_ALUBRASS); // thanks again, Obama
        oreEntries.put("lead", TEMP_LEAD);
        oreEntries.put("silver", TEMP_SILVER);
    }

    public static int getSmeltingTemperature(ItemStack itemStack) {
        if (itemStack.getItem() instanceof ItemFood) {
            return TEMP_FOOD;
        }

        int[] ores = OreDictionary.getOreIDs(itemStack);
        for (int ore : ores) {
            String name = OreDictionary.getOreName(ore);
            Integer temp = oreEntries.get(name);
            if (temp != null) {
                return temp;
            }
        }

        return TEMP_UNKNOWN;
    }
}
