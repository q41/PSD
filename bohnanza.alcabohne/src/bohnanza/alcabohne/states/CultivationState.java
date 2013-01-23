package bohnanza.alcabohne.states;
import bohnanza.alcabohne.actions.CultivateRevealedBeanType;
import bohnanza.alcabohne.actions.GiftBeanToMobb;
import bohnanza.alcabohne.model.Game;
import bohnanza.core.Action;
import bohnanza.core.TurnState;
import bohnanza.core.shared.actions.Harvest;
import bohnanza.core.shared.actions.NextPhase;

public class CultivationState extends TurnState {

	public CultivationState(Game context) {
		super(context);
		addAction(GiftBeanToMobb.class);
		addAction(Harvest.class);
		addAction(CultivateRevealedBeanType.class);
	}

	@Override
	protected boolean handled(Action action) {
		if(action instanceof CultivateRevealedBeanType && ((Game)context).getRevealedBeans().isEmpty()) {
			removeAction(CultivateRevealedBeanType.class);
			addAction(NextPhase.class);
		}
		return action instanceof NextPhase;
	}

}
