package parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;

import databases.ConnectToSqlDB;
import databases.User;
import org.xml.sax.SAXException;


public class ProcessStudentInfo {

    /*
     * Under XmlReader class, the parseData() will return list of Student Info which will contain Student first name, last name and score.
     * You need to implement the method name "convertIntToChar()" which will convert String score into char Grade.('A'for 90 to 100,'B'for 80 to 89 and
     * 'C' for 70 to 79.
     *
     * Here in the main method fill in the code that outlined to read xml data parsed into 2 separate ArrayList, then store into map.
     * Once map has all data, retrieve those data and out put to console.
     *
     * Do any necessary steps that require for below successful output.
     * ......................................................
     * Student (id= 1) "Ibrahim" "Khan"        		Grade= B
     * Student (id= 2) "Asif" "Roni"          		Grade= A
     * Student (id= 3) "Gumani" "Hose"              Grade= A
     * Student (id= 4) "Sukanto" "Shaha"            Grade= B
     * Student (id= 5) "MD" "Hossain"               Grade= C
     * ......................................................
     *
     *
     * Use any databases[MongoDB, Oracle or MySql] to store data and to retrieve data.
     *
     */

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, SQLException, ClassNotFoundException {
        // Path of XML data to be read.
        String pathSelenium = System.getProperty("user.dir") + "/src/parser/selenium.xml";
        String pathQtp = System.getProperty("user.dir") + "/src/parser/qtp.xml";
        String tag = "id";

        //Declare a Map with List<String> into it.
        Map<String, List<Student>> list = new LinkedHashMap<String, List<Student>>();
        Map<String, List<Student>> listQTP = new LinkedHashMap<String, List<Student>>();

        /*
        Declare 2 ArrayList, accepting Student datatype, which you will use to store students from the Selenium class
            into one list, and students from the QTP class into another list

        */
        List<Student> seleniumStudents = new ArrayList<Student>();
        List<Student> qtpStudents = new ArrayList<Student>();

        // Create XMLReader object.
        XmlReader xmlReader = new XmlReader();

        // Parse Data using parseData method and then store data into Selenium ArrayList.
        seleniumStudents = xmlReader.parseData(tag, pathSelenium);

        // Parse Data using parseData method and then store data into QTP ArrayList.
        qtpStudents = xmlReader.parseData(tag,pathQtp);

        // Add Selenium ArrayList data into map.

        list.put("1",seleniumStudents);

        // Add Qtp ArrayList data into map.
        listQTP.put("2",qtpStudents);

        // Retrieve map data and display output for both maps.

        List<Student> stList = new ArrayList<>();

//        for (Student st : list) {
//            System.out.println(st.getFirstName() + " " + st.getLastName() + " " + st.getScore() + " " + st.getId());
//        }


        list.forEach((key, value) ->{
            System.out.println("......................Selenium Students...............................");

            for(int i =0;i<value.size();i++){
                System.out.println(value.get(i));
            }
            System.out.println(".......................................................................");

        });

        listQTP.forEach((key, value) ->{
            System.out.println(".......................QTP Students....................................");

            for(int i =0;i<value.size();i++){
                System.out.println(value.get(i));
            }
            System.out.println(".......................................................................");

        });


        /*****************************************************************************Database Work ****************************************************************/

        int i = 0;
        System.out.println("**************  Result From Database  ***************");
        for(Student st: seleniumStudents) {

            int id = Integer.parseInt(st.id);
            String firstName = st.getFirstName();
            String lastName = st.getLastName();
            String score = st.getScore();
            i = sqlQuery(id,firstName,lastName,score,i);

        }

        for(Student st: qtpStudents) {

            int id = Integer.parseInt(st.id);
            String firstName = st.getFirstName();
            String lastName = st.getLastName();
            String score = st.getScore();

            sqlQuery(id,firstName,lastName,score, i);
        }

        sqlQueryDDL();
    }

    // DDL query function
    private static int sqlQuery(int id, String firstName, String lastName, String score,int i) {
          PreparedStatement ps = null;
          String tableName = "process_student_info";

          ConnectToSqlDB dbConnectionObj = new ConnectToSqlDB();


        try {
            Connection conn = dbConnectionObj.connectToSqlDatabase();

            if(i<=0){
                ps = conn.prepareStatement("DROP TABLE IF EXISTS `" + "process_student_info" + "`;");
                ps.executeUpdate();
                String tableCreateQuery = "CREATE TABLE process_student_info " +
                        "(studentID INTEGER not NULL, " +
                        " firstName VARCHAR(255) not NULL, " +
                        " lastName VARCHAR(255) not NULL , " +
                        " score VARCHAR(255) not NULL)";
                ps.executeUpdate(tableCreateQuery);
            }
           i++;

            //******************* Insert Query ************//
            String queryInsert ="INSERT INTO `test_schema_1`.`process_student_info`(studentID,firstName,lastName,score) Values (?,?,?,?)";
            PreparedStatement sq = conn.prepareStatement(queryInsert);//DML
            sq.setInt(1,id);
            sq.setString(2,firstName);
            sq.setString(3,lastName);
            sq.setString(4,score);
            int count =  sq.executeUpdate();
           // System.out.println(count + " row/s inserted");


            //******************* select query************//
            String querySelect ="SELECT * FROM test_schema_1.process_student_info";
            // create the java statement
            Statement stat = conn.createStatement();//DDL
            ResultSet rs = stat.executeQuery(querySelect);// DDL,  for fetch

            // iterate through the java resultset
            while (rs.next()) {
                int idDB = rs.getInt("studentID");
                String firstNameDB = rs.getString("firstName");
                String lastNameDB = rs.getString("lastName");
                String scoreDB = rs.getString("score");
               // System.out.println(idDB+ " " + firstNameDB+ " " + lastNameDB + " " + scoreDB );

            }
            sq.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Got an exception! ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return i;
    }

    // DML Query function
    private static void sqlQueryDDL() {

        ConnectToSqlDB dbConnectionObj = new ConnectToSqlDB();

        int i = 0;
        try {
            Connection conn = dbConnectionObj.connectToSqlDatabase();



            //******************* select query************//
            String querySelect ="SELECT * FROM test_schema_1.process_student_info";
            // create the java statement
            Statement stat = conn.createStatement();//DDL
            ResultSet rs = stat.executeQuery(querySelect);// DDL,  for fetch

            // iterate through the java resultset
            while (rs.next()) {
                int idDB = rs.getInt("studentID");
                String firstNameDB = rs.getString("firstName");
                String lastNameDB = rs.getString("lastName");
                String scoreDB = rs.getString("score");
                System.out.println("ID: "+ idDB+ " ------------ First Name: " + firstNameDB+ "------------Last Name " + lastNameDB + "------------Score: " + scoreDB );

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Got an exception! ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




}


