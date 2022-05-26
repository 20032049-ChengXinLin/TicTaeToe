/**
*
* I declare that this code was written by me, 20032049.
* I will not copy or allow others to copy my code.
* I understand that copying code is considered as plagiarism.
*
* Student Name: Cheng Xin Lin
* Date created: 2022-May-25 8:31:28 pm
*
*/
package Xinlin.TicTaeToe;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Check;

/**
 * @author 20032049
 *
 */

//@Check(constraints = "first_player_piece_code = 'O' or first_player_piece_code = 'X' "
//		+ "and game_type = 'COMPUTER' or game_type = 'COMPETITION' "
//		+ "and game_status = 'IN_PROGRESS' or game_status = 'FIRST_PLAYER_WON' or game_status = 'SECOND_PLAYER_WON'"
//		+ "or game_status = 'TIE' or game_status = 'WAITS_FOR_PLAYER' ")

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@ManyToOne
	@JoinColumn(name = "second_player_id", nullable = true)
	private Player secondPlayer;

	@ManyToOne
	@JoinColumn(name = "first_player_id", nullable = false)
	private Player firstPlayer;

	private LocalDateTime DateCreated;
	private String game_status;
//	private String game_type;
	private String first_player_piece_code;
	private String second_player_piece_code;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDateCreated() {
		return DateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		DateCreated = dateCreated;
	}

	public String getGame_status() {
		return game_status;
	}

	public void setGame_status(String game_status) {
		this.game_status = game_status;
	}

//	public String getGame_type() {
//		return game_type;
//	}
//
//	public void setGame_type(String game_type) {
//		this.game_type = game_type;
//	}
//
	public String getFirst_player_piece_code() {
		return first_player_piece_code;
	}

	public void setFirst_player_piece_code(String first_player_piece_code) {
		this.first_player_piece_code = first_player_piece_code;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public void setSecondPlayer(Player secondPlayer) {
		this.secondPlayer = secondPlayer;
	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}
	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public String getSecond_player_piece_code() {
		return second_player_piece_code;
	}

	public void setSecond_player_piece_code(String second_player_piece_code) {
		this.second_player_piece_code = second_player_piece_code;
	}
	
}