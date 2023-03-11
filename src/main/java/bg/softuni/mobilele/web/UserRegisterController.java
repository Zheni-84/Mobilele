package bg.softuni.mobilele.web;

import bg.softuni.mobilele.model.dto.UserRegisterDTO;
import bg.softuni.mobilele.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserRegisterController {

	public static final String REDIRECT = "redirect:/";

	private final UserService userService;

	public UserRegisterController(UserService userService) {
		this.userService = userService;
	}

	@ModelAttribute("userModel")
	public UserRegisterDTO initUserModel() {
		return new UserRegisterDTO();
	}

	@GetMapping("/register")
	public String register() {
		return "auth-register";
	}

	@PostMapping("/register")
	public String register(@Valid UserRegisterDTO userModel, BindingResult bindResult, RedirectAttributes redirectAttributes) {
		if (bindResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("userModel", userModel);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindResult);
			return "redirect:/users/register";
		}
		userService.registerAndLogin(userModel);
		return REDIRECT;
	}
}