package airlinesproject;

import static Printers.BoxPrinter.BoxPrinter;
import static airlinesproject.AppMenus.Menu;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException, IOException {
        BoxPrinter("Sxediasmos Vasewn Dedomenwn, Ergasia Eksamhnoy");
        BoxPrinter("Giorgos Tsichlakis \u00a9 2020");
        Menu();
    }

}
