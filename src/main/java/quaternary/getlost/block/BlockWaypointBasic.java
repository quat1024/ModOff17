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
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.IScoreCriteria;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import quaternary.getlost.GetLost;
import quaternary.getlost.block.te.TeWaypointBasic;
import quaternary.getlost.item.ModItems;

import java.util.Random;

public class BlockWaypointBasic extends Block implements ITileEntityProvider {
	
	public static final PropertyBool WELL_MADE_AND_LIT = PropertyBool.create("well_made_and_lit");
	public static final AxisAlignedBB AABB = new AxisAlignedBB(0d, 0d, 0d, 1d, 0.5d, 1d);
	
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
	
	//Set this block to use only a TESR
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) { return EnumBlockRenderType.ENTITYBLOCK_ANIMATED; }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess iDontCare, BlockPos asdasdasd) {
		return AABB;
	}
					
					
	//10/10 code organization. D:
	
	public static boolean canBlockStay(World w, BlockPos bp) {
		IBlockState downState = w.getBlockState(bp.down());
		return downState.isFullCube() && downState.isOpaqueCube() && (downState.getMaterial() != Material.PLANTS);
	}
	
	@Override
	public void neighborChanged(IBlockState state, World w, BlockPos bp, Block b, BlockPos frombp) {
		if(!canBlockStay(w, bp)) {
			dropBlockAsItem(w, bp, state, 0);
			w.destroyBlock(bp, false);
		}
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fort) {
		return ModItems.waypointBasic;
	}
	
	@Override
	public boolean isFullCube(IBlockState whocares) {
		return false;
	}
	public boolean isOpaqueCube(IBlockState whocares) {
		return false;
	}
	
	@Override
	public int getLightValue(IBlockState state, IBlockAccess world, BlockPos bp) {
		return state.getValue(WELL_MADE_AND_LIT) ? 15 : 0;
	}
	
	//todo: flint and steel.
	@Override
	public boolean onBlockActivated(World w, BlockPos bp, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(state.getValue(WELL_MADE_AND_LIT)) {
			if(p.getHeldItem(hand).getItem() == Items.WATER_BUCKET) {
				if(!p.capabilities.isCreativeMode) p.setHeldItem(hand, new ItemStack(Items.BUCKET));
				w.setBlockState(bp, getDefaultState().withProperty(WELL_MADE_AND_LIT, false), 3);
				return true;
			}
		} else {
			if(p.getHeldItem(hand).getItem() == Items.FLINT_AND_STEEL) {
				if(!p.capabilities.isCreativeMode) p.getHeldItem(hand).attemptDamageItem(1, w.rand);
				w.setBlockState(bp, getDefaultState().withProperty(WELL_MADE_AND_LIT, true), 3);
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World w, int bla) {
		return new TeWaypointBasic();
	}
	
	//Random Tick Shenanigans
	
	@Override
	public void updateTick(World w, BlockPos bp, IBlockState state, Random rand) {
		if(state.getValue(WELL_MADE_AND_LIT) && w.isRaining()) {
			w.setBlockState(bp, state.withProperty(WELL_MADE_AND_LIT, false));
			return;
		}
		
		if(w.getGameRules().getBoolean("doFireTick")) {
			//todo it's lit fam
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
