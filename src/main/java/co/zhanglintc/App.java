package co.zhanglintc;

import co.zhanglintc.beans.StringWelcome;
import co.zhanglintc.beans.ThreadLocalWelcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 */
@ComponentScan
public class App implements ApplicationRunner {
    @Autowired
    private StringWelcome stringWelcome;

    @Autowired
    private ThreadLocalWelcome threadLocalWelcome;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        System.out.println(App.class.getClassLoader().getResource(""));
        System.out.println(App.class.getResource(""));
        System.out.println("Hello World!");

        // WelcomeInterface stringWelcome = new StringWelcome();
        // WelcomeInterface threadLocalWelcome = new ThreadLocalWelcome();

        new Thread(() -> {
            stringWelcome.welcome("zhang3");
            threadLocalWelcome.welcome("zhang3");
        }).start();

        new Thread(() -> {
            stringWelcome.welcome("li4");
            threadLocalWelcome.welcome("li4");
        }).start();
    }
}
