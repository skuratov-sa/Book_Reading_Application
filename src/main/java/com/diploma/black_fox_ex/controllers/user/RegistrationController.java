package com.diploma.black_fox_ex.controllers.user;

import com.diploma.black_fox_ex.dto.user.UserDTO;
import com.diploma.black_fox_ex.model.constant.Sex;
import com.diploma.black_fox_ex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * This is the class for interacting with the registration pageNum.
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    /**
     * The function for going to the registration pageNum
     *
     * @param userDto that accepts user input
     * @return the 'registration' pageNum
     */
    @GetMapping
    public String registration(@ModelAttribute("userReg") UserDTO userDto, Model model) {
        model.addAttribute("genders", Sex.values());
        return "registration";
    }

    /**
     * @param userDto that accepts user input
     * @param model   for creating attributes sent to the server as a response
     * @return to original pageNum in case of error, otherwise to the login pageNum
     */
    @PostMapping("/add")
    public String addNewUser(@Valid @ModelAttribute("userReg") UserDTO userDto,
                             BindingResult valid, Model model) {
        if (userService.isExistUser(userDto.getUsername())) {
            valid.addError(new ObjectError(
                    "username", "registration.user.already.exist")
            );
        }

        if (valid.hasErrors()) {
            model.addAttribute("genders", Sex.values());
            model.addAttribute("warnings", valid.getAllErrors());
            return "registration";
        }
        userService.registrationUser(userDto);
        return "redirect:/login";
    }
}
