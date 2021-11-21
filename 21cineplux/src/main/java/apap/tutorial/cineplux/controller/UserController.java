package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap. tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.RoleService;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation. Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    private String addUserFormPage(Model model) {
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping (value = "/add")
    private String addUserSubmit (@ModelAttribute UserModel user, Model model) {
        Boolean flag = userService.checkEmail(user.getEmail());
        String msg ="";
        if (flag) {
            userService.addUser(user);
        } else {
            msg += "Email is already registered. Please use another email.";
            return "email-used";
        }
        model.addAttribute("user", user);
        List<UserModel> listUser = userService.getListUser();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping("/viewall")
    private String listUser(Model model) {
        List<UserModel> listUser = userService.getListUser();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping("/updatePassword/{idUser}")
    private String changePasswordForm(@PathVariable String idUser) {
        UserModel myUser = userService.findUserById(idUser);
        return "form-change-pass";
    }

    @PostMapping("/updatePassword")
    private String changePasswordSubmit(
            @ModelAttribute UserModel userModel,
            String newPass,
            String confirmPass,
            Model model
    ) {
        UserModel myUser = userService.findUserByUsername(userModel.getUsername());
        String msg = "";
        if (userService.isMatch(userModel.getPassword(), myUser.getPassword())){
            if (newPass.equals(confirmPass)){
                userService.setPassword(myUser, newPass);
                userService.addUser(myUser);
                msg += "Password berhasil diupdate.";
            }
            else {
                msg += "Konfirmasi password tidak sama, silakan coba ulang.";
            }
        }
        else {
            msg += "Password salah!";
        }
        model.addAttribute("msg", msg);
        model.addAttribute("username", userModel.getUsername());
        return "change-pass";
    }

    @RequestMapping(value = "/delete/{idUser}", method = RequestMethod.GET)
    public String deleteUser(
            @PathVariable String idUser,
            @ModelAttribute UserModel userModel,
            Model model
    ) {
        UserModel user = userService.findUserById(idUser);
        String msg = "";

        if (user == null) {
            msg += "User tidak ditemukan";
        }
        else {
            userService.removeUser(user);
            msg += "User berhasil dihapus";
        }
        model.addAttribute("msg", msg);
        return "remove-user";
    }

}
