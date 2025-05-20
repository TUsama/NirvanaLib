package me.clefal.nirvana_lib.render.rendertype;

import me.clefal.nirvana_lib.mixin.AccessorRenderType;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.Util;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
//? if ~1.21 && neoforge {
/*import net.minecraft.util.TriState;
import net.minecraft.client.renderer.RenderStateShard;
*///?} else {
import net.minecraft.client.renderer.GameRenderer;
//?}

import org.lwjgl.opengl.GL11;

import java.util.function.Function;

public class RenderTypeCreator extends RenderType {

    public static final Function<ResourceLocation, RenderType> gui = Util.memoize(resourceLocation -> createRenderType("nl_normal_gui", DefaultVertexFormat.POSITION_TEX_COLOR, VertexFormat.Mode.QUADS, 1024, false, false,
            CompositeState.builder()
                    //? if ~1.21 && neoforge {

                    /*.setShaderState(RenderStateShard.POSITION_TEXTURE_COLOR_SHADER)
                    .setTextureState(new TextureStateShard(resourceLocation, TriState.FALSE, false))
                 *///?} else {
                    .setShaderState(new ShaderStateShard(GameRenderer::getPositionTexColorShader))
                    .setTextureState(new TextureStateShard(resourceLocation, false, false))
                    //?}

                    .setTransparencyState(new TransparencyStateShard("normal_blend", RenderSystem::enableBlend, RenderSystem::disableBlend))
                    .setDepthTestState(new DepthTestStateShard("nl_normal_gui_depth", GL11.GL_LEQUAL))
                    .createCompositeState(false)));

    public RenderTypeCreator(String $$0, VertexFormat $$1, VertexFormat.Mode $$2, int $$3, boolean $$4, boolean $$5, Runnable $$6, Runnable $$7) {
        super($$0, $$1, $$2, $$3, $$4, $$5, $$6, $$7);
    }

    public static RenderType.CompositeRenderType createRenderType(String name, VertexFormat format, VertexFormat.Mode mode, int bufferSize, boolean $$4, boolean $$5, RenderType.CompositeState state) {
        return AccessorRenderType.create(name, format, mode, bufferSize, $$4, $$5, state);
    }

}
