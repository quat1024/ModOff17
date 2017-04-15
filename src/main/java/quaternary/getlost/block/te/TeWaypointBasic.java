package quaternary.getlost.block.te;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;

import java.util.Random;

public class TeWaypointBasic extends TileEntity implements ITickable {
	
	static Random randOffset;
	
	static {
		randOffset = new Random();
	}
	
	public void update() {
		
		randOffset.setSeed(pos.getX()*1232 + pos.getY()*1000 + pos.getZ()*2000);
		float kindaRandomAngleOffset = randOffset.nextFloat()*6.28f;
		
		float t = kindaRandomAngleOffset + (world.getTotalWorldTime() / 50f);
		
		double offX = Math.cos(t) * 0.4;
		double offZ = Math.sin(t) * 0.4;
		
		world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, true, pos.getX()+0.5, pos.getY() + 1, pos.getZ() + 0.5, offX/6, 0.05, offZ/6);
	}
	
}
