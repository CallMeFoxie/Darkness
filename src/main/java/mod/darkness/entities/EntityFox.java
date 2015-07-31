package mod.darkness.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class EntityFox extends EntityAnimal {
    public EntityFox(World world) {
        super(world);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable entity) {
        return null;
    }
}
