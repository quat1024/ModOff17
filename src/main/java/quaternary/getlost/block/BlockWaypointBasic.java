package quaternary.getlost.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import quaternary.getlost.GetLost;
import quaternary.getlost.block.te.TeWaypointBasic;

import java.util.Random;

public class BlockWaypointBasic extends Block implements ITileEntityProvider {
	public BlockWaypointBasic() {
		super(Material.WOOD);
		
		setUnlocalizedName("blockwaypointbasic");
		setRegistryName("block_waypoint_basic");
		
		GameRegistry.register(this);
		setCreativeTab(GetLost.tab);
	}
	
	@Override
	public boolean isFullCube(IBlockState whocares) {
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World w, int bla) {
		return new TeWaypointBasic();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState s, World w, BlockPos bp, Random r) {
		//shit temporary particle code
		//todo make your own particle
		//todo move this to tileentity; more particles \:D/
		
		//some indicator of time
		//todo - this increases while paused. is it worth it to use player.ticksExisted?
		//don't use whatever banners use - it causes tick lag and network latency to affect rendering
		//which is obviously super silly
		
	}
}
