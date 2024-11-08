package org.dgf;

import org.dgf.service.BookLibManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] argvs) {
        BookLibManager manager = Config.assemble();

        while (true) {

            try {
                Scanner in = new Scanner(System.in);
                List<String> arguments = new ArrayList<>();
                while (in.hasNext()) {
                    arguments.add(in.next());
                }
                manager.process(arguments);

            }
            catch (Exception e) {

            }
            finally {

            }
        }
    }
}
