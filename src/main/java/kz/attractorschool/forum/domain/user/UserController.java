package kz.attractorschool.forum.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/login")
  public String showLoginForm(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
    model.addAttribute("error", error);
    return "login";
  }

  @GetMapping("/register")
  public String showRegisterForm(Model model) {
    if (!model.containsAttribute("form")) {
      model.addAttribute("form", new UserRegistrationForm());
    }
    return "register";
  }

  @PostMapping("/register")
  public String register(@Valid @ModelAttribute UserRegistrationForm userRegistrationForm,
                      BindingResult validationResult,
                      RedirectAttributes attributes) {
    attributes.addFlashAttribute("form", userRegistrationForm);
    if (validationResult.hasFieldErrors()) {
      attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
      return "redirect:/users/register";
    }
    userService.register(userRegistrationForm);
    return "redirect:/users/login";
  }


}


