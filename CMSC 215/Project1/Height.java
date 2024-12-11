/* Nicole Marchant
 * Project 1
 * 1/22/2024
 * Class that stores height for Player Class.
 */
public class Height {
	int feet;
	int inches;
	
	Height(int feet, int inches){
		this.feet = feet;
		this.inches = inches;
	}
	
	public int toInches(){
		return (this.feet*12)+this.inches; 
	}
	public String toString(){
		return String.format("%d feet, %d inches", this.feet, this.inches);
	}
}
