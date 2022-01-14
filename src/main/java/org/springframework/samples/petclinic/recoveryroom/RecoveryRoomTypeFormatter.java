package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

    @Autowired
    RecoveryRoomService recServ;

    @Override
    public String print(RecoveryRoomType object, Locale locale) {
        return object.name;
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
        RecoveryRoomType rt = recServ.getRecoveryRoomType(text);
        if(rt!= null && rt.name.equals(text)){
        return rt;
        }throw new ParseException("Recovery Room Type not found: "+ text, 0);
    }
    
}
