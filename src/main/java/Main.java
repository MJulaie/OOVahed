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
            System.out.println("Hi, please enter your student number: ");
            input = sc.nextLine();

            StudentRepository studentRepository = StudentRepository.getInstance();
            Student currentStudent = studentRepository.getStudentByStudentNumber(Integer.parseInt(input));
//            Student currentStudent = studentRepository.getStudentByID(9012901);


            System.out.println(Integer.parseInt(input));

            boolean quit = false;
            if (currentStudent != null) {
                while (!quit){
                    System.out.println("Hi  " + currentStudent.getName() + "   " + currentStudent.getLastName() + "  :)");
                    VahedProcess vahedProcess = new VahedProcess(currentStudent);
                    while (!quit) {
                        vahedProcess.printOptions();

                        System.out.println();
                        System.out.println("Your current barnameh : ");
                        vahedProcess.printCurrentBarnameh();


                        System.out.println("Please enter your action :");

                        System.out.println("r : Remove option");
                        System.out.println("a : Add option");
                        System.out.println("v : Validate barnameh");
                        System.out.println("c : Confirm barnameh");
                        System.out.println("q : Quit");
                        System.out.println();

                        input = sc.nextLine();
                        switch (input.charAt(0)) {
                            case 'v':
                                if (vahedProcess.validateBarnameh()){
                                    System.out.println("Your barnameh is OK!!");
                                } else {
                                    System .out.println("Your barnameh is not ok :(");
                                }
                                break;
                            case 'c':
                                if (vahedProcess.validateBarnameh()){
                                    vahedProcess.confirmBarnameh();
                                    System.out.println("Your barnameh is confirmed!!");
                                } else {
                                    System.out.println("Your barnameh is not ok :(");
                                }
                                break;


                            case 'a':
                                System.out.println("Please enter the course index for add:");
                                input = sc.nextLine();
                                vahedProcess.addOption(Integer.parseInt(input));
                                break;
                            case 'r':
                                System.out.println("Please enter the course index for remove:");
                                input = sc.nextLine();
                                vahedProcess.removeOption(Integer.parseInt(input));
                                break;
                            case 'q':
                                vahedProcess.reverseCapacity();
                                quit = true;
                                break;
                        }

                    }
                    System.out.println();
                    System.out.println();
                    break;

                }
            } else {
                System.out.println("ID is not correct! please try again!");
                continue;
            }
        }
    }
}
