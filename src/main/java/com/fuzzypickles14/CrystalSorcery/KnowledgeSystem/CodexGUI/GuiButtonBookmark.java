package com.fuzzypickles14.CrystalSorcery.KnowledgeSystem.CodexGUI;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toomz_000 on 8/19/2015.
 */
public class GuiButtonBookmark extends GuiButtonCodex
{
    GuiCodex gui;

    public GuiButtonBookmark(int par1, int par2, int par3, GuiCodex gui, String str) {
        super(par1, par2, par3, gui.bookmarkWidth(str) + 5, 11, str);
        this.gui = gui;
    }

    @Override
    public void drawButton(Minecraft mc, int par2, int par3) {
        gui.drawBookmark(xPosition, yPosition, displayString, false);
        field_146123_n = par2 >= xPosition && par3 >= yPosition && par2 < xPosition + width && par3 < yPosition + height;
        int k = getHoverState(field_146123_n);

        List<String> tooltip = new ArrayList();
        if (displayString.equals("+"))
            tooltip.add(StatCollector.translateToLocal("auramisc.clickToAdd"));
        else {
            tooltip.add(String.format(StatCollector.translateToLocal("auramisc.bookmark"), id - GuiCodex.BOOKMARK_START + 1));
            tooltip.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("auramisc.clickToSee"));
            tooltip.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("auramisc.shiftToRemove"));
        }

        int tooltipY = (tooltip.size() + 1) * 5;
        if (k == 2)
            VazkiiRenderHelper.renderTooltip(par2, par3 + tooltipY, tooltip);
    }
}
