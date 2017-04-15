package quaternary.getlost.proxy;

import net.minecraft.item.Item;
import net.minecraft.world.World;

public class CommonProxy {
	public void registerItemModel(Item item, String name) {
		//We're a server so we don't do anything here.
	}
	
	//todo extensible to multiple particle types...
	public void spawnSmokeParticle(World w, double x, double y, double z, double mx, double my, double mz) {
		//WHO CARES LOLOLOL
	}
	
}
