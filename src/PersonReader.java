import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec;
        ArrayList<Person> persons = new ArrayList<>();
        Person per;

        String headerOne = "ID#";
        String headerTwo = "FirstName";
        String headerThree = "LastName";
        String headerFour = "Title";
        String headerFive = "YOB";
        String divisor = "======================================================================";

        String record = "";
        String id = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int yob = 0;

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));


                System.out.printf("%-8s%-25s%-25s%-6s%6s", headerOne, headerTwo, headerThree, headerFour, headerFive);
                System.out.printf("\n");
                System.out.println(divisor);


                while(reader.ready())
                {
                    rec = reader.readLine();

                    String[] data = rec.split(", ");
                    persons.add(new Person(data[0],data[1],data[2],data[3],Integer.parseInt(data[4])));

                    System.out.printf("%-8s" , data[0]);
                    System.out.printf("%-25s" , data[1]);
                    System.out.printf("%-25s" , data[2]);
                    System.out.printf("%-8s" , data[3]);
                    System.out.printf("%-6s",data[4]);
                    System.out.printf("\n");
                }
                reader.close();
                System.out.println("\n\nData file read!");
            }
            else
            {
                System.out.println("Failed to choose a file to process");
                System.out.println("Run the program again!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found!!!");
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
