package com.fuzzypickles14.CrystalSorcery.render;

import com.fuzzypickles14.CrystalSorcery.tileentity.Crux.FireCruxEntity;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

/**
 * Created by toomz_000 on 5/18/2015.
 */
public class fireCruxBlockRender implements ISimpleBlockRenderingHandler
{
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef(-0.5F, -0.7F, -0.5F);
        GL11.glRotated(180.0, 0, 0, 0);
        TileEntityRendererDispatcher.instance.renderTileEntityAt(new FireCruxEntity(), 0.0D, 0.0D, 0.0D, 0.0F);
        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef(-0.5F, -0.7F, -0.5F);
        GL11.glRotated(180.0, 0, 0, 0);
        TileEntityRendererDispatcher.instance.renderTileEntityAt(new FireCruxEntity(), 0.0D, 0.0D, 0.0D, 0.0F);
        GL11.glPopMatrix();
        return false;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return -1;
    }
}
