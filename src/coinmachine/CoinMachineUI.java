package coinmachine;


import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class CoinMachineUI extends JFrame implements Observer {
	JProgressBar coinFullBar;
	
	public CoinMachineUI() {
		this.setTitle("Coin Machine");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	
	public void initComponents() {
		coinFullBar = new JProgressBar();
		coinFullBar.setToolTipText("0");
		this.add(coinFullBar); // testtest
	}
	
	public void run() {
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
