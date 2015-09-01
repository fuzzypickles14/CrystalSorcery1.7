package com.fuzzypickles14.CrystalSorcery.KnowledgeSystem.CodexGUI;

import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

/**
 * Created by toomz_000 on 7/24/2015.
 */
public class GuiButtonCodex extends GuiButton
{
    public GuiButtonCodex(int p_i1021_1_, int p_i1021_2_, int p_i1021_3_, int p_i1021_4_, int p_i1021_5_, String p_i1021_6_) {
        super(p_i1021_1_, p_i1021_2_, p_i1021_3_, p_i1021_4_, p_i1021_5_, p_i1021_6_);
    }

    @Override
    public void func_146113_a(SoundHandler p_146113_1_) {
        p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(new ResourceLocation("aura:lexiconPage"), 1.0F));
    }
}
