package mod.darkness.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFox extends ModelBase {
    public ModelRenderer neck;
    public ModelRenderer headHead;
    public ModelRenderer bodyBase;
    public ModelRenderer tailTop;
    public ModelRenderer tailMiddle;
    public ModelRenderer tailEnd;
    public ModelRenderer earLeft;
    public ModelRenderer earRight;
    public ModelRenderer mawTop;
    public ModelRenderer mawBottom;
    public ModelRenderer legFLTop;
    public ModelRenderer legFLBottom;
    public ModelRenderer legFRTop;
    public ModelRenderer legFRBottom;
    public ModelRenderer legBLTop;
    public ModelRenderer legBLBottom;
    public ModelRenderer legBRTop;
    public ModelRenderer legBRBottom;

    public ModelFox() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.legBLBottom = new ModelRenderer(this, 0, 0);
        this.legBLBottom.setRotationPoint(2.0F, 21.0F, 6.0F);
        this.legBLBottom.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.neck = new ModelRenderer(this, 0, 0);
        this.neck.setRotationPoint(0.0F, 11.0F, -7.0F);
        this.neck.addBox(-2.5F, -2.5F, -1.0F, 5, 5, 3, 0.0F);
        this.setRotateAngle(neck, -0.17453292519943295F, 0.0F, 0.0F);
        this.legFLTop = new ModelRenderer(this, 0, 0);
        this.legFLTop.setRotationPoint(2.0F, 17.0F, -4.0F);
        this.legFLTop.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.legFRTop = new ModelRenderer(this, 0, 0);
        this.legFRTop.setRotationPoint(-2.0F, 17.0F, -4.0F);
        this.legFRTop.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.legBRTop = new ModelRenderer(this, 0, 0);
        this.legBRTop.setRotationPoint(-2.0F, 17.0F, 6.0F);
        this.legBRTop.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.bodyBase = new ModelRenderer(this, 0, 0);
        this.bodyBase.setRotationPoint(0.0F, 13.0F, 2.0F);
        this.bodyBase.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 16, 0.0F);
        this.mawTop = new ModelRenderer(this, 53, 0);
        this.mawTop.setRotationPoint(0.0F, 10.0F, -10.0F);
        this.mawTop.addBox(-1.0F, 0.0F, -7.0F, 2, 1, 3, 0.0F);
        this.tailEnd = new ModelRenderer(this, 0, 0);
        this.tailEnd.setRotationPoint(0.0F, 13.0F, 10.0F);
        this.tailEnd.addBox(-2.0F, -3.0F, 10.0F, 4, 4, 3, 0.0F);
        this.legBLTop = new ModelRenderer(this, 0, 0);
        this.legBLTop.setRotationPoint(2.0F, 17.0F, 6.0F);
        this.legBLTop.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.legBRBottom = new ModelRenderer(this, 0, 0);
        this.legBRBottom.setRotationPoint(-2.0F, 21.0F, 6.0F);
        this.legBRBottom.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.headHead = new ModelRenderer(this, 0, 0);
        this.headHead.setRotationPoint(0.0F, 10.0F, -10.0F);
        this.headHead.addBox(-3.0F, -3.0F, -4.0F, 6, 6, 7, 0.0F);
        this.mawBottom = new ModelRenderer(this, 0, 0);
        this.mawBottom.setRotationPoint(0.0F, 10.0F, -10.0F);
        this.mawBottom.addBox(-1.0F, 1.0F, -7.0F, 2, 1, 3, 0.0F);
        this.tailTop = new ModelRenderer(this, 0, 0);
        this.tailTop.setRotationPoint(0.0F, 13.0F, 10.0F);
        this.tailTop.addBox(-2.0F, -3.0F, 0.0F, 4, 4, 2, 0.0F);
        this.tailMiddle = new ModelRenderer(this, 0, 0);
        this.tailMiddle.setRotationPoint(0.0F, 13.0F, 10.0F);
        this.tailMiddle.addBox(-2.5F, -3.5F, 1.0F, 5, 5, 10, 0.0F);
        this.earLeft = new ModelRenderer(this, 0, 0);
        this.earLeft.setRotationPoint(0.0F, 10.0F, -10.0F);
        this.earLeft.addBox(1.0F, -5.0F, -0.5F, 2, 3, 1, 0.0F);
        this.setRotateAngle(earLeft, 0.0F, 0.0F, 0.17453292519943295F);
        this.legFLBottom = new ModelRenderer(this, 0, 0);
        this.legFLBottom.setRotationPoint(2.0F, 21.0F, -4.0F);
        this.legFLBottom.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.legFRBottom = new ModelRenderer(this, 0, 0);
        this.legFRBottom.setRotationPoint(-2.0F, 21.0F, -4.0F);
        this.legFRBottom.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.earRight = new ModelRenderer(this, 0, 0);
        this.earRight.setRotationPoint(0.0F, 10.0F, -10.0F);
        this.earRight.addBox(-3.0F, -5.0F, -0.5F, 2, 3, 1, 0.0F);
        this.setRotateAngle(earRight, 0.0F, 0.0F, -0.17453292519943295F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.legBLBottom.render(f5);
        this.neck.render(f5);
        this.legFLTop.render(f5);
        this.legFRTop.render(f5);
        this.legBRTop.render(f5);
        this.bodyBase.render(f5);
        this.mawTop.render(f5);
        this.tailEnd.render(f5);
        this.legBLTop.render(f5);
        this.legBRBottom.render(f5);
        this.headHead.render(f5);
        this.mawBottom.render(f5);
        this.tailTop.render(f5);
        this.tailMiddle.render(f5);
        this.earLeft.render(f5);
        this.legFLBottom.render(f5);
        this.legFRBottom.render(f5);
        this.earRight.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
