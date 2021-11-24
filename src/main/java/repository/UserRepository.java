package repository;

import entities.User;

public class UserRepository extends Repository<User>{

    private static final UserRepository INSTANCE = new UserRepository();

    public static UserRepository getInstance() { return INSTANCE; }

    private UserRepository() {}
}
