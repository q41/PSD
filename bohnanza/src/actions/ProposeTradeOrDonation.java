package actions;
import java.util.List;
import main.*;

public class ProposeTradeOrDonation extends Action {

	private final Player otherPlayer;
	private final List<Card> give;
	private final List<Card> receive;
	
	public ProposeTradeOrDonation(Game game, Player initiator, Player otherPlayer, List<Card> give, List<Card> receive) {
		super(game, initiator);
		this.otherPlayer = otherPlayer;
		this.give = give;
		this.receive = receive;
	}
	
	/**Trade or donate cards
	 * recieve can be null, these means the cards are donated
	 * @require give != null
	 */
	@Override
	public void handle() throws IllegalActionException {
		if(!(initiator == game.getActivePlayer() || otherPlayer == game.getActivePlayer())) throw new IllegalActionException("Only trades with the active player are allowed");
		if(!initiator.isValidTrade(give,receive,true) || !otherPlayer.isValidTrade(receive, give, false)) throw new IllegalActionException("No valid trade");
	}
	
	public List<Card> getGivenCards() {
		return give;
	}
	
	public List<Card> getReceivedCards() {
		return receive;
	}
	
	public Player getOtherPlayer() {
		return otherPlayer;
	}
}
