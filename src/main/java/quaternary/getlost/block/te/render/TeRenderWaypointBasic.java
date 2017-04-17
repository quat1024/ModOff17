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
	
	//                                    u1,   v1, u2,   v2
	final float[] uvLogEnd =  new float[]{0.5f, 0f, 1f,   0.5f};
	final float[] uvLogSide = new float[]{0f,   0f, 0.5f, 0.5f};
	
	//HERE WE GO BITCHES
	public void renderTileEntityAt(TeWaypointBasic te, double x, double y, double z, float pt, int destroyStage) {
		TextureManager textureManager = Minecraft.getMinecraft().renderEngine;
		Tessellator tessellator = Tessellator.getInstance();
		VertexBuffer buffer = tessellator.getBuffer();
		
		textureManager.bindTexture(tex);
		
		GlStateManager.pushMatrix();
		
		GlStateManager.translate(x, y, z);
		//renderBox(buffer, 0, 0, 0, 1, 1, 1, uvLogSide, uvLogEnd, uvLogSide, uvLogEnd, uvLogSide, uvLogSide);
		renderRotatedCenteredBox(buffer, 0.7f, 0.3f, 0.7f, 1f, 0.1f, 0.1f, 30, new float[][]{uvLogSide, uvLogEnd, uvLogSide, uvLogEnd, uvLogSide, uvLogSide});
		tessellator.draw();
		
		GlStateManager.popMatrix();
	}
	
	public void renderRotatedCenteredBox(VertexBuffer buffer, float x, float y, float z, float width, float height, float length, float spin, float[][] uvs) {
		float halfWidth =  width/2;
		float halfHeight = height/2;
		float halfLength = length/2;
		
		GlStateManager.pushMatrix();
		
		//Everything I do here is just ignored
		//todo what the FUCK is opengl
		GlStateManager.translate(x + halfWidth, y + halfHeight, z + halfLength);
		GlStateManager.rotate(spin, 1, 0, 0);
		GlStateManager.translate(-halfWidth, -halfHeight, -halfLength);
		
		
		renderBox(buffer, -halfWidth, -halfHeight, -halfLength, halfWidth, halfHeight, halfLength, uvs);
		
		GlStateManager.popMatrix();
	}
	
	public boolean isGlobalRenderer(TeWaypointBasic te) {
		return true;
	}
}
