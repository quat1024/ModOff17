package quaternary.getlost.item;

import quaternary.getlost.item.compass.ItemCustomCompass;
import quaternary.getlost.item.compass.provider.CompassProviderNorth;
import quaternary.getlost.item.compass.provider.CompassProviderOrigin;

public class ModItems {
	
	public static ItemWaypointBasic waypointBasic;
	public static ItemCustomCompass compassOrigin;
	public static ItemCustomCompass compassMagnetic;
	
	public static void doTheThing() {
		waypointBasic = new ItemWaypointBasic();
		waypointBasic.registerModel();
		
		compassOrigin = new ItemCustomCompass("origin_compass", new CompassProviderOrigin());
		compassOrigin.registerModel();
		
		compassMagnetic = new ItemCustomCompass("magnetic_compass", new CompassProviderNorth());
		compassMagnetic.registerModel();
	}
	
	
}
