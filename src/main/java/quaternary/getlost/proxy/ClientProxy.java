package quaternary.getlost.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import quaternary.getlost.GetLost;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerItemModel(Item item, String name) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(GetLost.MODID + ":" + name));
	}
}