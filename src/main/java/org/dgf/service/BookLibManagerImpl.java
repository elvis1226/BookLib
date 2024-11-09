package org.dgf.service;


import org.dgf.util.Logger;

import java.util.List;
import java.util.Set;


public class BookLibManagerImpl implements BookLibManager {
    private BookLibOperator operator;
    private Authenticator authenticator;

    private final static Set<String> AUTH_COMMANDS = Set.of("register", "login");
    private final static Set<String> BOOK_COMMANDS = Set.of("add", "delete", "list", "search", "borrow", "return");

    public BookLibManagerImpl(BookLibOperator operator, Authenticator authenticator) {
        this.operator = operator;
        this.authenticator = authenticator;
    }

    @Override
    public void process(List<String> arguments) {
        if (arguments.isEmpty()) {
            Logger.warn("Empty arguments");
            return;
        }
        String command = arguments.get(0);
        if (this.AUTH_COMMANDS.contains(command)) {
            this.authenticator.process(arguments);
        }
        else if(this.BOOK_COMMANDS.contains(command)) {
            this.operator.process(arguments);
        }
        else {
            throw new IllegalArgumentException("Doesnt support command '" + command + "'");
        }
    }

}
