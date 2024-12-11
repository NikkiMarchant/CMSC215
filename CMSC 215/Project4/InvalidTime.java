/* Nicole Marchant
 * Project 4
 * 3/5/2024
 * Custom time error
 */
package application;

@SuppressWarnings("serial")
public class InvalidTime extends Exception {
	InvalidTime(String message) {
		super(message);
	}

}
