package bohnanza.core.states;
import bohnanza.core.*;
import bohnanza.core.actions.*;

public class TradeState extends TurnState {

	private ProposeTrade proposition;
	
	public TradeState(Game context) {
		super(context);
	}

	@Override
	protected boolean handled(Action action) {
		if(action instanceof DrawFaceUpCards) {
			removeAction(DrawFaceUpCards.class);
			startTrade();			
		} else if(action instanceof NextPhase) {
			return true;
		} else if(action instanceof ProposeTrade){
			proposition = (ProposeTrade)action;
			removeAction(SetAsideCard.class);
			for(Player player: context.getPlayers()) {
				removeAction(player, ProposeTrade.class);
			}
			addAction(proposition.getActivePlayer(), AcceptTrade.class);
			addAction(proposition.getActivePlayer(), DeclineTrade.class);
		} else if(action instanceof AcceptTrade || action instanceof DeclineTrade) {
			startTrade();
			
		}
		if(context.getActivePlayer().getFaceUpCards().isEmpty()) {
			addAction(NextPhase.class);
		}
		return false;
	}
	
	private void startTrade() {
		addAction(SetAsideCard.class);
		for(Player player: context.getPlayers()) {
			if(!player.equals(context.getActivePlayer())){
				addAction(player, ProposeTrade.class);
			}
		}
	}

	@Override
	protected void reset() {
		removeAllActions();
		addAction(DrawFaceUpCards.class);
	}
}