package me.clefal.nirvana_lib.mixin;

import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value = RenderType.class, remap = false)
public interface AccessorRenderType {
    @Invoker("create")
    static RenderType.CompositeRenderType create(String $$0, VertexFormat $$1, VertexFormat.Mode $$2, int $$3, boolean $$4, boolean $$5, RenderType.CompositeState $$6) {
        throw new IllegalStateException("");
    }

}
