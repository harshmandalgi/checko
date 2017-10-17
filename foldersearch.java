import java.util.Scanner;
import java.io.File;
class A
{
public static void main(String args[])

{
Scanner d=new Scanner(System.in);
try{
System.out.println("Enter the path of that folder from the home directory: ");
			String path=d.nextLine();
			
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();

      for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        System.out.println("File " + listOfFiles[i]);
      } else if (listOfFiles[i].isDirectory()) {
        System.out.println("Directory " + listOfFiles[i].getName());
      }
      }
}catch(Exception e){System.out.println(e.getMessage());}


}


}
