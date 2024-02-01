package co.zhanglintc.beans;

import co.zhanglintc.intf.WelcomeInterface;

public class StringWelcome implements WelcomeInterface {
    private String name;

    @Override
    public String welcome(String name) {
        this.name = name;

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s: %s => overrode\n", StringWelcome.class.getName(), this.name);
        return this.name;
    }
}
