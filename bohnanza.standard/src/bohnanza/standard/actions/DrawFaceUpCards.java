package bohnanza.standard.actions;

import java.util.ArrayList;
import java.util.List;

import bohnanza.core.Action;
import bohnanza.core.Card;
import bohnanza.core.IllegalActionException;
import bohnanza.core.Player;
import bohnanza.standard.model.Game;

public class DrawFaceUpCards extends Action {

	public DrawFaceUpCards(Game game, Player initiator) {
		super(game, initiator);
	}
	
	@Override
	public void handle() throws IllegalActionException {
		List<Card> asideCards = new ArrayList<Card>();
		asideCards.add(game.drawCard());
		asideCards.add(game.drawCard());
		initiator.setFaceUpCards(asideCards);
	}

}