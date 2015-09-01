package com.fuzzypickles14.CrystalSorcery.KnowledgeSystem.CodexGUI;

import com.fuzzypickles14.CrystalSorcery.KnowledgeSystem.CodexEntry.EntryCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.util.*;

/**
 * Created by toomz_000 on 7/24/2015.
 */
public class GuiCodex extends GuiScreen
{
    public static final int BOOKMARK_START = 1337;
    public static final ResourceLocation texture = new ResourceLocation();
    public static GuiCodex currentCodex = new GuiCodex();
    public static ItemStack stackUsed;
    public static List<GuiCodex> bookmarks = new ArrayList();
   // public static Queue<EntryCategory> tutorial = new ArrayDeque();
    public float lastTime = 0F;
    public float partialTicks = 0F;
    public float timeDelta = 0F;
    boolean bookmarksNeedPopulation = false;
    List<EntryCategory> allCategories;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    private int guiWidth = 146;
    private int guiHeight = 180;
    private int left, top;

    @Override
    public void initGui()
    {
        super.initGui();

        allCategories = new ArrayList<EntryCategory>(EntryCategory.getAllCategories());
        Collections.sort(allCategories);

        currentCodex = this;

        buttonList.clear();

        if (isIndex()) {
            int x = 18;
            for (int i = 0; i < 12; i++) {
                int y = 16 + i * 12;
                buttonList.add(new GuiButtonInvisible(i, left + x, top + y, 110, 10, ""));
            }
            populateIndex();
        } else if (isCategoryIndex()) {
            int categories = allCategories.size();
            for (int i = 0; i < categories + 1; i++) {
                EntryCategory category;
                category = i >= categories ? null : allCategories.get(i);
                int x = i % 4;
                int y = i / 4;

                int size = 27;
                GuiButtonCategory button = new GuiButtonCategory(i, left + 18 + x * size, top + 35 + y * size, this, category);
                buttonList.add(button);
            }
        }


    }


    private void populateIndex() {
        List<EntryCategory> categoryList = EntryCategory.getAllCategories();
        int shift = 2;
        for (int i = shift; i < 12; i++) {
            int i_ = i - shift;
            GuiButtonInvisible button = (GuiButtonInvisible) buttonList.get(i);
            EntryCategory category = i_ >= categoryList.size() ? null : categoryList.get(i_);
            if (category != null)
                button.displayString = StatCollector.translateToLocal(category.getCategoryName());
            else {
                button.displayString = StatCollector.translateToLocal("CHANGE THIS TO SOMETHING");
                break;
            }
        }
    }


    private boolean isIndex()
    {
        return false;
    }

    private boolean isCategoryIndex()
    {
        return true;
    }

    @Override
    public void drawScreen(int par1, int par2, float par3) {
        float time = ClientTickHandler.ticksInGame + par3;
        timeDelta = time - lastTime;
        lastTime = time;
        partialTicks = par3;

        GL11.glColor4f(1F, 1F, 1F, 1F);
        mc.renderEngine.bindTexture(texture);
        drawTexturedModalRect(left, top, 0, 0, guiWidth, guiHeight);

        drawBookmark(left + guiWidth / 2, top - getTitleHeight(), getTitle(), true);
        String subtitle = getSubtitle();
        if (subtitle != null) {
            GL11.glScalef(0.5F, 0.5F, 1F);
            drawCenteredString(fontRendererObj, subtitle, left * 2 + guiWidth, (top - getTitleHeight() + 11) * 2, 0x00FF00);
            GL11.glScalef(2F, 2F, 1F);
        }

        drawHeader();

        if (bookmarksNeedPopulation) {
            populateBookmarks();
            bookmarksNeedPopulation = false;
        }

        super.drawScreen(par1, par2, par3);
    }

    public void drawBookmark(int x, int y, String s, boolean drawLeft) {
        // This function is called from the buttons so I can't use fontRendererObj
        FontRenderer font = Minecraft.getMinecraft().fontRenderer;
        boolean unicode = font.getUnicodeFlag();
        font.setUnicodeFlag(true);
        int l = font.getStringWidth(s);
        int fontOff = 0;

        if (!drawLeft) {
            x += l / 2;
            fontOff = 2;
        }

        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

        GL11.glColor4f(1F, 1F, 1F, 1F);
        drawTexturedModalRect(x + l / 2 + 3, y - 1, 54, 180, 6, 11);
        if (drawLeft)
            drawTexturedModalRect(x - l / 2 - 9, y - 1, 61, 180, 6, 11);
        for (int i = 0; i < l + 6; i++)
            drawTexturedModalRect(x - l / 2 - 3 + i, y - 1, 60, 180, 1, 11);

        font.drawString(s, x - l / 2 + fontOff, y, 0x111111, false);
        font.setUnicodeFlag(unicode);
    }

    void populateBookmarks() {
        List remove = new ArrayList();
        List<GuiButton> buttons = buttonList;
        for (GuiButton button : buttons)
            if (button.id >= BOOKMARK_START)
                remove.add(button);
        buttonList.removeAll(remove);

        int len = bookmarks.size();
        boolean thisExists = false;
        for (GuiCodex lex : bookmarks)
            if (lex.getTitle().equals(getTitle()))
                thisExists = true;

        boolean addEnabled = len < 8 && this instanceof IParented && !thisExists;
        for (int i = 0; i < len + (addEnabled ? 1 : 0); i++) {
            boolean isAdd = i == bookmarks.size();
            GuiCodex gui = isAdd ? null : bookmarks.get(i);
            buttonList.add(new GuiButtonBookmark(BOOKMARK_START + i, left + 138, top + 18 + 14 * i, gui == null ? this : gui, gui == null ? "+" : gui.getTitle()));
        }
    }


    public void drawHeader() {
        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(String.format(StatCollector.translateToLocal("aura.gui.lexicon.header")), left + 18, top + 12, 110, 0);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    public void populateIndex() {
        List<EntryCategory> categoryList = CategoryManager.getAllCategories();
        int shift = 2;
        for (int i = shift; i < 12; i++) {
            int i_ = i - shift;
            GuiButtonInvisible button = (GuiButtonInvisible) buttonList.get(i);
            LexiconCategory category = i_ >= categoryList.size() ? null : categoryList.get(i_);
            if (category != null)
                button.displayString = StatCollector.translateToLocal(category.getUnlocalizedName());
            else {
                button.displayString = StatCollector.translateToLocal("auramisc.lexiconIndex");
                break;
            }
        }
    }


}
