import java.io.*;
import org.apache.logging.log4j.*;
import java.util.Date;

public class Visitor {
    public  String fullName;
    public int age;
    public  String date_Of_Visit;
    public String time_Of_Visit;
    public String comments;
    public String agent;
    private static  final String visitor = "visitor_";
    private static final Logger logger = LogManager.getLogger(Visitor.class);

    public Visitor(String fullName,int age, String date_Of_Visit, String time_Of_Visit, String comments, String agent){

        this.fullName = fullName;
        this.age = age;
        this.date_Of_Visit = date_Of_Visit;
        this.time_Of_Visit = time_Of_Visit;
        this.comments = comments;
        this.agent = agent;
    }
    public  void save(){
        String filename = fullName.replace(" ","_").toLowerCase();
        String UserInfor = fullName+"\t"+age+"\t"+date_Of_Visit+"\t"+time_Of_Visit+"\t"+comments+"\t"+agent;
        try{

            File userFile = new File(visitor+ filename+".txt");

            if(userFile.createNewFile()){ // if true then file is created otherwise file exists
                FileWriter myWriter = new FileWriter(userFile);
                myWriter.write(UserInfor);
                myWriter.close();
                logger.debug("Write for "+fullName+" successful!!!");

            }

        }catch (IOException e){
            logger.error("Ooops! something went wrong. Your details are not saved");
            //e.printStackTrace();
        }
    }
    public  void  load(String filename){
        String f = visitor + filename.replace(" ","_").toLowerCase() + ".txt";
        File userFile = new File(f);
        try{
            FileReader readUser = new FileReader(userFile);
            BufferedReader br = new BufferedReader(readUser);
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
            readUser.close();
        }catch(Exception e){
            logger.error("Specified user does not exist, please check your spelling");
           // System.out.println(e.getMessage());
        }
    }
    public  static  void  main( String[] Args){
        Visitor Thapelo = new Visitor("Thapelo Mabuza", 15,"18-Mar-2020",
                "23:25","No comment", "Bruce");
        Visitor Kobus = new Visitor("Kobus Van DerWalt", 15,"18-Mar-2020",
                "23:36","No comment", "Michael");

//        Date date = new Date();
//        String time,newDate = date.toString();
//        time = newDate;
//        newDate = newDate.substring(0,10) +" "+ newDate.substring(25);
//        time = time.substring(11,time.length() - 10);
//        System.out.println(time);

        Kobus.save();
        Thapelo.save();
        Thapelo.load("Thapelo Mabuza");
        Kobus.load("Kobus Van DerWalt");
    }
}