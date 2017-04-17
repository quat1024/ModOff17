package quaternary.getlost.item;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import quaternary.getlost.GetLost;
import quaternary.getlost.block.BlockWaypointBasic;
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
		
		//some helpers for the below...
		IBlockState targetState = w.getBlockState(placePosition);
		Block targetBlock = targetState.getBlock();
		
		//check we're not replacing something that shouldn't be (like a fence)
		if(!targetBlock.isReplaceable(w, placePosition)) return EnumActionResult.PASS;
		//check it won't pop off on a block update
		if(!BlockWaypointBasic.canBlockStay(w, placePosition)) return EnumActionResult.PASS;
		
		//we gucci fam lesgo
		//place the waypoint
		w.setBlockState(placePosition, ModBlocks.blockWaypointBasic.getDefaultState(), 3);
		//shrink the stack
		if(player.capabilities.isCreativeMode == false) thingInTheHand.shrink(1);
		//thunk
		w.playSound(null, placePosition, SoundType.WOOD.getPlaceSound(), SoundCategory.BLOCKS, 1f, 1f);
		return EnumActionResult.SUCCESS;
	} 
	
}
