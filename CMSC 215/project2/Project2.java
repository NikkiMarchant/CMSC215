/* Nicole Marchant
 * Project 2
 * 2/5/2024
 * Description
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;

public class Project2 {

	public static void main(String[] args) {
		try {
			Scanner fileReader = new Scanner(new File("students.txt"));
			ArrayList<Student> studentArray = new ArrayList<>();
			double gpaThreshold = 0;
			
			while (fileReader.hasNextLine()) {
				String name = fileReader.next();
				int creditHours = fileReader.nextInt();
				int qualityPoints = fileReader.nextInt();
				String type = fileReader.next();
				switch(type.toLowerCase()) {
					case "freshman":
					case "junior":
					case "sophomore":
					case "senior":
						studentArray.add(new Undergraduate(name, creditHours, qualityPoints, type));
						gpaThreshold += qualityPoints/creditHours;
						continue;
					case "masters":
					case "doctorates":
						studentArray.add(new Graduate(name, creditHours, qualityPoints, type));
						gpaThreshold += qualityPoints/creditHours;
						continue;
					default:
						continue;
				}
			}
			gpaThreshold /= studentArray.size(); // set gpaThreshold to average
			gpaThreshold += 4;
			gpaThreshold /= 2;					 // set gpaThreshold to midpoint between average and 4.0
			Student.setGpaThreshold(gpaThreshold);
			
			Iterator<Student> studentIterator = studentArray.iterator();
			Student currentStudent;
			
			while(studentIterator.hasNext()) {
				currentStudent = studentIterator.next();
				if(currentStudent.eligibleForHonorSociety()) {
					System.out.println(currentStudent);
				}
			}
			
			fileReader.close();
		} catch (java.io.FileNotFoundException e) {
			System.out.printf("Error: %s\n", e.getMessage());;
			System.exit(1);
		} catch (java.util.NoSuchElementException e){
			System.out.print("Error: No Element\n");
			System.exit(1);
		} catch (java.lang.ArithmeticException e) {
			System.out.printf("Error: %s\n", e.getMessage());
			System.exit(1);
		} catch (Exception e) {
			System.out.printf("Error: %s\n", e.getMessage());
			System.exit(1);
		}
	}
}
