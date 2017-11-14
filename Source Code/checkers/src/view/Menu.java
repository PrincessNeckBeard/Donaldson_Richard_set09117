package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	boolean player1 = false;
	boolean player2 = false;
	
	
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblCheckers = new JLabel("Checkers.");
		lblCheckers.setFont(new Font("Myriad Pro", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCheckers = new GridBagConstraints();
		gbc_lblCheckers.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckers.gridx = 4;
		gbc_lblCheckers.gridy = 3;
		frame.getContentPane().add(lblCheckers, gbc_lblCheckers);
		
		JButton btnPlayerVsAI = new JButton("Player Vs AI");
		btnPlayerVsAI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				player1 = true;
				
				
				
				
			}
		});
		GridBagConstraints gbc_btnPlayerVsAI = new GridBagConstraints();
		gbc_btnPlayerVsAI.insets = new Insets(0, 0, 5, 5);
		gbc_btnPlayerVsAI.gridx = 3;
		gbc_btnPlayerVsAI.gridy = 5;
		frame.getContentPane().add(btnPlayerVsAI, gbc_btnPlayerVsAI);
		
		JButton btnPlayerVsPlayer = new JButton("Player Vs Player");
		btnPlayerVsPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			player1 = true;
			player2 = true;
			}
		});
		GridBagConstraints gbc_btnPlayerVsPlayer = new GridBagConstraints();
		gbc_btnPlayerVsPlayer.anchor = GridBagConstraints.SOUTH;
		gbc_btnPlayerVsPlayer.insets = new Insets(0, 0, 5, 5);
		gbc_btnPlayerVsPlayer.gridx = 4;
		gbc_btnPlayerVsPlayer.gridy = 5;
		frame.getContentPane().add(btnPlayerVsPlayer, gbc_btnPlayerVsPlayer);
		
		JButton btnAIVsAI = new JButton("AI Vs AI");
		btnAIVsAI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnAIVsAI = new GridBagConstraints();
		gbc_btnAIVsAI.anchor = GridBagConstraints.NORTH;
		gbc_btnAIVsAI.insets = new Insets(0, 0, 5, 5);
		gbc_btnAIVsAI.gridx = 5;
		gbc_btnAIVsAI.gridy = 5;
		frame.getContentPane().add(btnAIVsAI, gbc_btnAIVsAI);
		
		JButton btnRules = new JButton("Rules");
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnRules = new GridBagConstraints();
		gbc_btnRules.insets = new Insets(0, 0, 0, 5);
		gbc_btnRules.gridx = 3;
		gbc_btnRules.gridy = 7;
		frame.getContentPane().add(btnRules, gbc_btnRules);
		
		JButton btnPrevious = new JButton("Previous Games");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			}
		});
		GridBagConstraints gbc_btnPrevious = new GridBagConstraints();
		gbc_btnPrevious.insets = new Insets(0, 0, 0, 5);
		gbc_btnPrevious.gridx = 5;
		gbc_btnPrevious.gridy = 7;
		frame.getContentPane().add(btnPrevious, gbc_btnPrevious);
	}

}
