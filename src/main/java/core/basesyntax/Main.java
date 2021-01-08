package core.basesyntax;

import core.basesyntax.controller.ConsoleHandlerImpl;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleHandlerImpl handler = new ConsoleHandlerImpl();
        System.out.println("Введите сумму и коеффициент для для вашей ставки");
        handler.handle();
    }
}
