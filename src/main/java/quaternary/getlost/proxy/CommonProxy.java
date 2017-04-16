package quaternary.getlost.proxy;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CommonProxy {
	public void registerItemModel(Item item, String name) {
		//We're a server so we don't do anything here.
	}
	
	//todo extensible to multiple particle types...
	public void spawnSmokeParticle(World w, double x, double y, double z, double mx, double my, double mz) {
		//"lol what's a smoke particle" - the server
	}
	
	public <T extends TileEntity> void registerTESR(Class<T> te, TileEntitySpecialRenderer <? super T> tesr) {
		//"lol whats a tesr" - the server
	}
	
}
