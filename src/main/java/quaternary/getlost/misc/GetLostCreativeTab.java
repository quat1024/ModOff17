package quaternary.getlost.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import quaternary.getlost.GetLost;

public class GetLostCreativeTab extends CreativeTabs {
	
	public GetLostCreativeTab() {
		super(GetLost.MODID);
	}
	
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Blocks.TORCH);
	}
	
}
