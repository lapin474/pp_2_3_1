package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(Long id);

    void updateUser(Long id, User user);

    User showUser(Long id);

    void createNewUser(String firstName, String lastName, String email);

    void updateUserFields(Long id, String firstName, String lastName, String email);
}
