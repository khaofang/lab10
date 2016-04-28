package coinmachine;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class CoinMachineObserver implements Observer {

	public void update(Observable subject, Object info) {
		if(info != null) {
			int balance = 0;
			for(int i=0 ; i < ((List<Coin>) info).size() ; i++) {
				balance += ((List<Coin>) info).get(i).getValue();
			}
			System.out.println("Balance: " + balance);
		}
	}

}
