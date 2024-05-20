package jay.ferga.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();


    public List<Run> findAll(){
        return runs;
    }

    Optional<Run> findById(int id){
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();

    }

    @PostConstruct
    private void init(){
        runs.add(new Run(2,
                "second run",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                5,
                Location.INDOOR));
        runs.add(new Run(3,
                "third run",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                5,
                Location.OUTDOOR));
    }
}
