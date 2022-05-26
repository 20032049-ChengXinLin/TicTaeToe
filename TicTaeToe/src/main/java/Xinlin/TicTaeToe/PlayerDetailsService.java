/**
*
* I declare that this code was written by me, 20032049.
* I will not copy or allow others to copy my code.
* I understand that copying code is considered as plagiarism.
*
* Student Name: Cheng Xin Lin
* Date created: 2022-May-25 8:56:23 pm
*
*/
package Xinlin.TicTaeToe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author 20032049
 *
 */
public class PlayerDetailsService implements UserDetailsService{
	@Autowired
	private PlayerRepository playerRepository;
	
	@Override
	public PlayerDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Player account = playerRepository.findByUsername(username);
		
		if (account == null) {
			throw new UsernameNotFoundException("Could not find player");
		} 
		return new PlayerDetails(account);
	}

}
