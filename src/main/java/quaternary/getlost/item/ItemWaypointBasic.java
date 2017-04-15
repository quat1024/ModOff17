package quaternary.getlost.item;


import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import quaternary.getlost.GetLost;
import quaternary.getlost.block.ModBlocks;

//Like, the item thing, not the actual block.
//It's kind of like a bed in that sense.
public class ItemWaypointBasic extends Item {
	
	public ItemWaypointBasic() {
		setUnlocalizedName("itemwaypointbasic");
		setRegistryName("item_waypoint_basic");
		GameRegistry.register(this);
		
		setCreativeTab(GetLost.tab);
	}
	
	public void registerModel() {
		GetLost.proxy.registerItemModel(this, "waypoint_basic");
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World w, BlockPos bp, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		//ok, first of all, if you're not clicking on the top of the block, don't place at all.
		if(facing != EnumFacing.UP) return EnumActionResult.PASS;
		
		BlockPos placePosition = new BlockPos(bp);
		
		Block thingClicked = w.getBlockState(bp).getBlock();
		if(!thingClicked.isReplaceable(w, bp)) {
			placePosition = placePosition.up();
		}
		
		//disallow placing these in adventure mode.
		ItemStack thingInTheHand = player.getHeldItem(hand);
		if(!player.canPlayerEdit(placePosition, facing, thingInTheHand)) return EnumActionResult.PASS;
		
		//disallow placing these on things like flowers and glass and stuff.
		if(!w.getBlockState(bp.down()).isFullCube()) return EnumActionResult.PASS;
		if(w.getBlockState(bp.down()).getMaterial().isReplaceable()) return EnumActionResult.PASS;
		
		//we gucci fam lesgo
		w.setBlockState(placePosition, ModBlocks.blockWaypointBasic.getDefaultState(), 3);
		return EnumActionResult.PASS;
	} 
	
}
