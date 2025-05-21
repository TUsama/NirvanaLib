package me.clefal.nirvana_lib.render.batch;

import com.google.common.collect.HashMultimap;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

//? if =1.20.1 || (<=1.21.1 && fabric) {
/*import net.minecraft.util.FastColor;
*///?} else {
import net.minecraft.util.ARGB;
//?}
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class VertexContainer {

    private HashMultimap<ResourceLocation, TextureBufferInfo> map = HashMultimap.create(10, 100);
    private List<IFillBufferInfo> fillBufferInfos = new ArrayList<>();

    public VertexContainer(){

    }

    public VertexContainer(int expectedKeys, int expectedValuesPerKey){
        this.map = HashMultimap.create(expectedKeys, expectedValuesPerKey);
    }

    public void putBliz(ResourceLocation resourceLocation, TextureBufferInfo bufferInfo){
        map.put(resourceLocation, bufferInfo);
    }

    public void putFill(IFillBufferInfo fillBufferInfo){
        fillBufferInfos.add(fillBufferInfo);
    }

    private void refresh(){
        this.map = HashMultimap.create(10, 100);
        this.fillBufferInfos = new ArrayList<>();
    }

    public void draw(MultiBufferSource bufferSource, Function<ResourceLocation, RenderType> renderTypeFunction){
        RenderSystem.enableDepthTest();
        for (Map.Entry<ResourceLocation, Collection<TextureBufferInfo>> entry : this.map.asMap().entrySet()) {
            ResourceLocation key = entry.getKey();
            RenderType statusRenderType = renderTypeFunction.apply(key);
            VertexConsumer buffer = bufferSource.getBuffer(statusRenderType);

            for (TextureBufferInfo bufferInfo : entry.getValue()) {
                bufferInfo.upload(buffer);
            }

        }
        VertexConsumer buffer = bufferSource.getBuffer(RenderType.gui());
        if (!fillBufferInfos.isEmpty()){
            for (IFillBufferInfo fillBufferInfo : fillBufferInfos) {
                fillBufferInfo.upload(buffer);
            }
        }

        VertexConsumer end = bufferSource.getBuffer(RenderType.gui());
        int color;

        //? if =1.20.1 || (<=1.21.1 && fabric) {
         /*color = FastColor.ARGB32.color(0, 0, 0, 0);
         *///?} else {
            color = ARGB.color(0, 0, 0, 0);
        //?}

        //? if ~1.21 {
        
        end.addVertex(0, 0, 0).setColor(color);
        end.addVertex(0, 0, 0).setColor(color);
        end.addVertex(0, 0, 0).setColor(color);
        end.addVertex(0, 0, 0).setColor(color);
        //?} else {
        /*end.vertex(0, 0, 0).color(color).endVertex();
        end.vertex(0, 0, 0).color(color).endVertex();
        end.vertex(0, 0, 0).color(color).endVertex();
        end.vertex(0, 0, 0).color(color).endVertex();
        *///?}
        RenderSystem.disableDepthTest();
        refresh();
    }

}