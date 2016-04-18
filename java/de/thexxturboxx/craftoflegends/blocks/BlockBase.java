package de.thexxturboxx.craftoflegends.blocks;

import de.thexxturboxx.craftoflegends.items.ICOLItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public abstract class BlockBase extends Block implements ICOLItem {
	
	public BlockBase(Material materialIn) {
		super(materialIn);
	}
	
}
