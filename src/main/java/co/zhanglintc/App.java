package co.zhanglintc;

import co.zhanglintc.beans.StringWelcome;
import co.zhanglintc.beans.ThreadLocalWelcome;
import co.zhanglintc.intf.WelcomeInterface;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println(App.class.getClassLoader().getResource(""));
        System.out.println(App.class.getResource(""));
        System.out.println("Hello World!");

        WelcomeInterface stringWelcome = new StringWelcome();
        WelcomeInterface threadLocalWelcome = new ThreadLocalWelcome();

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
