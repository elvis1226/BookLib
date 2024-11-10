package org.dgf.service;

import java.util.List;

public interface BookOperator extends Doable{
    void process(List<String> arguments);
}