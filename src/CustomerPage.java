import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerPage extends JFrame{
	CustomerPage(User currentUser){
		Font  f1  = new Font(Font.DIALOG,  Font.BOLD, 16);
		
		JLabel title = new JLabel("Welcome " + currentUser.name);
		title.setBounds(20, 20, 300, 20);
		title.setFont(f1);
		add(title);

		JButton orderFood = new JButton("Order Food");
		orderFood.setBounds(60, 140, 120, 40);
		add(orderFood);
		
		JButton orderHistory = new JButton("Order History");
		orderHistory.setBounds(200, 140, 120, 40);
		add(orderHistory);
		orderHistory.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new OrderHistory(currentUser);
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
