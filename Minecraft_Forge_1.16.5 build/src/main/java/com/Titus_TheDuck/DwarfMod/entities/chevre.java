// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class chevre extends EntityModel<Entity> {
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;

	public chevre() {
		texWidth = 64;
		texHeight = 64;

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);
		bb_main.texOffs(-32, -18).addBox(-8.0F, -23.0F, -10.0F, 16.0F, 15.0F, 20.0F, 0.0F, false);
		bb_main.texOffs(-4, -2).addBox(-7.0F, -10.0F, 3.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);
		bb_main.texOffs(-4, -2).addBox(3.0F, -10.0F, 3.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);
		bb_main.texOffs(-4, -2).addBox(3.0F, -10.0F, -8.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);
		bb_main.texOffs(-4, -2).addBox(-7.0F, -10.0F, -8.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(2.0F, -35.0F, -13.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-4.0F, -35.0F, -13.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(-3.0F, -28.0F, -10.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.8727F);
		cube_r1.texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(3.0F, -28.0F, -10.0F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.8727F);
		cube_r2.texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(3.0F, -26.0F, -7.0F);
		bb_main.addChild(cube_r3);
		setRotationAngle(cube_r3, 1.0472F, 0.0F, 0.0F);
		cube_r3.texOffs(-17, -11).addBox(-7.0F, -7.0F, -12.0F, 8.0F, 7.0F, 13.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}