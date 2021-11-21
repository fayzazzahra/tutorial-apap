package apap.tutorial.cineplux.service;
import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    List<UserModel> getListUser();

    UserModel findUserById(String id);
    UserModel findUserByUsername(String username);
    boolean isMatch(String newPassword, String oldPassword);
    boolean checkEmail(String email);
    void setPassword(UserModel myUser, String newPassword);
    void removeUser(UserModel user);

}