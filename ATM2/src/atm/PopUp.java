/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;
import javax.swing.JFrame;
/**
 *
 * @author Game
 */
public abstract class PopUp extends JFrame{
    
    public ConnectDB db;
    
    public boolean isNumeric(String s){
        try{
            Integer.parseInt(s);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }
}
