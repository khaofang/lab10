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

/**
 * Make GUI of counting of coin accepting . Show that how many coins that
 * machine receives. If machine receives coins to it capacity, it will show that it is full, and can't add coin to it then.
 * @author Chayanin Punjakunaporn
 */
public class CoinAcceptingUI extends JFrame implements Observer {

	/** Attribute */
	private JLabel labelCoins, labelAcceptingCoins;
	private JPanel panelShowCoins, panelAcceptingCoins;
	private JTextField fieldNumCoins;

	/** Constructor, initial this GUI. */
	public CoinAcceptingUI() {
		this.setTitle("Coin Acceting");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}

	/** Initial all of components in GUI. */
	public void initComponents() {
		this.setLayout(new GridLayout(2, 1));

		panelShowCoins = new JPanel();
		panelShowCoins.setLayout(new FlowLayout());
		panelAcceptingCoins = new JPanel();
		panelAcceptingCoins.setLayout(new FlowLayout());

		labelCoins = new JLabel("#Coins: ");
		labelAcceptingCoins = new JLabel("Accepting Coins");
		labelAcceptingCoins.setForeground(Color.GREEN);
		fieldNumCoins = new JTextField("0", 4);
		fieldNumCoins.setEditable(false);

		this.add(panelShowCoins);
		this.add(panelAcceptingCoins);
		panelShowCoins.add(labelCoins);
		panelShowCoins.add(fieldNumCoins);
		panelAcceptingCoins.add(labelAcceptingCoins);
	}

	/** Run this GUI. */
	public void run() {
		this.pack();
		this.setVisible(true);
	}

	/**
	 * Update by this class's observer. Update a number of coins that be counted
	 * from machine, and show on text field in GUI.
	 */
	@Override
	public void update(Observable subject, Object info) {
		fieldNumCoins.setText(String.valueOf(((List<Coin>) info).size()));
		if (((List<Coin>) info).size() == 10) {
			labelAcceptingCoins.setText("Full");
			labelAcceptingCoins.setForeground(Color.RED);
		}
	}
}
