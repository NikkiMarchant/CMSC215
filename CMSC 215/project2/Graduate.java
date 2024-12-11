/* Nicole Marchant
 * Project 2
 * 2/5/2024
 * Description
 */
public class Graduate extends Student {
	private String degreeType;
	
	public Graduate(String name, int credits, int quality, String degreeType) {
		super(name, credits, quality);
		this.degreeType = degreeType;
	}
	@Override
	public boolean eligibleForHonorSociety() {
		boolean eligible = false;
		if(super.eligibleForHonorSociety()) {
			if(this.degreeType.toLowerCase().contains("master")) {
				eligible = true;
			}
		}
		return eligible;
	}
	@Override
	public String toString(){
		return String.format("%s, %.2f, %s", getName(), gpa(), degreeType);
	}
}
