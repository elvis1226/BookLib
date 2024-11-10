package org.dgf;

import org.dgf.flow.BookLibManager;
import org.dgf.util.Logger;

import java.io.Console;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] argvs) {
        final BookLibManager manager = Config.assemble();
        final Console console = System.console();
        final String delimiter = " ";

        while (true) {
            try {
                String line = console.readLine();
                List<String> arguments = Stream.of(line.split(delimiter)).toList();
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
