package com.presidentnick.aut.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.presidentnick.aut.blocks.TileSinterer;
import com.presidentnick.aut.client.container.ContainerSinterer;
import com.presidentnick.aut.lib.ModInfo;

public class GUISinterer extends GuiContainer {

	public static final ResourceLocation texture = new ResourceLocation(ModInfo.ID.toLowerCase(), "textures/gui/testgui.png");
	
	public GUISinterer(InventoryPlayer invPlayer, TileSinterer entity) {
		super(new ContainerSinterer(invPlayer, entity));
		
		xSize = 176;
		ySize = 165;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		this.mc.getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}
