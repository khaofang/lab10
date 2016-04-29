package coinmachine;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

public class CoinMachineUI extends JFrame implements Observer {
	
	private CoinMachine machine;
	private JButton button1Baht, button5Baht, button10Baht;
	private JLabel labelBalance,labelStatus;
	private JPanel panelCoinStatus,panelInserting;
	private JProgressBar barCoinStatus;
	private TitledBorder borderCoinButton;
	
	public CoinMachineUI(CoinMachine machine) {
		this.machine = machine;
		this.setTitle("Coin Machine");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	
	public void initComponents() {
		ClassLoader loader = this.getClass().getClassLoader();
		URL url_1baht_png = loader.getResource("images/1baht.png") ;
		URL url_5baht_png = loader.getResource("images/5baht.png") ; 
		URL url_10baht_png = loader.getResource("images/10baht.png");
		ImageIcon image_1baht_png = new ImageIcon(url_1baht_png);
		ImageIcon image_5baht_png = new ImageIcon(url_5baht_png);
		ImageIcon image_10baht_png = new ImageIcon(url_10baht_png);
		
		this.setLayout(new BorderLayout());
		panelCoinStatus = new JPanel();
		panelCoinStatus.setLayout(new FlowLayout());
		panelInserting = new JPanel();
		panelInserting.setLayout(new FlowLayout());
		labelBalance = new JLabel("Balance: 0");
		labelStatus = new JLabel("Status:");
		barCoinStatus = new JProgressBar(0, machine.getCapacity());
		barCoinStatus.setStringPainted(true);
		barCoinStatus.setString("0");
		borderCoinButton = BorderFactory.createTitledBorder("Insert Money");
		borderCoinButton.setTitleJustification(TitledBorder.LEFT);
		button1Baht = new JButton(image_1baht_png);
		button5Baht = new JButton(image_5baht_png);
		button10Baht = new JButton(image_10baht_png);
		
		this.add(panelCoinStatus, BorderLayout.NORTH);
		this.add(panelInserting, BorderLayout.CENTER);
		panelCoinStatus.add(labelBalance);
		panelCoinStatus.add(labelStatus);
		panelCoinStatus.add(barCoinStatus);
		panelInserting.setBorder(borderCoinButton);
		panelInserting.add(button1Baht);
		panelInserting.add(button5Baht);
		panelInserting.add(button10Baht);
		
		button1Baht.addActionListener(new InsertMoneyListener(1));
		button5Baht.addActionListener(new InsertMoneyListener(5));
		button10Baht.addActionListener(new InsertMoneyListener(10));
	}
	
	public void run() {
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void update(Observable subject, Object info) {
		int balanceUpdate = 0;
		barCoinStatus.setValue(((List<Coin>) info).size());
		barCoinStatus.setString(String.valueOf(((List<Coin>) info).size()));
		for(int i=0 ; i<((List<Coin>) info).size() ; i++){
			balanceUpdate += ((List<Coin>) info).get(i).getValue();
		}
		labelBalance.setText("Balance: " + String.valueOf(balanceUpdate));
	}
	
	class InsertMoneyListener implements ActionListener {
		private int money;
		
		public InsertMoneyListener(int money) {
			this.money = money;
		}
		
		public void actionPerformed(ActionEvent evt) {
			machine.insert(new Coin(money));
		}	
	}
}
