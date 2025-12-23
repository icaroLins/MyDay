package Task.MyDay.service.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Task.MyDay.dto.StatusActivity;
import Task.MyDay.model.activity.Activity;
import Task.MyDay.repository.activity.ActivityRepository;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Activity createAtivity(Activity atividade) {
        return activityRepository.save(atividade);
    }

    public List<Activity> getAtivity(Long userId) {
        return activityRepository.findByUser_id(userId);
    }

    public Activity changeAtividade(Long userId, Long activityId) {
        Activity atividade = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("ativiadade não encontradaS"));
        
        if(!atividade.getUser().getId().equals(userId)){
            throw new RuntimeException("Você não pode alterar o status dessa atividade!");
        }

        atividade.setStatus(StatusActivity.ATIVIDADE);
        activityRepository.save(atividade);

        return atividade;
    }

    public Activity changeAFazer(Long userId, Long activityId) {
        Activity atividade = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("ativiadade não encontradaS"));
        
        if(!atividade.getUser().getId().equals(userId)){
            throw new RuntimeException("Você não pode alterar o status dessa atividade!");
        }

        atividade.setStatus(StatusActivity.AFAZER);
        activityRepository.save(atividade);

        return atividade;
    }

    public Activity changeFazendo(Long userId, Long activityId) {
        Activity atividade = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("ativiadade não encontradaS"));
        
        if(!atividade.getUser().getId().equals(userId)){
            throw new RuntimeException("Você não pode alterar o status dessa atividade!");
        }

        atividade.setStatus(StatusActivity.FAZENDO);
        activityRepository.save(atividade);

        return atividade;
    }

    public Activity changeFeito(Long userId, Long activityId) {
        Activity atividade = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("ativiadade não encontradaS"));
        
        if(!atividade.getUser().getId().equals(userId)){
            throw new RuntimeException("Você não pode alterar o status dessa atividade!");
        }

        atividade.setStatus(StatusActivity.FEITO);
        activityRepository.save(atividade);

        return atividade;
    }

    public Activity editActivity(Long userId, Long activityId, Activity atualizada) {
        Activity atividade = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("ativiadade não encontradaS"));
        
        if(!atividade.getUser().getId().equals(userId)){
            throw new RuntimeException("Você não pode alterar o status dessa atividade!");
        }

        atividade.setDescription(atualizada.getDescription());
        atividade.setTitle(atualizada.getTitle());;
        activityRepository.save(atividade);

        return atividade;
    }


}
