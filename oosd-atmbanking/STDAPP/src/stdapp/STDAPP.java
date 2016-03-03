/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stdapp;
import edu.sit.cs.db.CSDbDelegate;
import java.util.*;


/**
 *
 * @author Oriopun AI
 */
public class STDAPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //connect to database
        CSDbDelegate db = new CSDbDelegate("cs14sitkmutt.me", "3306", "CSC105_G3","CSC105_G3" , "cstermproj");
        System.out.println(db.connect());
    //Insert a student
        String sql_create = "INSERT INTO students(id,name,score)VALUES("
                                                 +"'57130500298'"
                                                 +"'Hello World',"
                                                 +"50.5"
                                                 +")";
        boolean insertSuccess = db.executeQuery(sql_create);
        System.out.println(insertSuccess);
        
    //Update 
        String sql_update = "UPDATE ATMtransaction SET  name = 'John Doe'WHERE "+"score > 70";// update name to 'John Doe' where score > 70 
        boolean updateSuccess = db.executeQuery(sql_update);
        System.out.println(updateSuccess);
        
    //Delete 
        String sql_delete = "DELETE FROM students WHERE name = 'Hello World' OR"+"name = 'John Doe'";
        boolean deleteSuccess = db.executeQuery(sql_update);
        System.out.println(deleteSuccess);
        
    //Retreive Students
        String sql = "SELECT * FROM ATMtransaction"; 
        ArrayList<HashMap>students = db.queryRows(sql);
        for(HashMap std : students){
            System.out.println(std.get("Balance"));
            System.out.printf("%s\t%s\t%s\t%d\n",std.get("A/C No."),std.get("Username"),std.get("Password"),std.get("Pin"));
        }
        
        //Retrive a student who get maximum score
        sql = "SELECT * FROM students WHERE score > 80 ORDER BY score DESC LIMIT 1";//DESC = descending จากมากไปหาน้อย
        HashMap std = db.queryRow(sql);
        System.out.printf("student who got max score is %s %s\n",std.get("id"),std.get("name"));
        
        
         
       /* String sql2 = "SELECT id,name FROM student";
        
        db.queryRow(sql); // to want data only 1 row
        db.queryRows(sql); // */
        
        
        //disconnect from database
        System.out.println(db.disconnect());
                
                
       
    }
    
}
