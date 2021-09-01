package design;

import algorithm.Sort;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class EmployeeInfo  extends AbstractEmployee{

    /*
    This class should implement the Employee interface. You can do that by directly implementing it, however you must
        also implement the Employee interface into an abstract class. So create an Abstract class then inherit that
        abstract class into this EmployeeInfo class. Once you're done with designing EmployeeInfo class,
        go to FortuneEmployee class to apply all the fields and attributes.

    Important: YOU MUST USE:
        - OOP (Abstraction, Encapsulation, Inheritance and Polymorphism) concepts in every level possible.
        - Use all kind of keywords (super, this, static, final, etc)
        - Implement nested class below (DateConversion)
        - Use Exception Handling
     */

    /*
     * Make sure to declare and use static, non-static & final fields
     */
    final String  COMPANYNAME = "Apple";
    Scanner sc = new Scanner(System.in);
    /*
     You must implement the logic for below 2 methods and
        following 2 methods are prototype as well for other methods need to be design,
        as you will come up with the new ideas.
     */

    /*
     You must have/use multiple constructors
     */
    public EmployeeInfo(int employeeId) {

    }

    public EmployeeInfo(String name, int employeeId) {

    }
   public  void startService(){
       System.out.println("********************************* \n    Employee Service   \n******************************");
       employeeName();
       employeeId();
       System.out.println(" 1: Calculate Salary \n 2: Calculate Pension \n 3: Apply For Vacation \n 4: Join Training \n 5:Calculate Employee Bonus \n 6: View Benefits \n Select Action");
       int num = sc.nextInt();
       if(num == 1){
           System.out.println(calculateSalary());
           //startService();
       }
       if(num == 2){
           System.out.println(calculateEmployeePension());
          // startService();
       }
       if(num == 3){
        applyForVacation();
         //  startService();
       }
       if(num == 4){
         joinTraining();
          /// startService();
       }
       if(num == 5){
           System.out.println(calculateEmployeeBonus());
           //startService();
       }
       if(num == 6){
         benefitLayout();
       }else {
           System.out.println("Enter Number between 1-6");
            num = sc.nextInt();
       }
       startService();

   }

    //employeeId() will return employee id.
    @Override
    public int employeeId(){
        System.out.println(" ENTER Your Employee ID: " );
        int id =0;
        try {
           id = sc.nextInt();
        }catch (Exception ex){
            System.out.println("Enter Your Employee ID(number)");
        }

        return id;
    }


    //employeeName() will return employee name

    @Override
    public String   employeeName(){
        System.out.println(" Please Enter Your Name: ");
        String name = sc.next();
        return name;

    }

    //assignDepartment() will assign employee to departments
    @Override
    public void assignDepartment(){
        System.out.println("Select department 1: IT \n 2: Accounts \n 3: HR \n 4: Management");
        int num = sc.nextInt();
        if(num ==1)
            System.out.println("IT");
        else if(num ==2)
            System.out.println("Accounts");
       else if(num ==3)
            System.out.println("Hr");
       else if(num ==4)
            System.out.println("Management");
    }

    //calculate employee salary
    @Override
    public int calculateSalary(){
        System.out.println(" ENTER base SALARY: ");
        int baseSalary = sc.nextInt();
        double  commission = baseSalary*(10/100);
        return (int) (baseSalary+commission);
    }

    //employee benefit
    @Override
    public void benefitLayout(){
        System.out.println("Select benefits 1: Travel \n 2: Health \n 3: Pension \n 4: Food");
        int num = sc.nextInt();
        if(num ==1)
            System.out.println("Travel");
        else if(num ==2)
            System.out.println("Health");
        else if(num ==3)
            System.out.println("Pension");
        else if(num ==4)
            System.out.println("Food");
    }


    public void joinTraining(){
        System.out.println("Select training to join 1: Management \n 2: Software Development ");
        int num = sc.nextInt();
        if(num ==1)
            System.out.println("Management");
        else if(num ==2)
            System.out.println("Software Development");

    }

    public void applyForVacation(){
        System.out.println("Enter for how many days you want vacation: ");
        int days = sc.nextInt();
        if(days <2 ){
            System.out.println("Please Wait for approval");
        }else {
            System.out.println("Talk to authorities");
        }


    }


    /*
     You need to implement the logic of this method as such:
        It should calculate Employee bonus based on salary and performance.
        It should return the total yearly bonus.
            Example: 10% of salary for best performance, 8% of salary for average performance and so on.
            You can set arbitrary number for performance, so you probably need to send 2 arguments.
     *
     */
    public  int calculateEmployeeBonus() {
        System.out.println("Enter Performance score: ");
        Scanner sc = new Scanner(System.in);
        int performanceScore = sc.nextInt();
        int salary = calculateSalary();
        int total = 0;
        double employeeBonus =0.0;
        System.out.println("Enter number of your job years: ");
        int numberOfYearsWithCompany =sc.nextInt();
        if(numberOfYearsWithCompany >=1){
            if(performanceScore <=100 & performanceScore >= 90){
                employeeBonus = salary* 0.1;

            }
            else if(performanceScore <= 89 & performanceScore >= 70){
                employeeBonus = salary * 0.08;
            }
            else if(performanceScore <= 69 & performanceScore >= 50){
                employeeBonus = salary * .05;
            }
        }
        else {
            employeeBonus = 0.0;
        }

        total = salary + (int) employeeBonus;
        return total;

    }

    /*
     You need to implement the logic of this method as such:
        It should calculate Employee pension based on salary and numbers of years with the company.
        It should return the total pension amount.
            Example: Employee will receive 5% of salary as pension for every year they are with the company
     *
     */
    public  int calculateEmployeePension() {
        int total = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter start date in format (example: May,2015): ");
        String joiningDate = sc.nextLine();
        System.out.println("Please enter today's date in format (example: August,2017): ");
        String todaysDate = sc.nextLine();
        String convertedJoiningDate = DateConversion.convertDate(joiningDate);
        String convertedTodaysDate = DateConversion.convertDate(todaysDate);
        String[] dateArrayJoin = convertedJoiningDate.split(",");
        String[] dateArrayToday =convertedTodaysDate.split(",");


        // Figure out how to extract the number of years the employee has been with the company, using the above 2 dates
        int year = Integer.parseInt(dateArrayToday[1])- Integer.parseInt(dateArrayJoin[1]);
        // Calculate pension

        double pension = calculateSalary()* 0.05  * year;
        total = calculateSalary() + (int)pension;
        return total;
    }

    private static class DateConversion {

        public DateConversion(Months months) {
        }

        public static String convertDate(String date) {
            String[] extractMonth = date.split(",");
            String givenMonth = extractMonth[0];
            int monthDate = whichMonth(givenMonth);
            String actualDate = monthDate + "/" + extractMonth[1];
            return actualDate;
        }

        public static int whichMonth(String givenMonth) {
            Months months = Months.valueOf(givenMonth);
            int date = 0;
            switch (months) {
                case January:
                    date = 1;
                    break;
                case February:
                    date = 2;
                    break;
                case March:
                    date = 3;
                    break;
                case April:
                    date = 4;
                    break;
                case May:
                    date = 5;
                    break;
                case June:
                    date = 6;
                    break;
                case July:
                    date = 1;
                    break;
                case August:
                    date = 1;
                    break;
                case September:
                    date = 1;
                    break;
                case October:
                    date = 1;
                    break;
                case November:
                    date = 1;
                    break;
                case December:
                    date = 1;
                    break;
                default:
                    date = 0;
                    break;
            }
            return date;

        }
    }
}
