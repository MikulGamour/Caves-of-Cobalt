
/**
 * ModelZombie - Either Mojang or a mod author Created using Tabula 7.0.1
 */
public static class ModelProjectedZombie extends ModelBase {
	public ModelRenderer field_178723_h;
	public ModelRenderer field_178721_j;
	public ModelRenderer field_78116_c;
	public ModelRenderer field_78115_e;
	public ModelRenderer field_178724_i;
	public ModelRenderer field_178722_k;

	public ModelProjectedZombie() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.field_78116_c = new ModelRenderer(this, 0, 0);
		this.field_78116_c.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.field_78116_c.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		this.field_78115_e = new ModelRenderer(this, 16, 16);
		this.field_78115_e.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.field_78115_e.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
		this.field_178724_i = new ModelRenderer(this, 40, 16);
		this.field_178724_i.mirror = true;
		this.field_178724_i.setRotationPoint(5.0F, 2.0F, 0.0F);
		this.field_178724_i.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
		this.setRotateAngle(field_178724_i, -1.3962634015954636F, 0.10000736613927509F, -0.10000736613927509F);
		this.field_178723_h = new ModelRenderer(this, 40, 16);
		this.field_178723_h.setRotationPoint(-5.0F, 2.0F, 0.0F);
		this.field_178723_h.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
		this.setRotateAngle(field_178723_h, -1.3962634015954636F, -0.10000736613927509F, 0.10000736613927509F);
		this.field_178721_j = new ModelRenderer(this, 0, 16);
		this.field_178721_j.setRotationPoint(-1.9F, 12.0F, 0.1F);
		this.field_178721_j.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.field_178722_k = new ModelRenderer(this, 0, 16);
		this.field_178722_k.mirror = true;
		this.field_178722_k.setRotationPoint(1.9F, 12.0F, 0.1F);
		this.field_178722_k.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 0.5F);
		this.field_78116_c.render(f5);
		GlStateManager.disableBlend();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 0.5F);
		this.field_78115_e.render(f5);
		GlStateManager.disableBlend();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 0.5F);
		this.field_178724_i.render(f5);
		GlStateManager.disableBlend();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 0.5F);
		this.field_178723_h.render(f5);
		GlStateManager.disableBlend();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 0.5F);
		this.field_178721_j.render(f5);
		GlStateManager.disableBlend();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 0.5F);
		this.field_178722_k.render(f5);
		GlStateManager.disableBlend();
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.field_178721_j.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.field_78116_c.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.field_78116_c.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.field_178722_k.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}
