package com.fuzzypickles14.CrystalSorcery.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

/**
 * Created by toomz_000 on 5/18/2015.
 */
public class fireCruxRender extends TileEntitySpecialRenderer
{
    fireCruxModelRender model;
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double d0, double d1, double d2, float ticks)
    {

       model = new fireCruxModelRender();
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(1F, 1F, 1F, 1F);
        GL11.glTranslated(d0, d1, d2);
        GL11.glScalef(1F, -1.5F, -1F);
       model.renderCrystal();
        GL11.glPopMatrix();

    }
}
