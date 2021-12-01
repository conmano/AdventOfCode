package puzzle1;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) throws IOException {
		try {
			FileInputStream fstream = new FileInputStream("inputs");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			int lineNumber = 1;
			
			while(br.readLine() != null)
				lineNumber++;
			
			fstream.getChannel().position(0);
			
			br = new BufferedReader(new InputStreamReader(fstream));
			lineNumber--;
			int [] values = new int[lineNumber];
			lineNumber = 0;
			
			while((strLine = br.readLine()) != null && lineNumber < values.length) {
				values[lineNumber] = Integer.parseInt(strLine);
				lineNumber++;
			}
			
			br.close();
			
			lineNumber = 3;
			int firstNum = 0;
			int secondNum = 1;
			int thirdNum = 2;
			int ans = 0;
			
			while(lineNumber < values.length) {
				if((values[firstNum] + values[secondNum] + values[thirdNum]) < (values[firstNum + 1] + values[secondNum + 1] + values[thirdNum + 1]))
					ans++;
				firstNum++;
				secondNum++;
				thirdNum++;
				lineNumber++;
			}
			
			System.out.println(ans);
			
		} catch (FileNotFoundException e) {
			System.out.println("whoops");
			e.printStackTrace();
		}

	}

}
