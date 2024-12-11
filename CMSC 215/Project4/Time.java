/* Nicole Marchant
 * Project 4
 * 3/5/2024
 * Comparable time class
 */
package application;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

public class Time implements Comparable<Time>{
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:m a");
	private LocalTime time;
	private int hour;
	private int minute;
	private String meridian;
	
	Time(int hour, int minute, String meridian){
		try {
			
		this.hour = hour;
		this.minute = minute;
		this.meridian = meridian;
		
		this.time = LocalTime.parse(
				String.format("%d:%d %s", this.hour, this.minute, this.meridian), 
				this.formatter);
		}
		catch(Exception e) {
			try {
				throw new InvalidTime(e.getMessage());
			}
			catch(Exception d){
				
			}
		}
	}
	Time(String timeString){
		try {
			//System.out.println(timeString);
			this.time = LocalTime.parse(timeString, this.formatter);
			
			this.hour = time.getHour();
			this.minute = time.getMinute();
			
			if(this.hour > 11) {
				this.meridian = "PM";
			}
			else {
				this.meridian = "AM";
			}
		}
		catch(Exception e) {
			try {
				throw new InvalidTime(e.getMessage());
			}
			catch(Exception d){
				
			}
		}
	}
	@Override
	public int compareTo(Time o) {
		// TODO Auto-generated method stub
		return this.time.compareTo(o.time);
	}
	@Override
	public String toString() {
		int hr = hour;
		if(hr > 12 ) {
			hr-=12;
		}
		if(hr == 0) {
			hr += 12;
		}
		return String.format("%02d:%02d %s", hr, minute, meridian);
	}
}

