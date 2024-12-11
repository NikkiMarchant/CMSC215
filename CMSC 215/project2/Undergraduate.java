/* Nicole Marchant
 * Project 2
 * 2/5/2024
 * Class that houses data to determine eligibility for honor society.
 */
public class Undergraduate extends Student {
	private String year;
	
	public Undergraduate(String name, int credits, int quality, String year) {
		super(name, credits, quality);
		this.year = year;
	}
	
	@Override
	public boolean eligibleForHonorSociety() {
		boolean eligible = false;
		if(super.eligibleForHonorSociety()) {
			if(this.year.compareToIgnoreCase("junior") == 0 || this.year.compareToIgnoreCase("senior") == 0) {
				eligible = true;
			}
		}
		return eligible;
	}
	@Override
	public String toString(){
		return String.format("%s, %.2f, %s", getName(), gpa(), year);
	}

}
