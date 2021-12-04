package puzzle3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("inputs3"));
		String curStr = "";
		double ans = 0;
		int count = 0;
		int cur = 0;
		int nextNum = 0;
		double numsLeft = 1000;
		String curChar = "";
		double gamma = 0;
		double epsilon = 0;
		double oxygen = 0;
		double co = 0;
		int[] values = new int[12];
		String[] binary = new String[1000];
		String[] binary2 = new String[1000];
		for(int i = 0; i < 12; i++) {
			values[i] = 0;
		}
		
		while(sc.hasNext()) {
			binary[count] = sc.next();
			binary2[count] = binary[count];
			for(int i = 0; i < 12; i++) {
				if(binary[count].charAt(i) == '1') {
					values[i] += 1;
				}
			}
			count++;
		}
		/*
		for(int i = 0; i < 12; i++) {
			System.out.println(values[i]);
		}
		System.out.println(count);
		*/
		
		count = count / 2;
		
		for(int i = 0; i < 12; i++) {
			if(values[i] > count) {
				values[i] = 1;
			}
			else {
				values[i] = 0;
			}
		}
		
		/*
		for(int i = 0; i < 12; i++) {
			if(values[i] == 1) {
				gamma += Math.pow(2, 11 - i);
			}
			else {
				epsilon += Math.pow(2, 11 - i);
			}
		}
		
		ans = gamma * epsilon;
		*/
		
		count = 0;
		while(numsLeft!=1 && numsLeft > 0 && cur < 12) {
			if(binary[count] != "-1") {
				curChar = String.valueOf(binary[count].charAt(cur));
				if(Integer.parseInt(curChar) != values[cur]) {
					binary[count] = "-1";
					numsLeft--;
				}
				else {
					if(cur + 1 < 12) {
						if(binary[count].charAt(cur+1) == '1') {
							nextNum += 1;
						}
					}
				}
			}
			count++;
			if(count == 1000) {
				if(cur + 1 < 12) {
					if(nextNum >= (numsLeft / 2)) {
						values[cur+1] = 1;
					}
					else {
						values[cur+1] = 0;
					}
				}
				nextNum = 0;
				count = 0;
				cur++;
			}
		}
		
		numsLeft = 1000;
		nextNum = 0;
		count = 0;
		cur = 0;
		while(numsLeft!=1 && numsLeft > 0 && cur < 12) {
			if(binary2[count] != "-1") {
				curChar = String.valueOf(binary2[count].charAt(cur));
				if(Integer.parseInt(curChar) == values[cur]) {
					binary2[count] = "-1";
					numsLeft--;
				}
				else {
					if(cur + 1 < 12) {
						if(binary2[count].charAt(cur+1) == '1') {
							nextNum += 1;
						}
					}
				}
			}
			count++;
			if(count == 1000) {
				if(cur + 1 < 12) {
					if(nextNum >= (numsLeft / 2)) {
						values[cur+1] = 1;
					}
					else {
						values[cur+1] = 0;
					}
				}
				nextNum = 0;
				count = 0;
				cur++;
			}
		}
		
		count = 0;
		while(binary[count] == "-1" && count < 1000) {
			count++;
		}
		
		
		for(int i = 0; i < 12; i++) {
			if(binary[count].charAt(i) == '1') {
				oxygen += Math.pow(2, 11 - i);
			}
		}
		
		count = 0;
		while(binary2[count] == "-1" && count < 1000) {
			count++;
		}
		
		for(int i = 0; i < 12; i++) {
			if(binary2[count].charAt(i) == '1') {
				co += Math.pow(2, 11 - i);
			}
		}
		
		sc.close();
		
		ans = oxygen * co;
		System.out.println(ans);

		
	}

}
