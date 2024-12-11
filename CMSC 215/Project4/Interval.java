/* Nicole Marchant
 * Project 4
 * 3/5/2024
 * Comparable interval class
 */
package application;

public class Interval<T extends Comparable<T>> {
	Time start;
	Time end;
	
	Interval(Time start, Time end){
		this.start = start;
		this.end = end;
	}
	
	public boolean within(Interval<T> o) {
		try {
			if(o.start.compareTo(this.start) >= 1 && o.end.compareTo(this.end) <= 1) {
				return true;
			}
		}
		catch(Exception e) {
			
		}
		return false;
	}
	
	public boolean within(Time o) {
		try {
			if(o.compareTo(this.start) >= 0 && o.compareTo(this.end) <= 0) {
				return true;
			}
		}
		catch(Exception e) {
			
		}
		return false;
	}
	public boolean subinterval(Interval<T> i){
		try {
			if(this.start.compareTo(i.start)<=0 && this.end.compareTo(i.end)>=0) {
				return true;
			}
		}
		catch(Exception e) {
			
		}
		return false;
	}
	public boolean overlaps(Interval<T> i) {
		try {
			if(this.start.compareTo(i.start)>=0 && this.start.compareTo(i.end) <=0 ||
					this.end.compareTo(i.start)>=0 && this.end.compareTo(i.end) <=0 ) {
				return true;
			}
		}
		catch(Exception e) {
			
		}
		return false;
	}
}
