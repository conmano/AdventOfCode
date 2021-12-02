package puzzle2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws FileNotFoundException  {
		String direction = "";
		int amt = 0;
		int forward = 0;
		int aim = 0;
		int depth = 0;
		Scanner sc = new Scanner(new File("inputs2"));
		while(sc.hasNextLine()) {
			while(sc.hasNext()) {
				direction = sc.next();
				if("forward".equals(direction)){
					amt = sc.nextInt();
					forward += amt;
					depth += amt * aim;
				}
				else if("down".equals(direction)) {
					aim += sc.nextInt();
				}
				else if("up".equals(direction)) {
					aim -= sc.nextInt();
				}
				else {
					break;
				}
			}
		}
		
		System.out.println("Forward = " + forward + "; Height = " + depth + "; Answer = " + (forward * depth));
		
	}

}
