package quaternary.getlost.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import quaternary.getlost.GetLost;
import quaternary.getlost.block.te.TeWaypointBasic;

import java.util.Random;

public class BlockWaypointBasic extends Block implements ITileEntityProvider {
	
	public static final PropertyBool WELL_MADE_AND_LIT = PropertyBool.create("well_made_and_lit");
	
	public BlockWaypointBasic() {
		super(Material.WOOD);

		setUnlocalizedName("blockwaypointbasic");
		setRegistryName("block_waypoint_basic");
		
		GameRegistry.register(this);
		setCreativeTab(GetLost.tab);
		
		setDefaultState(blockState.getBaseState().withProperty(WELL_MADE_AND_LIT, false));
		
		setTickRandomly(true); //lights things on fire!
		//todo: config?
	}
	
	
	
	@Override
	public boolean isFullCube(IBlockState whocares) {
		return false;
	}
	
	@Override
	public int getLightValue(IBlockState state, IBlockAccess world, BlockPos bp) {
		return state.getValue(WELL_MADE_AND_LIT) ? 15 : 0;
	}
	
	//todo: flint and steel.
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		worldIn.setBlockState(pos, state.withProperty(WELL_MADE_AND_LIT, !state.getValue(WELL_MADE_AND_LIT)));
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World w, int bla) {
		return new TeWaypointBasic();
	}
	
	//Random Tick Shenanigans
	
	@Override
	public void updateTick(World w, BlockPos bp, IBlockState state, Random rand) {
		if(w.isRainingAt(bp) && rand.nextInt(10) < 3) {
			//Ok so this is the downside of the fireplace ones. They... go out!
			w.setBlockState(bp, state.withProperty(WELL_MADE_AND_LIT, false));
			return;
		}
		
		
		if(w.getGameRules().getBoolean("doFireTick")) {
			//it's lit fam
			
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState s, World w, BlockPos bp, Random r) {
		//todo - smol ember particles? idk
	}
	
	//Blockstate Shenanigans
	
	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, WELL_MADE_AND_LIT);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(WELL_MADE_AND_LIT, meta == 1);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(WELL_MADE_AND_LIT) ? 1 : 0;
	}
}
