package bohnanza.standard.core.states;
import java.util.ArrayList;
import java.util.List;

import bohnanza.standard.core.*;
import bohnanza.standard.core.actions.*;

public class TurnStart extends TurnState {
	
	public TurnStart(Game context) {
		super(context);
	}

	@Override
	protected boolean handled(Action action) {
		return action instanceof NextPlayer;
	}

	@Override
	protected void reset() {
		removeAllActions();
		addAction(context.getActivePlayer(), NextPlayer.class);
	}

}