// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class chevre extends EntityModel<Entity> {
	private final ModelRenderer GoatAll;
	private final ModelRenderer Body;
	private final ModelRenderer PlaneTxture_r1;
	private final ModelRenderer Leg;
	private final ModelRenderer FrontLeftLeg;
	private final ModelRenderer BackRightLeg;
	private final ModelRenderer FrontRightLeg;
	private final ModelRenderer BackLeftLeg;
	private final ModelRenderer Queue;
	private final ModelRenderer Queue_r1;
	private final ModelRenderer Neck;
	private final ModelRenderer Neck_r1;
	private final ModelRenderer Head;
	private final ModelRenderer Hair_r1;
	private final ModelRenderer Head_r1;
	private final ModelRenderer LeftEar;
	private final ModelRenderer LeftEar_r1;
	private final ModelRenderer RightEar;
	private final ModelRenderer RightEar_r1;

	public chevre() {
		texWidth = 128;
		texHeight = 128;

		GoatAll = new ModelRenderer(this);
		GoatAll.setPos(0.0F, 24.0F, 0.0F);
		

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, -12.5F, 0.0F);
		GoatAll.addChild(Body);
		Body.texOffs(0, 0).addBox(-8.0F, -5.5F, -10.0F, 16.0F, 13.0F, 20.0F, 0.0F, false);
		Body.texOffs(72, 21).addBox(-2.0F, 6.0F, -4.0F, 4.0F, 2.0F, 7.0F, 0.0F, false);
		Body.texOffs(0, 33).addBox(-7.0F, -6.0F, -9.0F, 14.0F, 2.0F, 18.0F, 0.0F, false);
		Body.texOffs(64, 33).addBox(-7.0F, -5.0F, 9.0F, 14.0F, 11.0F, 2.0F, 0.0F, false);
		Body.texOffs(0, 53).addBox(-9.0F, -5.0F, -9.0F, 2.0F, 12.0F, 18.0F, 0.0F, false);
		Body.texOffs(40, 53).addBox(7.0F, -5.0F, -9.0F, 2.0F, 12.0F, 18.0F, 0.0F, false);
		Body.texOffs(74, 46).addBox(-9.0F, 7.0F, -5.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		Body.texOffs(72, 83).addBox(-9.0F, 7.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		Body.texOffs(76, 83).addBox(-9.0F, 7.0F, 5.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		Body.texOffs(72, 87).addBox(9.0F, 7.0F, 2.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		Body.texOffs(76, 87).addBox(9.0F, 7.0F, -4.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		Body.texOffs(80, 88).addBox(9.0F, 7.0F, -9.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);

		PlaneTxture_r1 = new ModelRenderer(this);
		PlaneTxture_r1.setPos(0.0F, 0.0F, 0.0F);
		Body.addChild(PlaneTxture_r1);
		setRotationAngle(PlaneTxture_r1, 0.0F, -1.5708F, 0.0F);
		PlaneTxture_r1.texOffs(48, 89).addBox(-10.0F, 7.0F, 4.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		PlaneTxture_r1.texOffs(52, 89).addBox(-10.0F, 7.0F, -3.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		PlaneTxture_r1.texOffs(88, 88).addBox(11.0F, 6.0F, 2.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		PlaneTxture_r1.texOffs(84, 88).addBox(11.0F, 6.0F, -4.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);

		Leg = new ModelRenderer(this);
		Leg.setPos(0.0F, 7.5F, 0.0F);
		Body.addChild(Leg);
		

		FrontLeftLeg = new ModelRenderer(this);
		FrontLeftLeg.setPos(-5.0F, -4.0F, -6.0F);
		Leg.addChild(FrontLeftLeg);
		FrontLeftLeg.texOffs(16, 83).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);

		BackRightLeg = new ModelRenderer(this);
		BackRightLeg.setPos(5.0F, -4.0F, 5.0F);
		Leg.addChild(BackRightLeg);
		BackRightLeg.texOffs(80, 74).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);

		FrontRightLeg = new ModelRenderer(this);
		FrontRightLeg.setPos(5.0F, -4.0F, -6.0F);
		Leg.addChild(FrontRightLeg);
		FrontRightLeg.texOffs(0, 83).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);

		BackLeftLeg = new ModelRenderer(this);
		BackLeftLeg.setPos(-5.0F, -4.0F, 5.0F);
		Leg.addChild(BackLeftLeg);
		BackLeftLeg.texOffs(80, 60).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);

		Queue = new ModelRenderer(this);
		Queue.setPos(0.0F, -2.5F, 10.0F);
		Body.addChild(Queue);
		

		Queue_r1 = new ModelRenderer(this);
		Queue_r1.setPos(0.0F, 0.0F, 0.0F);
		Queue.addChild(Queue_r1);
		setRotationAngle(Queue_r1, 0.0F, 0.0F, 0.0F);
		Queue_r1.texOffs(64, 83).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Neck = new ModelRenderer(this);
		Neck.setPos(0.0F, -4.0F, -6.0F);
		Body.addChild(Neck);
		setRotationAngle(Neck, -0.2182F, 0.0F, 0.0F);
		

		Neck_r1 = new ModelRenderer(this);
		Neck_r1.setPos(0.0F, 2.0F, -0.5F);
		Neck.addChild(Neck_r1);
		setRotationAngle(Neck_r1, 1.0036F, 0.0F, 0.0F);
		Neck_r1.texOffs(80, 46).addBox(-3.0F, -9.5F, -2.5F, 6.0F, 9.0F, 5.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, -3.0F, -7.5F);
		Neck.addChild(Head);
		Head.texOffs(32, 83).addBox(2.0F, -8.5F, -3.5F, 2.0F, 6.0F, 2.0F, -0.001F, false);
		Head.texOffs(40, 83).addBox(-4.0F, -8.5F, -3.5F, 2.0F, 6.0F, 2.0F, -0.001F, false);

		Hair_r1 = new ModelRenderer(this);
		Hair_r1.setPos(-4.0F, 12.178F, -3.8051F);
		Head.addChild(Hair_r1);
		setRotationAngle(Hair_r1, -1.5272F, 0.0F, 0.0F);
		Hair_r1.texOffs(64, 46).addBox(3.0F, 0.0F, -2.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(0.0F, 0.5F, -4.5F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, -0.4363F, 0.0F, 0.0F);
		Head_r1.texOffs(72, 0).addBox(-4.0F, -5.0F, -1.0F, 8.0F, 15.0F, 6.0F, 0.0F, false);

		LeftEar = new ModelRenderer(this);
		LeftEar.setPos(3.0F, -2.5F, -2.5F);
		Head.addChild(LeftEar);
		

		LeftEar_r1 = new ModelRenderer(this);
		LeftEar_r1.setPos(0.0F, 0.0F, 0.0F);
		LeftEar.addChild(LeftEar_r1);
		setRotationAngle(LeftEar_r1, 0.0F, 0.0F, -0.8727F);
		LeftEar_r1.texOffs(48, 83).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		RightEar = new ModelRenderer(this);
		RightEar.setPos(-3.0F, -2.5F, -2.5F);
		Head.addChild(RightEar);
		

		RightEar_r1 = new ModelRenderer(this);
		RightEar_r1.setPos(0.0F, 0.0F, 0.0F);
		RightEar.addChild(RightEar_r1);
		setRotationAngle(RightEar_r1, 0.0F, 0.0F, 0.8727F);
		RightEar_r1.texOffs(56, 83).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		GoatAll.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}