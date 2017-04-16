package quaternary.getlost.block.te;

import net.minecraftforge.fml.common.registry.GameRegistry;
import quaternary.getlost.block.te.render.TeRenderWaypointBasic;

import static quaternary.getlost.GetLost.proxy;

public class ModTes {
	
	public static void doTheThing() {
		GameRegistry.registerTileEntity(TeWaypointBasic.class, "getlost_waypoint_basic");
		proxy.registerTESR(TeWaypointBasic.class, new TeRenderWaypointBasic());
	}
	
}
