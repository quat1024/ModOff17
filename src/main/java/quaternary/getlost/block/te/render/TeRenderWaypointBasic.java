package quaternary.getlost.block.te.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import quaternary.getlost.block.te.TeWaypointBasic;

public class TeRenderWaypointBasic extends TileEntitySpecialRenderer<TeWaypointBasic> {
	
	ResourceLocation logSideTex = new ResourceLocation("minecraft:textures/blocks/log_oak.png");
	ResourceLocation logEndTex = new ResourceLocation("minecraft:textures/blocks/log_oak_top");
	
	//HERE WE GO BITCHES
	public void renderTileEntityAt(TeWaypointBasic te, double x, double y, double z, float pt, int destroyStage) {
		TextureManager textureManager = Minecraft.getMinecraft().renderEngine;
		Tessellator tessellator = Tessellator.getInstance();
		VertexBuffer buffer = tessellator.getBuffer();
		
		
		GlStateManager.pushMatrix();
		
		GlStateManager.translate(x+0.5, y+0.5, z+0.5);
		textureManager.bindTexture(logSideTex);
		renderBox(buffer, 0, 0, 0, 1, 1, 1, 0, 0, 16, 16);
		tessellator.draw();
		GlStateManager.popMatrix();
	}
	
	void renderBox(VertexBuffer buffer, float x1, float y1, float z1, float x2, float y2, float z2, float u1, float v1, float u2, float v2) {
		
		buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL);
		
		//z1
		buffer.pos(x1, y1, z1).tex(u1, v1).color(255,255,255,0).endVertex();
		buffer.pos(x1, y2, z1).tex(u1, v2).color(255,255,255,0).endVertex();
		buffer.pos(x2, y2, z1).tex(u2, v2).color(255,255,255,255).endVertex();
		buffer.pos(x2, y1, z1).tex(u2, v1).color(255,255,255,255).endVertex();
	}
	
	//always do the rendering, even past 64 blocks
	//todo is this needed for the smoke particles?
	public boolean isGlobalRenderer(TeWaypointBasic te) {
		return true;
	}
}
