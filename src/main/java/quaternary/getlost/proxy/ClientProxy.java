package quaternary.getlost.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import quaternary.getlost.GetLost;
import quaternary.getlost.block.te.TeWaypointBasic;
import quaternary.getlost.block.te.render.TeRenderWaypointBasic;
import quaternary.getlost.particle.ParticleSmoke;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerItemModel(Item item, String name) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(GetLost.MODID + ":" + name));
	}
	
	//todo extensible to multiple particle types...
	@Override
	public void spawnSmokeParticle(World w, double x, double y, double z, double mx, double my, double mz) {
		
		ParticleSmoke bla = new ParticleSmoke(w, x, y, z, mx, my, mz);
		
		Minecraft.getMinecraft().effectRenderer.addEffect(bla);
	}
	
	public <T extends TileEntity> void registerTESR(Class<T> te, TileEntitySpecialRenderer <? super T> tesr) {
		ClientRegistry.bindTileEntitySpecialRenderer(te, tesr);
	}
}
