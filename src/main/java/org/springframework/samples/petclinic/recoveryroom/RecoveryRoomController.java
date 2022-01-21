package org.springframework.samples.petclinic.recoveryroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RecoveryRoomController {
    @Autowired
    RecoveryRoomService recoveryRoomService;


    @GetMapping("/recoveryroom/create")
    public String getCreateRoom(ModelMap mp){
        RecoveryRoom rr = new RecoveryRoom();
        List<RecoveryRoomType> rt = recoveryRoomService.getAllRecoveryRoomTypes();
        mp.put("recoveryRoom", rr);
        return "recoveryroom/createOrUpdateRecoveryRoomForm";
    }

    @PostMapping("/recoveryroom/create")
    public String postCreateRoom(@Valid RecoveryRoom rr, BindingResult result, ModelMap mp){
        if (result.hasErrors()){
            mp.put("recoveryRoom",rr);
            return "recoveryroom/createOrUpdateRecoveryRoomForm";
        }
        recoveryRoomService.save(rr);
        return "welcome";
    }

}
