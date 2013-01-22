package bohnanza.alcabohne.states;
import bohnanza.alcabohne.actions.GiftBeanToMafia;
import bohnanza.core.Game;
import bohnanza.core.actions.Action;
import bohnanza.core.actions.Harvest;
import bohnanza.core.actions.NextPhase;
import bohnanza.core.states.TurnState;


public class GiftMafiaState extends TurnState {

	public GiftMafiaState(Game context) {
		super(context);
	}

	@Override
	protected void reset() {
		if(needsToPay()) {
			addAction(GiftBeanToMafia.class);
			addAction(Harvest.class);
		} else {
			addAction(NextPhase.class);
		}
	}

	@Override
	protected boolean handled(Action action) {
		if(action instanceof GiftBeanToMafia || action instanceof NextPhase) {
			return true;
		} else if(action instanceof Harvest && !needsToPay()) {
			removeAllActions();
			addAction(NextPhase.class);
		}
		return false;
	}

	private boolean needsToPay() {
		//TODO return true if mafia collects same beans as player
		return false;
	}
}
