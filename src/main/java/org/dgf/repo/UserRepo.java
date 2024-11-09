package org.dgf.repo;

public interface UserRepo {
    boolean exist(String name, String password);
    boolean add(String name, String password, String type);
}
