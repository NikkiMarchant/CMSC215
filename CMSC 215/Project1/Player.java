/* Nicole Marchant
 * Project 1
 * 1/22/2024
 * Class to store and retrieve name, height, and age of players for Project1. 
 */
public class Player {
	String name;
	Height height;
	int age;
	
	Player(String name, Height height, int age){
		this.name = name;
		this.height = height;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	public Height getHeight() {
		return this.height;
	}
	public int getAge() {
		return this.age;
	}
	
	public String toString(){
		return String.format("%s, Height: %s Age: %d", this.name, this.height.toString(), this.age);
	}
}
