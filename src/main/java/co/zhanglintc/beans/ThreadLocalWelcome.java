package co.zhanglintc.beans;

import co.zhanglintc.intf.WelcomeInterface;
import org.springframework.stereotype.Component;

@Component
public class ThreadLocalWelcome implements WelcomeInterface {
    private ThreadLocal<String> name = new ThreadLocal<>();

    @Override
    public String welcome(String name) {
        this.name.set(name);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s: %s => correct\n", ThreadLocalWelcome.class.getName(), this.name.get());
        return this.name.get();
    }
}
