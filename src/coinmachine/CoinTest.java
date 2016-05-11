package coinmachine;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Some JUnit 4 tests of Coin, especially equals.
 * @author jim
 */
public class CoinTest {

	@Before
	public void setUp() throws Exception {
	}

	
	/** test constructor and value of coins */
	@Test
	public void testCoinValue() {
		Coin coin1 = new Coin(5);
		Coin coin2 = new Coin(10);
		Coin coin3 = new Coin(1);
		assertEquals(10, coin2.getValue());
		assertEquals(5, coin1.getValue());
		assertEquals(1, coin3.getValue());
	}

	@Test
	public void testNotEqualsNull() {
		Coin coin = new Coin(5);
		Coin nullcoin = null;
		assertFalse( coin.equals(nullcoin) );
	}

	@Test
	public void testEqualsNoncoin() {
		Coin coin = new Coin(5);
		assertFalse( coin.equals("5-Baht") );
	}

	@Test
	public void testEqualsByValue() {
		Coin coin1 = new Coin(10,"baht");
		assertEquals( coin1, new Coin(10,"BAHT".toLowerCase()) ); // test for String == String
		assertFalse( coin1.equals( new Coin(9,"baht") ));
		assertFalse( coin1.equals( new Coin(11,"baht") ));
		assertFalse( coin1.equals( new Coin(10,"Ringgit") ));
	}

	/** Equals should not compare objects using toString. */
	@Test
	public void testEqualsNotUsingToString() {
		Coin coin = new Coin(10,"Yen");
		assertFalse( coin.equals( new Coin(1,"0-Yen") ) );
		assertFalse( coin.equals( new Coin(1,"0 Yen") ) );
		assertFalse( coin.equals( new Coin(1,"0Yen") ) );
	}

    public static void main(String [] args) {
        org.junit.runner.JUnitCore.main("coinmachine.CoinTest");
    }

}
