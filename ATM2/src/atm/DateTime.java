/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author Game
 */
public class DateTime {
    protected final String formatDate = "dd.MM.yyyy";
    protected final String formatTime = "hh:mm:ss";
    String realFormat;
    
    public DateTime(String format){
        Date dateTime = new Date();
        SimpleDateFormat ft = new SimpleDateFormat(format);
        realFormat = String.valueOf(ft.format(dateTime));
    }
    
    public String getFormat(){
        return realFormat;
    }
}
