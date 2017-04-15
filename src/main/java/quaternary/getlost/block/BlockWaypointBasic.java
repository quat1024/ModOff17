package quaternary.getlost.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import quaternary.getlost.GetLost;

import java.util.Random;

public class BlockWaypointBasic extends Block {
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
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState s, World w, BlockPos bp, Random r) {
		//todo make your own particle
		//todo move this to tileentity; more particles \:D/
		
		//some indicator of time
		float t = Minecraft.getMinecraft().getSystemTime() / 1000f;
		
		double ang = t / 4;
		double offX = 0.5 + Math.cos(ang) * 0.4;
		double offZ = 0.5 + Math.sin(ang) * 0.4;
		
		
		
		w.spawnParticle(EnumParticleTypes.SMOKE_LARGE, true, bp.getX()+0.5, bp.getY() + 1, bp.getZ() + 0.5, offX/6, 0.05, offZ/6);
	}
}
