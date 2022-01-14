package org.springframework.samples.petclinic.recoveryroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RecoveryRoomController {

    private static final String VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
    @Autowired
    private RecoveryRoomService rrService;

    @GetMapping(value = "/recoveryroom/create")
    public String createRR(ModelMap mp){
        List<RecoveryRoomType> rt = rrService.getAllRecoveryRoomTypes();
        RecoveryRoom r = new RecoveryRoom();
        mp.put("recoveryRoom", r);
        mp.put("recoveryRoomTypes", rt);
        return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping(value = "/recoveryroom/create")
    public String createRR(@Valid RecoveryRoom rr, BindingResult result, ModelMap model){
        if (result.hasErrors()) {
            model.put("recoveryRoom", rr);
            return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
        }
        rrService.save(rr);
        return "Welcome";

    }
}
