package quaternary.getlost.recipe;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import quaternary.getlost.item.ModItems;

public class ModRecipes {
	
	public static void doTheThing() {
		GameRegistry.addRecipe(new ShapedOreRecipe(
						new ItemStack(ModItems.waypointBasic, 1),
						"lsl", "sfs", "lsl", 'l', "logWood", 's', "stickWood", 'f', Items.FLINT));
	}
	
}
