package coinmachine;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CoinAcceptingUI extends JFrame implements Observer {

	private JLabel labelCoins, labelAcceptingCoins;
	private JPanel panelShowCoins,panelAcceptingCoins;
	private JTextField fieldNumCoins;
	
	public CoinAcceptingUI() {
		this.setTitle("Coin Acceting");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}

	public void initComponents() {
		this.setLayout(new GridLayout(2,1));

		panelShowCoins = new JPanel();
		panelShowCoins.setLayout(new FlowLayout());
		panelAcceptingCoins = new JPanel();
		panelAcceptingCoins.setLayout(new FlowLayout());

		labelCoins = new JLabel("#Coins: ");
		labelAcceptingCoins = new JLabel("Accepting Coins");
		labelAcceptingCoins.setForeground(Color.GREEN);
		fieldNumCoins = new JTextField("0",6);
		fieldNumCoins.setEditable(false);

		this.add(panelShowCoins);
		this.add(panelAcceptingCoins);
		panelShowCoins.add(labelCoins);
		panelShowCoins.add(fieldNumCoins);
		panelAcceptingCoins.add(labelAcceptingCoins);
	}

	public void run() {
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void update(Observable subject, Object info) {
		fieldNumCoins.setText(String.valueOf(((List<Coin>) info).size()));
		if(((List<Coin>) info).size() == 10) {
			labelAcceptingCoins.setText("Full");
			labelAcceptingCoins.setForeground(Color.RED);
		}
		
		
	}

}
