package me.earth.kitdelete;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

import java.util.regex.Pattern;

public class KitDelete {

    private final Minecraft mc = Minecraft.getMinecraft();
    private boolean keyDown;

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (mc.currentScreen instanceof GuiContainer && Keyboard.isKeyDown(KitDeleteMod.keyBind.getKeyCode())) {
            Slot slot = ((GuiContainer) mc.currentScreen).getSlotUnderMouse();
            if (slot == null || keyDown) {
                return;
            }
            mc.player.sendChatMessage("/deleteukit " + removeColor(slot.getStack().getDisplayName()));
            keyDown = true;
        } else if (keyDown) {
            keyDown = false;
        }
    }

    public String removeColor(String string) {
        if(string != null) {
            return (Pattern.compile("(?i)" + String.valueOf("\u00A7") + "[0-9A-FK-OR]")).matcher(string).replaceAll("");
        }
        return "";
    }
}
