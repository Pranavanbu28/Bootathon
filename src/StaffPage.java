import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class StaffPage extends JFrame{
	StaffPage(User currentUser){
		Font  f1  = new Font(Font.DIALOG,  Font.BOLD, 16);
		
		JLabel title = new JLabel("Welcome " + currentUser.name);
		title.setBounds(20, 20, 300, 20);
		// title.setForeground(Color.yellow);
		title.setFont(f1);
		add(title);
		
		// Color purp = new Color(122,136,222);
		// this.getContentPane().setBackground(purp);

		JButton addFood = new JButton("Add Food");
		addFood.setBounds(60, 140, 120, 40);
		// addFood.setBackground(Color.yellow);
		add(addFood);
		addFood.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new AddFoodInMenu(currentUser);
				dispose();
			}
		});
		
		JButton showMenu = new JButton("Show Menu");
		showMenu.setBounds(200, 140, 120, 40);
		// showMenu.setBackground(Color.yellow);
		add(showMenu);
		showMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new ShowMenu(currentUser);
				dispose();
			}
		});

		JButton displayDetails = new JButton("Display Details");
		displayDetails.setBounds(130, 200, 130, 40);
		// displayDetails.setBackground(Color.yellow);
		add(displayDetails);
		displayDetails.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new DisplayDetails(currentUser);
				dispose();
			}
		});
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(300, 20, 70, 25);
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Login();
				dispose();
			}
		});
		add(backButton);
		
		setLayout(null);
		setVisible(true);
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	// public static void main(String[] args) {
	// 	new StaffPage();
	// }
}
