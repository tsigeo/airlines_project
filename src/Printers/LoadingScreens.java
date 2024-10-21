package Printers;

import static Printers.BoxPrinter.BoxPrinter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoadingScreens {

    public static void LoadingDatabase() throws InterruptedException {

        System.out.print("\n GATHERING DATA FROM DATABASE.");
        for (int i = 0; i < 4; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
        }
        System.out.println("\n");

    }
}
