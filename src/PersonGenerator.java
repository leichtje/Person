import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {

        ArrayList<Person> persons = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        boolean done = false;

        String record = "";
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;
        String fileName = "";
        Person per;

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the ID of the person [6 Digits]" );
            firstName = SafeInput.getNonZeroLenString(in, "Enter the person's first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter the person's last name");
            title = SafeInput.getNonZeroLenString(in, "Enter the person's title");
            YOB = SafeInput.getRangedInt(in,"Enter the person's year of birth", 1940,2000);

            per = new Person(ID, firstName, lastName, title, YOB);
            persons.add(per);

            done = SafeInput.getYNConfirm(in, "Do you have any more records?");

        }while(done);

        //for( Person f: persons)
            //System.out.println(f);


        fileName = SafeInput.getNonZeroLenString(in, "What do you want to name your file?");
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "//src//" + fileName + ".txt");

        try{
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file,CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            String n;
            for (Person rec: persons){
                n = rec.toCSVDataRecord();
                System.out.println(n);
                writer.write(n,0,n.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data has been successfully written");

        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
