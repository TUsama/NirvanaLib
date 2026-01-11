package com.clefal.nirvana_lib.mixin;

//? >=1.21.8
//import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
//? =1.20.1 {
/*@Mixin(value = RenderType.class)
*///?} else {
@Mixin(value = RenderType.class, remap = false)
//?}
public interface AccessorRenderType {
    //? < 1.21.8 {
    @Invoker("create")
    static RenderType.CompositeRenderType create(String $$0, VertexFormat $$1, VertexFormat.Mode $$2, int $$3, boolean $$4, boolean $$5, RenderType.CompositeState $$6) {
        throw new IllegalStateException("");
    }
    //?} else {
    /*@Invoker("create")
    static RenderType.CompositeRenderType create(String name, int bufferSize, boolean affectsCrumbling, boolean sortOnUpload, RenderPipeline renderPipeline, RenderType.CompositeState state) {
        throw new IllegalStateException("");
    }
    *///?}

}
