package bohnanza.alcabohne.actions;

import java.util.List;
import bohnanza.alcabohne.model.EBeanType;
import bohnanza.alcabohne.model.Game;
import bohnanza.core.Action;
import bohnanza.core.BeanCard;
import bohnanza.core.BeanField;
import bohnanza.core.IBeanType;
import bohnanza.core.IllegalActionException;
import bohnanza.core.Player;

public class CultivateRevealedBeanType extends Action {
	
	private final IBeanType beanType;
	private BeanField emptyField;

	public CultivateRevealedBeanType(Game game, Player initiator, EBeanType beanType) {
		super(game, initiator);
		this.beanType = beanType;
	}

	@Override
	protected void innerHandle() throws IllegalActionException {
		for(List<BeanCard> beans : ((Game)game).getRevealedBeans()) {
			if(beans.get(0).getType()==beanType) {
				plant(beans);
				return;
			}
		}
		throw new IllegalActionException("The bean type is not revealed");
	}
	
	private void plant(List<BeanCard> beans) throws IllegalActionException {
		for(BeanField field : initiator.getBeanFields()) {
			if(field.getCards().isEmpty()) emptyField = field;
			else if(field.getTypeOf()==beanType) {
				((Game)game).getRevealedBeans().remove(beans);
				field.addAllCards(beans);
				return;
			}
		}
		if(emptyField!=null) {
			((Game)game).getRevealedBeans().remove(beans);
			emptyField.addAllCards(beans);
		} else throw new IllegalActionException("Nowhere to plant bean");
	}

}