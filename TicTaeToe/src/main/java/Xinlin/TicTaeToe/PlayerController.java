/**
*
* I declare that this code was written by me, 20032049.
* I will not copy or allow others to copy my code.
* I understand that copying code is considered as plagiarism.
*
* Student Name: Cheng Xin Lin
* Date created: 2022-May-25 10:21:15 pm
*
*/
package Xinlin.TicTaeToe;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author 20032049
 *
 */
@Controller
public class PlayerController {
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private MoveRepository moveRepository;

	@GetMapping("/")
	public String viewHome(Model model) {
		// Get currently logged in user
		PlayerDetails loggedInAccount = (PlayerDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		int loggedInAccountId = loggedInAccount.getPlayer().getId();
		Player player = playerRepository.getById(loggedInAccountId);

		List<Game> gamelist = gameRepository.findAll();
		model.addAttribute("gamelist", gamelist);
		model.addAttribute("game", new Game());
		model.addAttribute("player", player);
		return "homepage";
	}

	@PostMapping("/newgame")
	public String CreateNewGame(@Valid Game game, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "homepage";
		}
		// Get currently logged in user
		PlayerDetails loggedInAccount = (PlayerDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		int loggedInAccountId = loggedInAccount.getPlayer().getId();
		Player player = playerRepository.getById(loggedInAccountId);
		LocalDateTime currentDateTime = LocalDateTime.now();
		game.setDateCreated(currentDateTime);
		game.setGame_status("WAITS_FOR_PLAYER");
		game.setFirstPlayer(player);
		game.setFirst_player_piece_code("X");
		gameRepository.save(game);
		return "redirect:/game/" + game.getId();
	}

	@PostMapping("/joingame/{id}")
	public String joinGame(@PathVariable("id") int id, Model model) {
		// Get currently logged in user
		PlayerDetails loggedInAccount = (PlayerDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		int loggedInAccountId = loggedInAccount.getPlayer().getId();
		Player player = playerRepository.getById(loggedInAccountId);
		Game game = gameRepository.getById(id);
		game.setSecondPlayer(player);
		game.setGame_status("IN_PROGRESS");
		game.setSecond_player_piece_code("O");
		gameRepository.save(game);
		return "redirect:/game/{id}";
	}

	@GetMapping("/game/{id}")
	public String playGame(@PathVariable("id") int id, Model model) {
		// Get currently logged in user
		PlayerDetails loggedInAccount = (PlayerDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		int loggedInAccountId = loggedInAccount.getPlayer().getId();
		Player player = playerRepository.getById(loggedInAccountId);

		Game game = gameRepository.getById(id);
//		game.setSecondPlayer(player);
//		gameRepository.save(game);
		model.addAttribute("game", game);
		return "waiting";
	}

	@GetMapping("/tictaetoe/{id}")
	public String tictaetoe(@PathVariable("id") int id, Model model) {
		PlayerDetails loggedInAccount = (PlayerDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		int loggedInAccountId = loggedInAccount.getPlayer().getId();
		Player player = playerRepository.getById(loggedInAccountId);
		Game game = gameRepository.getById(id);
		model.addAttribute("game", game);
		model.addAttribute("player", player);
		model.addAttribute("Move", new Move());
		model.addAttribute("id", false);
		return "tictactoe";
	}

	@PostMapping("/tictaetoe/{id}")
	public String saveMovetictaetoe(@PathVariable("id") int id, Move move) {
		Game game = gameRepository.getById(id);
		move.setGame(game);
		moveRepository.save(move);
		List<Move> movelist = moveRepository.findAll();
		int moveid = 0;
		for (int i =0; i < movelist.size(); i++) {
			if (movelist.get(i).getGame().getId() == id) {
				moveid = movelist.get(i).getId();
			}
		}
		return "redirect:/tictaetoe/move/" + moveid;
	}

	@GetMapping("/tictaetoe/move/{id}")
	public String MoveTicTaeToe(@PathVariable("id") int id, Model model) {
		PlayerDetails loggedInAccount = (PlayerDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		int loggedInAccountId = loggedInAccount.getPlayer().getId();
		Player player = playerRepository.getById(loggedInAccountId);
		model.addAttribute("player", player);
		Move move = moveRepository.getById(id);
		model.addAttribute("game", move.getGame());
		model.addAttribute("Move", move);
		System.out.println(move.getGame());
		model.addAttribute("id", true);
		return "tictactoe";
	}

	@PostMapping("/tictaetoe/move/{id}")
	public String savetictaetoe(@PathVariable("id") int id, Move move) {
		Move moving = moveRepository.getById(id);
		move.setGame(moving.getGame());
		moveRepository.save(move);
		return "redirect:/tictaetoe/move/{id}";
	}
	
	@GetMapping("/winner")
	public String viewWinner(Model model) {
		List<Move> moveRepositoryList = moveRepository.findAll();
		model.addAttribute("winnerlist", moveRepositoryList);
		return "winner";
	}
}
