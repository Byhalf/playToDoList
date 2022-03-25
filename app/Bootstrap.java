import models.Tache;
import play.libs.WS;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

import java.time.LocalDateTime;


@Every("1m")
public class Bootstrap extends Job {

    public void doJob() {
        String userToken = "u4eso4sb4ixcd4ybavutv1i5giisvj";
        String ApiToken = "aqep15mvuyho63dc4isnzq94e6muh9";
        for (Tache tache: Tache.findAll()) {
            if(!tache.notification && tache.time.isBefore(LocalDateTime.now())){
                WS.url("https://api.pushover.net/1/messages.json?token="+ApiToken+"&user="+userToken+"&message="+tache.title)
                        .post();
                tache.notification = true;

            }
        }
        // Load default data if the database is empty
//        if(Tache.count() == 0) {
//            Fixtures.loadModels("data.yml");
//            System.out.println("load data.yml done !");
//        }
    }

}
