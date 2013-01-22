import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@Suite.SuiteClasses({ 
		GameFactoryTest.class, 
		GameTest.class, 
		TestCard.class,
		TestField.class, 
		TestPlayer.class, 
		ActionPlantBeanCardTest.class,
		ActionDrawCardsTest.class} )
public class AllTests {

}