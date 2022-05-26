/**
*
* I declare that this code was written by me, 20032049.
* I will not copy or allow others to copy my code.
* I understand that copying code is considered as plagiarism.
*
* Student Name: Cheng Xin Lin (20032049)
* Date created: 2022-May-25 8:55:34 pm
*
*/
package Xinlin.TicTaeToe;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 20032049
 *
 */
public interface PlayerRepository extends JpaRepository<Player, Integer>{
	
	public Player findByUsername(String username);
}
