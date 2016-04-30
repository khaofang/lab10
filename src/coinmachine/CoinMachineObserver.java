package coinmachine;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Observer of Demo that used to update balance come in to machine. Show on
 * console about current balance when coin is come in.
 * @author Chayanin Punjakunaporn
 *
 */
public class CoinMachineObserver implements Observer {

	/**
	 * Update by observer. Show about information on console.
	 */
	public void update(Observable subject, Object info) {
		if (info != null) {
			int balance = 0;
			for (int i = 0; i < ((List<Coin>) info).size(); i++)
				balance += ((List<Coin>) info).get(i).getValue();
			System.out.println("Balance: " + balance);
		}
	}

}
