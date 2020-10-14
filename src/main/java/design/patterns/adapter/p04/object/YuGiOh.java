package design.patterns.adapter.p04.object;

import java.lang.reflect.Method;

/**
 * YU-GI-OH(游戏王) is a wrapper(or a adapter?)
 */
public class YuGiOh implements ExodiaTheForbiddenOne {

	RightArmOfTheForbiddenOne rightArm;

	LeftArmOfTheForbiddenOne leftArm;

	RightLegOfTheForbiddenOne rightLeg;

	LeftLegOfTheForbiddenOne leftLeg;

	public YuGiOh(RightArmOfTheForbiddenOne rightArm, LeftArmOfTheForbiddenOne leftArm,
			RightLegOfTheForbiddenOne rightLeg, LeftLegOfTheForbiddenOne leftLeg) {
		super();
		this.rightArm = rightArm;
		this.leftArm = leftArm;
		this.rightLeg = rightLeg;
		this.leftLeg = leftLeg;
	}

	@Override
	public String rightArm() {
		return rightArm.rightArm();
	}

	@Override
	public String leftArm() {
		return leftArm.leftArm();
	}

	@Override
	public String rightLeg() {
		return rightLeg.rightLeg();
	}

	@Override
	public String leftLeg() {
		return leftLeg.leftLeg();
	}

	@Override
	public void unforbidden() {
		try {
			String[] limbs = new String[] { "rightArm", "leftArm", "rightLeg", "leftLeg" };
			for (String limb : limbs) {
				Method method = getClass().getMethod(limb);
				if (!limb.equals(String.valueOf(method.invoke(this)))) {
					throw new Exception();
				}
			}
			System.out.println("Exodia is unforbidden");
		} catch (Exception e) {
			System.out.println("Exodia is still forbidden");
		}
	}

}
