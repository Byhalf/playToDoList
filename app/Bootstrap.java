import models.Tache;
import play.libs.WS;
import play.jobs.Job;
import play.jobs.Every;
import play.test.Fixtures;

import java.time.LocalDateTime;
import java.util.List;


@Every("1mn")
public class Bootstrap extends Job {

    public void doJob() {
        String userToken = "u4eso4sb4ixcd4ybavutv1i5giisvj";
        String ApiToken = "aqep15mvuyho63dc4isnzq94e6muh9";
        List<Tache> taches = Tache.findAll();
        for (Tache tache:taches) {
            if(!tache.notification && tache.time.isBefore(LocalDateTime.now(ZoneId.of("Europe/Paris")))){
                WS.url("https://api.pushover.net/1/messages.json?token="+ApiToken+"&user="+userToken+"&message="+tache.title)
                        .post();
                tache.notification = true;
                tache.save();
            }
        }
        // Load default data if the database is empty
//        if(Tache.count() == 0) {
//            Fixtures.loadModels("data.yml");
//            System.out.println("load data.yml done !");
//        }
    }

}
