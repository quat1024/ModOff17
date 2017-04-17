package quaternary.getlost.block.te.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;
import quaternary.getlost.block.te.TeWaypointBasic;

import java.util.Random;

import static quaternary.getlost.block.te.render.TERenderingUtils.renderBox;

public class TeRenderWaypointBasic extends TileEntitySpecialRenderer<TeWaypointBasic> {
	
	final ResourceLocation tex = new ResourceLocation("getlost:textures/tesr/fireplace.png");
	
	//                                    u1,   v1,   u2, v2
	final float[] uvLogEnd =  new float[]{0.5f, 0.5f, 1f, 1f  };
	final float[] uvLogSide = new float[]{0f,   0f,   1f, 0.5f};
	final float[] uvLogSide2 = new float[]{0f, 0.5f, 1f, 0f};
	
	final float[][] uvsLog = new float[][]{uvLogSide, uvLogEnd, uvLogSide, uvLogEnd, uvLogSide, uvLogSide};
	
	//HERE WE GO BITCHES
	public void renderTileEntityAt(TeWaypointBasic te, double x, double y, double z, float pt, int destroyStage) {
		TextureManager textureManager = Minecraft.getMinecraft().renderEngine;
		Tessellator tessellator = Tessellator.getInstance();
		VertexBuffer buffer = tessellator.getBuffer();
		
		textureManager.bindTexture(tex);
		
		GlStateManager.pushMatrix();
		
		GlStateManager.translate(x + 0.5, y, z + 0.5);
		
		GlStateManager.rotate(20, 0, 1, 0);
		
		renderCenteredBox(buffer, tessellator, 0f, 0.125f, 0.25f,  1f, 0.25f, 0.25f, uvsLog);
		renderCenteredBox(buffer, tessellator, 0f, 0.125f, -0.25f, 1f, 0.25f, 0.25f, uvsLog);
		
		GlStateManager.rotate(90, 0, 1, 0);
		
		renderCenteredBox(buffer, tessellator, 0f,  0.325f, 0.25f, 1f, 0.25f, 0.25f, uvsLog);
		renderCenteredBox(buffer, tessellator, 0f, 0.325f, -0.25f, 1f, 0.25f, 0.25f, uvsLog);
		
		
		
		GlStateManager.popMatrix();
	}
	
	public static void renderCenteredBox(VertexBuffer buffer, Tessellator t, float x, float y, float z, float width, float height, float length, float[][] uvs) {
		float halfWidth  = width/2;
		float halfHeight = height/2;
		float halfLength = length/2;
		
		GlStateManager.pushMatrix();
		GlStateManager.translate(x, y, z);
		
		buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL);
		renderBox(buffer, -halfWidth, -halfHeight, -halfLength, halfWidth, halfHeight, halfLength, uvs);
		t.draw();
		
		GlStateManager.popMatrix();
	}
	
	public boolean isGlobalRenderer(TeWaypointBasic te) {
		return true;
	}
}
