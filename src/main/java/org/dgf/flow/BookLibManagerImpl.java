package org.dgf.flow;


import org.dgf.service.Authenticator;
import org.dgf.service.BookOperator;
import org.dgf.util.Logger;

import java.util.List;


public class BookLibManagerImpl implements BookLibManager {
    private BookOperator operator;
    private Authenticator authenticator;

    public BookLibManagerImpl(BookOperator operator, Authenticator authenticator) {
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
        if (this.authenticator.isDoable(command)) {
            this.authenticator.process(arguments);
        }
        else if(this.operator.isDoable(command)) {
            this.operator.process(arguments);
        }
        else {
            throw new IllegalArgumentException("Doesnt support command '" + command + "'");
        }
    }

}
