/**
 * 
 */
package actions;

import main.Game;
import main.IllegalActionException;
import main.Player;

/**
 * @author Damiaan
 *
 */
public class Donate extends Action {

	/**
	 * @param game
	 * @param player
	 */
	public Donate(Game game, Player player) {
		super(game, player);
		// TODO Auto-generated constructor stub
	}

	public Donate(Game game) {
		super(game);
	}

	/* (non-Javadoc)
	 * @see actions.ActionBase#handle(java.lang.Object[])
	 */
	@Override
	public void handle(Object[] args) throws IllegalActionException {
		// TODO Auto-generated method stub

	}

}
