/**
*
* I declare that this code was written by me, 20032049.
* I will not copy or allow others to copy my code.
* I understand that copying code is considered as plagiarism.
*
* Student Name: Cheng Xin Lin
* Date created: 2022-May-25 10:01:38 pm
*
*/
package Xinlin.TicTaeToe;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author 20032049
 *
 */
@Controller
public class LoginController {
	@Autowired
	private PlayerRepository playerRepository;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("player", new Player());
		return "register";
	}
	@PostMapping("/register/save")
	public String savePlayer(@Valid Player player, BindingResult bindingResult, RedirectAttributes redirectAttribute) {
		if (bindingResult.hasErrors()) {
			return "register_account";
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(player.getPassword());
		player.setPassword(encodedPassword);
		player.setRole("ROLE_PLAYER");
		playerRepository.save(player);
		redirectAttribute.addFlashAttribute("success", "Successfully Register");
		return "redirect:/login";
	}
//	@PostMapping("/login")
//	public String saveMember(@Valid Player player, BindingResult bindingResult, RedirectAttributes redirectAttribute) {
//		if (bindingResult.hasErrors()) {
//			return "register_account";
//		}
//
//		playerRepository.save(player);
//		return "redirect:/home";
//	}
}
