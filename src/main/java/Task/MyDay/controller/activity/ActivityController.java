package Task.MyDay.controller.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Task.MyDay.model.User;
import Task.MyDay.model.activity.Activity;
import Task.MyDay.service.UserService;
import Task.MyDay.service.activity.ActivityService;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private final ActivityService activityService;
    @Autowired
    private final UserService userService;

    

    public ActivityController(ActivityService activityService, UserService userService) {
        this.activityService = activityService;
        this.userService = userService;
    }


    @PostMapping("/criar")
    public ResponseEntity<?> createActivity(Authentication authentication, @RequestBody Activity atividade){
        String email = authentication.getName();
        User user = userService.searchByEmail(email);

        atividade.setUser(user);

        Activity newActivity = activityService.createAtivity(atividade);

        return ResponseEntity.ok(newActivity);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getActivity(Authentication authentication){
        String email = authentication.getName();
        User user = userService.searchByEmail(email);

        List<Activity> listActivity = activityService.getAtivity(user.getId());

        return ResponseEntity.ok(listActivity);
    }

    @PostMapping("/mudarAtividade/{atividadeId}")
    public ResponseEntity<?> chageAtividade(Authentication authentication, @PathVariable Long atividadeId){
        String email = authentication.getName();
        User user = userService.searchByEmail(email);

        Activity chageStatus = activityService.changeAtividade(user.getId(), atividadeId);

        return ResponseEntity.ok(chageStatus);
    }

    @PostMapping("/mudarAFazer/{atividadeId}")
    public ResponseEntity<?> chageAFazer(Authentication authentication, @PathVariable Long atividadeId){
        String email = authentication.getName();
        User user = userService.searchByEmail(email);

        Activity chageStatus = activityService.changeAFazer(user.getId(), atividadeId);

        return ResponseEntity.ok(chageStatus);
    }

    @PostMapping("/mudarFazendo/{atividadeId}")
    public ResponseEntity<?> chageFazendo(Authentication authentication, @PathVariable Long atividadeId){
        String email = authentication.getName();
        User user = userService.searchByEmail(email);

        Activity chageStatus = activityService.changeFazendo(user.getId(), atividadeId);

        return ResponseEntity.ok(chageStatus);
    }

    @PostMapping("/mudarFeito/{atividadeId}")
    public ResponseEntity<?> chageFeito(Authentication authentication, @PathVariable Long atividadeId){
        String email = authentication.getName();
        User user = userService.searchByEmail(email);

        Activity chageStatus = activityService.changeFeito(user.getId(), atividadeId);

        return ResponseEntity.ok(chageStatus);
    }

    @PutMapping("/editar/{atividadeId}")
    public ResponseEntity<?> edidActivity(Authentication authentication,
        @PathVariable("atividadeId") Long atividadeId,
        @RequestBody Activity activity){
        String email = authentication.getName();
        User user = userService.searchByEmail(email);

        Activity editar = activityService.editActivity(user.getId(), atividadeId, activity);

        return ResponseEntity.ok(editar);
    }


}
