package quaternary.getlost.block.te;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTes {
	
	public static void doTheThing() {
		GameRegistry.registerTileEntity(TeWaypointBasic.class, "getlost_waypoint_basic");
	}
	
}
