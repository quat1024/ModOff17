package quaternary.getlost.item;


import net.minecraft.item.Item;
import quaternary.getlost.GetLost;

//Like, the item thing, not the actual block.
//It's kind of like a bed in that sense.
public class ItemWaypointBasic extends Item {
	
	public ItemWaypointBasic() {
		setUnlocalizedName("waypointbasic");
		setRegistryName("waypoint_basic");
		setCreativeTab(GetLost.tab);
	}
	
	public void registerModel() {
		GetLost.proxy.registerItemModel(this, "waypoint_basic");
	}
	
}
