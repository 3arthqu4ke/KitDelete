package me.earth.kitdelete;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = KitDeleteMod.MODID, name = KitDeleteMod.MODNAME, version = KitDeleteMod.MODVER)
public class KitDeleteMod {

    public static final String MODID = "kitdelete";
    public static final String MODNAME = "KitDelete";
    public static final String MODVER = "b1";

	public static KeyBinding keyBind;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        keyBind = new KeyBinding("DeleteKit", Keyboard.KEY_RETURN, "KitDelete");
        ClientRegistry.registerKeyBinding(keyBind);
        MinecraftForge.EVENT_BUS.register(new KitDelete());
    }
}
