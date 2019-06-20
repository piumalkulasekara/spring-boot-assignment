package lk.piumalkulasekara.spring.boot.assignment;

import lk.piumalkulasekara.spring.boot.assignment.service.MetaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author piumalkulasekara
 * @version 1.0
 * @since 19/06/2019
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private MetaDataService metaDataService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        metaDataService.addAccountMetaData();
        metaDataService.addPaymentMetaData();
    }
}