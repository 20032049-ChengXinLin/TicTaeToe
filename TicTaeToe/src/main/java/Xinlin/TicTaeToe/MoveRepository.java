/**
*
* I declare that this code was written by me, 20032049.
* I will not copy or allow others to copy my code.
* I understand that copying code is considered as plagiarism.
*
* Student Name: Cheng Xin Lin
*
*/
package Xinlin.TicTaeToe;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 20032049
 *
 */
public interface MoveRepository extends JpaRepository<Move, Integer>{
	public Move findByGameId(int gameid);
}
