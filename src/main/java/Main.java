import org.joda.time.*;

import java.util.*;

/**
 * Created by Ali on 5/18/2017 AD.
 */

public class Main {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;
        while (true){
            System.out.println("Hi, please enter your ID: ");
//            input = sc.nextLine();

            StudentRepository studentRepository = StudentRepository.getInstance();
//            Student currentStudent = studentRepository.getStudentByID(Integer.parseInt(input));
            Student currentStudent = studentRepository.getStudentByID(9012901);


//            System.out.println(Integer.parseInt(input));

            if (currentStudent != null) {
                while (true){
                    System.out.println("Hi, " + currentStudent.getName() + "  " + currentStudent.getLastName());

                    while (true) {
                        VahedProcess vahedProcess = new VahedProcess(currentStudent);
                        vahedProcess.printOptions();

                        System.out.println();
                        System.out.println("Your current barnameh : ");
                        vahedProcess.printCurrentBarnameh();


                        System.out.println("barnameh size: " + vahedProcess.getSize());
                        System.out.println();
                        System.out.println("Please enter the course index:");
                        input = sc.nextLine();

                        vahedProcess.addOption(Integer.parseInt(input));

                        if (input == "q")
                            break;
                    }

                    break;

                }
            } else {
                System.out.println("ID is not correct! please try again!");
                continue;
            }

        }




    }
}
