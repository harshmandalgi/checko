import java.io.*;
import java.util.Scanner;
import static java.lang.System.out;

public class c_and_r{

public static void main(String args[])
{
	Scanner d=new Scanner(System.in);
try
	{
		out.println("Enter the filename without extension(should be in home directory and also the filename and name of main class should be same):");
		String a=d.next();
		out.println("Compiling file....");
		runP("javac -cp src "+a+".java");
		out.println("Running fule....");
		runP("java "+a);
   }catch(Exception e){out.println(e.getMessage());}
	}


	private static void printLines(String cmd, InputStream ins) throws Exception {
			String line = null;
			BufferedReader in = new BufferedReader(
					new InputStreamReader(ins));
			while ((line = in.readLine()) != null) {
					System.out.println(cmd + " " + line);
			}
		}

		private static void runP(String command) throws Exception {
			Process pro = Runtime.getRuntime().exec(command);
			printLines(command + " stdout:", pro.getInputStream());
			printLines(command + " stderr:", pro.getErrorStream());
			pro.waitFor();
			System.out.println(command + " exitValue() " + pro.exitValue());
		}

}
