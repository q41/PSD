package actions;
import java.util.List;
import main.Card;
import main.Game;
import main.IllegalActionException;
import main.Player;

public class Trade extends ActionBase {

	public Trade(Game game, Player player) {
		super(game, player);
	}
	
	/**Trade or donate cards
	 * recieve can be null, these means the cards are donated
	 * @require give != null
	 */
	@Override
	public void handle(Object[] args) throws IllegalActionException {
		Player otherPlayer = (Player) args[0];
		List<Card> give = (List<Card>) args[1];
		List<Card> receive = (List<Card>) args[2];
		if(player.isValidTrade(give,receive,true) && otherPlayer.isValidTrade(receive, give, false)) {
			player.trade(give, receive, true);
			otherPlayer.trade(receive, give, false);
		}
	}
}