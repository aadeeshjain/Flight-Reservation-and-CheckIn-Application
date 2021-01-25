package io.aadeesh.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.aadeesh.models.User;
import io.aadeesh.repos.UserRepository;
import io.aadeesh.services.SecurityService;

@Controller
public class UserController {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserController.class);

	@Autowired
	SecurityService securityService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	UserRepository urepo;

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		LOGGER.info("Inside showRegistrationPage()");
		return "login/registerUser";
	}

	@PostMapping("/registerUser")
	public String register(@ModelAttribute User user) {
		LOGGER.info("Inside register()" + user);
		user.setPassword(encoder.encode(user.getPassword()));
		urepo.save(user);
		return "login/login";
	}

	@RequestMapping("/showLogin")
	public String showLoginPage() {
		LOGGER.info("Inside showLoginPage()");
		return "login/login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelmap) {
		LOGGER.info("Inside login() with Email: " + email);

		boolean loginResponse = securityService.login(email, password);

//		User user=urepo.findByEmail(email);
		if (loginResponse) {
			return "findFlights";
		} else {
			modelmap.addAttribute("msg", "Invalid Username or Password. Please try again..");
		}
		return "login/login";
	}
}
