import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JEditorPane;

public class Gui_Boo {

	private JFrame frame;
	private JButton btnNorth;
	private JButton btnStop;
	private JButton btnEast;
	private JButton btnWest;
	private JButton btnSouth;
	private JEditorPane editorPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Gui_Boo window = new Gui_Boo();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui_Boo() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 365, 359);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnNorth = new JButton("Forwards");
		btnNorth.setBounds(0, 0, 349, 56);
		btnNorth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("up");
			}
		});
		frame.getContentPane().add(btnNorth);
		
		btnSouth = new JButton("Backwards");
		btnSouth.setBounds(0, 264, 349, 56);
		btnSouth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("terug");
			}
		});
		frame.getContentPane().add(btnSouth);
		
		btnEast = new JButton("Right");
		btnEast.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnEast.setBounds(292, 54, 57, 174);
		btnEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("rechts");
			}
		});
		frame.getContentPane().add(btnEast);
		
		btnStop = new JButton("Break");
		btnStop.setBounds(57, 54, 235, 132);
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("stop");
			}
		});
		frame.getContentPane().add(btnStop);
		
		btnWest = new JButton("Left");
		btnWest.setBounds(0, 54, 57, 174);
		btnWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("links");
			}
		});
		frame.getContentPane().add(btnWest);
		
		editorPane = new JEditorPane();
		editorPane.setBounds(67, 197, 215, 56);
		editorPane.setText("1\n2\n3");
		frame.getContentPane().add(editorPane);
	}
}
