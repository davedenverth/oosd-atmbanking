/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Game
 */
public class TimeATM implements FormatDateTime {
    
    public String getFormat(){
        SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");
        String realFormat = String.valueOf(form.format(new Date()));
        return realFormat;
    }
}
