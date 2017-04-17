package quaternary.getlost.block.te.render;

import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

public class TERenderingUtils {
	
	public static final int U1 = 0;
	public static final int V1 = 1;
	public static final int U2 = 2;
	public static final int V2 = 3;
	
	
	//I CAN SAY, WITHOUT A DOUBT
	//THAT THIS IS THE WORST METHOD
	//I HAVE EVER WRITTEN
	//IN MY WHOLE LIFE
	public static void renderBox(VertexBuffer buffer, float x1, float y1, float z1, float x2, float y2, float z2, float[] uvNorth, float[] uvEast, float[] uvSouth, float[] uvWest, float[] uvTop, float[] uvBottom) {
		
		
		//North facing negative Z
		buffer.pos(x1, y1, z1).tex(uvNorth[U1], uvNorth[V1]).color(255, 255, 255, 255).normal(0, 0, -1).endVertex();
		buffer.pos(x1, y2, z1).tex(uvNorth[U1], uvNorth[V2]).color(255, 255, 255, 255).normal(0, 0, -1).endVertex();
		buffer.pos(x2, y2, z1).tex(uvNorth[U2], uvNorth[V2]).color(255, 255, 255, 255).normal(0, 0, -1).endVertex();
		buffer.pos(x2, y1, z1).tex(uvNorth[U2], uvNorth[V1]).color(255, 255, 255, 255).normal(0, 0, -1).endVertex();
		
		//East facing positive X
		buffer.pos(x2, y1, z1).tex(uvEast[U1], uvEast[V1]).color(255, 255, 255, 255).normal(1, 0, 0).endVertex();
		buffer.pos(x2, y2, z1).tex(uvEast[U1], uvEast[V2]).color(255, 255, 255, 255).normal(1, 0, 0).endVertex();
		buffer.pos(x2, y2, z2).tex(uvEast[U2], uvEast[V2]).color(255, 255, 255, 255).normal(1, 0, 0).endVertex();
		buffer.pos(x2, y1, z2).tex(uvEast[U2], uvEast[V1]).color(255, 255, 255, 255).normal(1, 0, 0).endVertex();
		
		//South facing positive Z
		buffer.pos(x1, y1, z2).tex(uvSouth[U1], uvSouth[V1]).color(255, 255, 255, 255).normal(0, 0, 1).endVertex();
		buffer.pos(x2, y1, z2).tex(uvSouth[U2], uvSouth[V1]).color(255, 255, 255, 255).normal(0, 0, 1).endVertex();
		buffer.pos(x2, y2, z2).tex(uvSouth[U2], uvSouth[V2]).color(255, 255, 255, 255).normal(0, 0, 1).endVertex();
		buffer.pos(x1, y2, z2).tex(uvSouth[U1], uvSouth[V2]).color(255, 255, 255, 255).normal(0, 0, 1).endVertex();
		
		//West facing negative X
		buffer.pos(x1, y1, z1).tex(uvWest[U1], uvWest[V1]).color(255, 255, 255, 255).normal(-1, 0, 0).endVertex();
		buffer.pos(x1, y1, z2).tex(uvWest[U2], uvWest[V1]).color(255, 255, 255, 255).normal(-1, 0, 0).endVertex();
		buffer.pos(x1, y2, z2).tex(uvWest[U2], uvWest[V2]).color(255, 255, 255, 255).normal(-1, 0, 0).endVertex();
		buffer.pos(x1, y2, z1).tex(uvWest[U1], uvWest[V2]).color(255, 255, 255, 255).normal(-1, 0, 0).endVertex();
		
		//Top facing positive Y
		buffer.pos(x1, y2, z1).tex(uvTop[U1], uvTop[V1]).color(255, 255, 255, 255).normal(0, 1, 0).endVertex();
		buffer.pos(x1, y2, z2).tex(uvTop[U1], uvTop[V2]).color(255, 255, 255, 255).normal(0, 1, 0).endVertex();
		buffer.pos(x2, y2, z2).tex(uvTop[U2], uvTop[V2]).color(255, 255, 255, 255).normal(0, 1, 0).endVertex();
		buffer.pos(x2, y2, z1).tex(uvTop[U2], uvTop[V1]).color(255, 255, 255, 255).normal(0, 1, 0).endVertex();
		
		//Buddom facing negative Y
		buffer.pos(x1, y1, z1).tex(uvBottom[U1], uvBottom[V1]).color(255, 255, 255, 255).normal(0, -1, 0).endVertex();
		buffer.pos(x2, y1, z1).tex(uvBottom[U2], uvBottom[V1]).color(255, 255, 255, 255).normal(0, -1, 0).endVertex();
		buffer.pos(x2, y1, z2).tex(uvBottom[U2], uvBottom[V2]).color(255, 255, 255, 255).normal(0, -1, 0).endVertex();
		buffer.pos(x1, y1, z2).tex(uvBottom[U1], uvBottom[V2]).color(255, 255, 255, 255).normal(0, -1, 0).endVertex();
	}
	
	//lazy
	public static void renderBox(VertexBuffer buffer, float x1, float y1, float z1, float x2, float y2, float z2, float[][] uvs) {
		renderBox(buffer, x1, y1, z1, x2, y2, z2, uvs[0], uvs[1], uvs[2], uvs[3], uvs[4], uvs[5]);
	}
	
}
