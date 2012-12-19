package states;
import actions.Harvest;
import actions.PlantBean;
import main.*;

public class PlantState extends TurnState {

	private boolean isFirstPlant = true;
	
	/**
	 * @param context
	 * @param name
	 */
	public PlantState(Game context, Player activePlayer) {	
		super(context, activePlayer);
	}
	
	public void buildStateMapping() {
		if (isFirstPlant) {
			isFirstPlant = false;
			addActionState(new PlantBean(getContext()), this);
		} else {
			addActionState(new PlantBean(getContext()), new DrawState(getContext(),activePlayer));
		}
		if (getContext().getCurrentPlayer().getBeanFields().size() > 0) {
			addActionState(new Harvest(getContext()), this);
		}
	}
	
	
}