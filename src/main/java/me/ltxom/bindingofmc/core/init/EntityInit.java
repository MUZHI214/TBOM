package me.ltxom.bindingofmc.core.init;

import me.ltxom.bindingofmc.TBOMMain;
import me.ltxom.bindingofmc.common.entity.bluespider.BlueSpiderEntity;
import me.ltxom.bindingofmc.common.entity.mother.MotherEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {
    public static EntityType<MotherEntity> MOTHER;
    public static EntityType<BlueSpiderEntity> BLUE_SPIDER;

    public static void register() {
        MOTHER = register("mother",
                EntityType.Builder.create(MotherEntity::new,
                        EntityClassification.MONSTER)
                        .size(1.3f, 2.4f).trackingRange(8));

        BLUE_SPIDER = register("blue_spider",
                EntityType.Builder.create(BlueSpiderEntity::new,
                        EntityClassification.MONSTER)
                        .size(1.1f, 0.6f).trackingRange(8));

        ForgeRegistries.ENTITIES.registerAll(MOTHER, BLUE_SPIDER);
    }

    private static <T extends Entity> EntityType<T> register(String name,
                                                             EntityType.Builder<T> builder) {
        ResourceLocation regName = new ResourceLocation(TBOMMain.MODID, name);
        return (EntityType<T>) builder.build(name).setRegistryName(regName);
    }


    public static void initializeAttributes() {
        GlobalEntityTypeAttributes.put(MOTHER, MotherEntity.createAttributes().create());
        GlobalEntityTypeAttributes.put(BLUE_SPIDER, BlueSpiderEntity.createAttributes().create());
    }

}
