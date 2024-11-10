package org.dgf;

import org.dgf.flow.BookLibManager;
import org.dgf.util.Logger;

import java.io.Console;
import java.util.List;

import static org.dgf.util.Utility.parseLine;


public class Main {

    public static void main(String[] argvs) {
        final BookLibManager manager = Config.assemble();
        final Console console = System.console();
        final String delimiter = " ";

        while (true) {
            try {
                String line = console.readLine();
                List<String> arguments = parseLine(line);
                manager.process(arguments);
            }
            catch(Exception e) {
                Logger.error(e.getMessage());
            }
            finally {

            }
        }
    }
}
