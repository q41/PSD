/**
 * 
 */
package states;

import actions.Harvest;
import actions.PlantBean;
import main.Game;

/**
 * @author Damiaan
 *
 */
public class PlantState extends TurnState {

	private boolean isFirstPlant = true;
	
	/**
	 * @param context
	 * @param name
	 */
	public PlantState(Game context) {	
		super(context);
	}
	
	/* (non-Javadoc)
	 * @see states.TurnState#buildStateMapping()
	 */
	@Override
	public void buildStateMapping() {
		if (isFirstPlant) {
			isFirstPlant = false;
			addActionState(new PlantBean(getContext()), this);
		} else {
			addActionState(new PlantBean(getContext()), new DrawState(getContext()));
		}
		if (getContext().getCurrentPlayer().getBeanFields().size() > 0) {
			addActionState(new Harvest(getContext()), this);
		}
	}
	
	
}
