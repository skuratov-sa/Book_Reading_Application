package com.diploma.black_fox_ex.controllers;

import com.diploma.black_fox_ex.model.User;
import com.diploma.black_fox_ex.service.UserService;
import com.diploma.black_fox_ex.dto.DeleteHelpDtoReq;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * This is the class for interacting with the support pageNum.
 */
@Controller
@RequestMapping("/help")
public class HelpController {
    private final UserService userService;

    @Autowired
    public HelpController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @param user  Retrieving Authorized User Data Using Spring Security
     * @param model for creating attributes sent to the server as a response
     * @return the support pageNum
     */
    @GetMapping
    public String start(@AuthenticationPrincipal User user, Model model) {
        var response = userService.getAllAnswersSupportByUserDto(user);
        if (response.getErrors() != null)
            model.addAttribute("error", response.getErrors());

        model.addAttribute("answers", response.getAnswers());
        model.addAttribute("userMenu", userService.getUserMenu(user));
        return "help";
    }

    /**
     * @param id    is responsible for the id of the message from the support group
     * @param user  Retrieving Authorized User Data Using Spring Security
     * @param model for creating attributes sent to the server as a response
     * @return the support pageNum and possible errors
     */
    @GetMapping("/{id}/delete")
    public String deleteAnswerSupport(@PathVariable long id, @AuthenticationPrincipal User user, Model model) {
        var request = new DeleteHelpDtoReq(user, id);
        var response = userService.deleteAnswerByUser(request);
        if (response.getErrors() != null) {
            model.addAttribute("error", response.getErrors());
            return "help";
        }
        model.addAttribute("userMenu", userService.getUserMenu(user));
        return "redirect:/help";
    }
}
