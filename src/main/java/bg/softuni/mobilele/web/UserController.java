package bg.softuni.mobilele.web;

import bg.softuni.mobilele.model.dto.UserLoginDTO;
import bg.softuni.mobilele.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

	public static final String REDIRECT = "redirect:/";

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/login")
	public String login() {

		return "auth-login";
	}

	@GetMapping("/logout")
	public String logout() {
		userService.logout();
		return REDIRECT;
	}

	@PostMapping("/login")
	public String login(@Valid UserLoginDTO userLoginDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors() || !userService.login(userLoginDTO)) {
			redirectAttributes.addFlashAttribute("userModel", userLoginDTO);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
			
			return "redirect:/users/login";
		}

		boolean login = userService.login(userLoginDTO);
		System.out.println("User is logged: " + login);
		return REDIRECT;
	}
}