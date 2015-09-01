package com.fuzzypickles14.CrystalSorcery.KnowledgeSystem.CodexGUI;

import com.fuzzypickles14.CrystalSorcery.KnowledgeSystem.CodexEntry.EntryCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by toomz_000 on 7/24/2015.
 */
public class GuiButtonCategory extends GuiButtonCodex
{
    private static final ResourceLocation fallbackResource = new ResourceLocation("");

    GuiCodex gui;
    EntryCategory category;
    float ticksHovered = 0F;

    public GuiButtonCategory(int id, int x, int y, GuiCodex gui, EntryCategory category) {
        super(id, x, y, 24, 24, "");
        this.gui = gui;
        this.category = category;
    }

    @Override
    public void drawButton(Minecraft mc, int mx, int my) {
        boolean inside = mx >= xPosition && my >= yPosition && mx < xPosition + width && my < yPosition + height;
        float time = 5F;
        if (inside)
            ticksHovered = Math.min(time, ticksHovered + gui.timeDelta);
        else ticksHovered = Math.max(0F, ticksHovered - gui.timeDelta);

        /*
        Old code related to rendering categories from a texture instead of an ItemStack
        ResourceLocation resource;
        if (category == null)
            resource = fallbackResource;
        else resource = category.getIcon();
        if (resource == null)
            resource = fallbackResource;

        mc.renderEngine.bindTexture(resource);
        */
        //float s = 1F / 48F;
        float defAlpha = 0.3F;
        float alpha = ticksHovered / time * (1F - defAlpha) + defAlpha;

        GL11.glPushMatrix();
        GL11.glColor4f(2F, 2F, 2F, alpha);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        //GL11.glScalef(.5F, 3F, 3F);

        ItemStack itemStack;
        if (category == null) {
            itemStack = new ItemStack(Items.book);
        } else {
            itemStack = category.getItemIcon();
        }
        GL11.glDisable(GL11.GL_LIGHTING);
        RenderItem.getInstance().renderItemIntoGUI(Minecraft.getMinecraft().fontRenderer, Minecraft.getMinecraft().getTextureManager(), itemStack, xPosition, yPosition);

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();

        if (inside)
        {}
            //VazkiiRenderHelper.renderTooltipGreen(mx, my, Arrays.asList(StatCollector.translateToLocal(getTooltipText())));
    }

    String getTooltipText() {
        if (category == null)
            return "auramisc.lexiconIndex";
        return category.getCategoryName();
    }

    public EntryCategory getCategory() {
        return category;
    }


}
