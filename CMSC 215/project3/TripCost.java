/* Nicole Marchant
 * Project 3
 * 2/20/2024
 * TripCost class for calculating Project3 cost.
 */
package application;

public class TripCost {
	private double gasCostTotal;
	private double miscTotal;

	TripCost(){
		gasCostTotal = 0;
		miscTotal = 0;
	}
	
	public void setTripCost(double gasCost,
							double distance,
							double mileage,
							double attractions,
							double hotel,
							double food,
							int days) {
		this.gasCostTotal = (distance/mileage)*gasCost;
		this.miscTotal = attractions + (hotel + food) * days;
	}
	
	public double getTotal() {
		return this.gasCostTotal + this.miscTotal;
	}
	
	public String toString(){
		return String.format("$%.2f", getTotal());
	}
}
