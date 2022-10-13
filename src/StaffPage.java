import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class StaffPage extends JFrame{
	StaffPage(User currentUser){
		Font  f1  = new Font(Font.DIALOG,  Font.BOLD, 16);
		
		JLabel title = new JLabel("Welcome " + currentUser.name);
		title.setBounds(20, 20, 300, 20);
		title.setFont(f1);
		add(title);

		JButton addFood = new JButton("Add Food");
		addFood.setBounds(60, 140, 120, 40);
		add(addFood);
		addFood.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new AddFoodMenu(currentUser);
				dispose();
			}
		});
		
		JButton showMenu = new JButton("Show Menu");
		showMenu.setBounds(200, 140, 120, 40);
		add(showMenu);
		showMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new ShowMenu(currentUser);
				dispose();
			}
		});

		JButton displayDetails = new JButton("Display Details");
		displayDetails.setBounds(130, 200, 130, 40);
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
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
