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
public class DateATM implements FormatDateTime {
    public String getFormat(){
        SimpleDateFormat form = new SimpleDateFormat("dd.MM.yyyy");
        String realFormat = String.valueOf(form.format(new Date()));
        return realFormat;
    }
}
