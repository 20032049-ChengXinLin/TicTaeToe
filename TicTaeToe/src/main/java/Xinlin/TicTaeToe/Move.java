/**
*
* I declare that this code was written by me, 20032049.
* I will not copy or allow others to copy my code.
* I understand that copying code is considered as plagiarism.
*
* Student Name: Cheng Xin Lin
*/
package Xinlin.TicTaeToe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author 20032049
 *
 */
@Entity
public class Move {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;
    
    private String Broad1;
    private String Broad2;
    private String Broad3;
    private String Broad4;
    private String Broad5;
    private String Broad6;
    private String Broad7;
    private String Broad8;
    private String Broad9;
    private String winner;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getBroad1() {
		return Broad1;
	}

	public void setBroad1(String broad1) {
		Broad1 = broad1;
	}

	public String getBroad2() {
		return Broad2;
	}
	
	public void setBroad2(String broad2) {
		Broad2 = broad2;
	}

	public String getBroad3() {
		return Broad3;
	}

	public void setBroad3(String broad3) {
		Broad3 = broad3;
	}

	public String getBroad4() {
		return Broad4;
	}

	public void setBroad4(String broad4) {
		Broad4 = broad4;
	}

	public String getBroad5() {
		return Broad5;
	}

	public void setBroad5(String broad5) {
		Broad5 = broad5;
	}

	public String getBroad6() {
		return Broad6;
	}

	public void setBroad6(String broad6) {
		Broad6 = broad6;
	}

	public String getBroad7() {
		return Broad7;
	}

	public void setBroad7(String broad7) {
		Broad7 = broad7;
	}

	public String getBroad8() {
		return Broad8;
	}

	public void setBroad8(String broad8) {
		Broad8 = broad8;
	}

	public String getBroad9() {
		return Broad9;
	}

	public void setBroad9(String broad9) {
		Broad9 = broad9;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
   
}
