package bohnanza.alcabohne.actions;
import java.util.ArrayList;
import java.util.List;

import bohnanza.alcabohne.model.AlCabhoneGame;
import bohnanza.alcabohne.model.MobBoss;
import bohnanza.core.Action;
import bohnanza.core.BeanCard;
import bohnanza.core.IllegalActionException;
import bohnanza.core.Player;

public class RevealBean extends Action<AlCabhoneGame> {

	public RevealBean(AlCabhoneGame game, Player initiator) {
		super(game, initiator);
	}

	/** Reveals beans from the draw deck and discard pile until piles of 3 different bean types are made */ 
	@Override
	public void innerHandle() {
		BeanCard card;
		do {
			card = (BeanCard) game.drawCard();
		} while(addToExistingPile(card));

		List<BeanCard> newPile = new ArrayList<BeanCard>();
		newPile.add(card);
		game.getRevealedBeans().add(newPile);
		do {
			try {
				card = (BeanCard) game.drawDiscardedCard();
			} catch (IllegalActionException e) { break; }
		} while(addToExistingPile(card));
		game.addCardToDiscardPile(card);
	}

	/** Checks is card has the same type as one of the already revealed beans or
	 * the mob bosses' beans. If so adds card to this pile. */
	private boolean addToExistingPile(BeanCard card) {
		List<List<BeanCard>> beanPiles = new ArrayList<List<BeanCard>>();
		for(MobBoss boss : game.getMobbosses()) {
			beanPiles.add(boss.getCards());
		}
		beanPiles.addAll(game.getRevealedBeans());
		for(List<BeanCard> pile : beanPiles) {
			if(pile.get(0).getType() == card.getType()) {
				pile.add(card);
				return true;
			}
		}
		return false;
	}
}
