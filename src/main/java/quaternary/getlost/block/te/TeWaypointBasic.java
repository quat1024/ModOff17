package quaternary.getlost.block.te;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import quaternary.getlost.GetLost;
import quaternary.getlost.block.BlockWaypointBasic;

public class TeWaypointBasic extends TileEntity implements ITickable {
	public void update() {
		if(world.getBlockState(pos).getValue(BlockWaypointBasic.WELL_MADE_AND_LIT) && world.rand.nextInt(10) == 5) {
			float offX = world.rand.nextFloat() * 0.1f - 0.05f;
			float offZ = world.rand.nextFloat() * 0.1f - 0.05f;
			
			float initialvx = (world.rand.nextFloat() * 0.04f) - 0.02f;
			float initialvy = (world.rand.nextFloat() * 0.04f) + 0.04f;
			float initialvz = (world.rand.nextFloat() * 0.04f) - 0.02f;
			
			GetLost.proxy.spawnSmokeParticle(world, pos.getX() + offX + 0.5, pos.getY() + 1, pos.getZ() + offZ + 0.5, initialvx, initialvy, initialvz);
		}
	}
	
}
