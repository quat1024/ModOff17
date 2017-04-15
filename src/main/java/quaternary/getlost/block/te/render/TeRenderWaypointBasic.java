package quaternary.getlost.block.te.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import quaternary.getlost.block.te.TeWaypointBasic;

public class TeRenderWaypointBasic extends TileEntitySpecialRenderer<TeWaypointBasic> {
	
	public void renderTileEntityAt(TeWaypointBasic te, double x, double y, double z, float pt, int destroyStage) {
		
	}
	
	
	//always do the rendering, even past 64 blocks
	public boolean isGlobalRenderer(TeWaypointBasic te) {
		return true;
	}
}
