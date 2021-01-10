package core.basesyntax;

import core.basesyntax.controller.ConsoleHandlerImpl;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandlerImpl handler =
                (ConsoleHandlerImpl) Injector.getInstance(ConsoleHandlerImpl.class);
        System.out.println("Enter firstName, lastName and phone number");
        handler.handleUser();
        System.out.println("Enter the amount and coefficient for your bet.");
        handler.handleBet();
    }
}
