/* Nicole Marchant
 * Project 2
 * 2/5/2024
 * Class that houses data to determine eligibility for honor society.
 */
public class Student {
	private String name;
	private int creditHours;
	private int qualityPoints;
	private static double gpaThreshold;
	
	Student(String name, int credits, int quality){
		this.name = name;
		this.creditHours = credits;
		this.qualityPoints = quality;
		setGpaThreshold(4.0);
	}
	
	public String getName() {
		return name;
	}
	
	public double gpa(){
		return this.qualityPoints/this.creditHours;
	}
	public boolean eligibleForHonorSociety() {
		return gpaThreshold <= gpa();
	}
	public static void setGpaThreshold(double newGpaThreshold) {
		gpaThreshold = newGpaThreshold;
	}
	public String toString(){
		return String.format("%s %.2f", this.name, gpa());
	}
}
