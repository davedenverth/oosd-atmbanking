/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javax.swing.JFrame;
import edu.sit.cs.db.CSDbDelegate;
/**
 *
 * @author Game
 */
public abstract class PopUp extends JFrame{
    
    public ConnectDB db;
    public CSDbDelegate get;
    public FormatDateTime format;
    
    public PopUp(){
        format = new DateATM();
        db = new ConnectDB();
        get = db.getConnect();
    }
    
    public boolean isNumeric(String s){
        try{
            Double.parseDouble(s);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
    public boolean connectionIsOn(){
        return get.getDbConnection() != null;
    }
    
    public void setFormat(FormatDateTime ft){
        format = ft;
    }
    
    public void properDispose(){
        Transaction.countFrame--;
        Login.transaction.checkEnableFrame();
        dispose();
    }
    
    public String getDesktopPath(){
        String path = System.getProperty("user.home");
        String desktop = "/Desktop";
        String fullPath;
        
        if(System.getProperty("os.name").startsWith("Mac")){
            fullPath = path + desktop;
        }
        else {
            fullPath = path.replaceAll("\\\\", "/") + desktop;
        }
        return fullPath;
    }
}
