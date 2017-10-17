//date: 14/10/2017

import java.io.*;
import java.util.Scanner;
import static java.lang.System.out;

public class c_and_r{

public static void main(String args[])
{
	Scanner d=new Scanner(System.in);
try
	{
		//menu
		out.println("---------------------------------------------\n\nMENU ");
		int ch1=0,ch2=0;
		out.println("1. Check single file \n2. Check multiple files");
		ch1=d.nextInt();
		out.println("Provide runtime arguments? If yes, enter 1: ");
		ch2=d.nextInt();

		//runtime args
		String run_args=null;
		if(ch2==1)
		{
				out.println("Enter arguments : ");
				run_args=d.nextLine();
				run_args=d.nextLine();
		}

		//multiple file execution
		if(ch1==2){ multi_file(run_args); }

		//single file execution
		if(ch1==1){
		out.println("\nEnter the filename without extension(should be in home directory and also the filename and name of main class should be same):");
		String a=d.next();
		out.println("Compiling file....");
		runP("javac -cp src "+a+".java");
		out.println("Running file....");
		runP("java "+a+" "+run_args);
		}
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

		//multiple file execution
		private static void multi_file(String args) throws Exception
		{
			Scanner d=new Scanner(System.in);
			out.println("\nStore all the files in a single folder.");
			out.println("Enter the folder name: ");
			String foldername=d.nextLine();
			out.println("Enter the path of that folder from the home directory: ");
			String path=d.nextLine();

			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();

      for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        System.out.println("File " + listOfFiles[i].getName());
      } else if (listOfFiles[i].isDirectory()) {
        System.out.println("Directory " + listOfFiles[i].getName());
      }
      }

			out.println("\nEnter time in seconds to wait after each execution: ");
			int time=d.nextInt();
			out.println("Press any key and hit enter to start.....");
			String ok=d.next();


			for(int i=0;i<listOfFiles.length;i++){
			if(!listOfFiles[i].getName().contains(".java")){continue;}
			out.println("\n\nCompiling file: "+listOfFiles[i].getName());
			runP("javac -cp src "+foldername+"/"+listOfFiles[i].getName());
			out.println("Running file....");

			String execfile=foldername+" "+listOfFiles[i].getName();
			runP("java -cp "+execfile.replace(".java","")+" "+args);
 		  Thread.sleep(time*1000);

					}



		}
}
