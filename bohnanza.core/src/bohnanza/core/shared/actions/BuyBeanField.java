package bohnanza.core.shared.actions;
import bohnanza.core.Action;
import bohnanza.core.BaseGame;
import bohnanza.core.IllegalActionException;
import bohnanza.core.Player;

public class BuyBeanField extends Action<BaseGame> {

	public BuyBeanField(BaseGame game, Player initiator) {
		super(game, initiator);
	}

	/** Buys an additional bean field
	 * @throws IllegalActionException if action is not allowed (player has insufficient coins or already a third bean field) */
	@Override
	protected void innerHandle() throws IllegalActionException {
		initiator.buyField();
	}

}