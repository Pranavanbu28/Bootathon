import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class OrderHistory extends JFrame{
    OrderHistory(User currentUser){
        Font  f1  = new Font(Font.DIALOG,  Font.BOLD, 16);
		JLabel title = new JLabel("Order History");
		title.setBounds(200, 22, 200, 20);
		title.setFont(f1);
		add(title);

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		model.addColumn("Order ID");
      	model.addColumn("Food");
      	model.addColumn("Price");

        PreparedStatement statement = null;
        Statement getOrderID = null;
        Statement getFood = null;
        Statement getFromMenu = null;
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root", "magesh123");
            getOrderID = conn.createStatement();
            ResultSet allOrders = getOrderID.executeQuery("select order_id, total_price from orders where customer = " + currentUser.id);
            while(allOrders.next()){
                getFood = conn.createStatement();
                ResultSet foodID = getFood.executeQuery("select food from order_items where order_id = "+allOrders.getInt(1));
                StringBuilder allFood = new StringBuilder();
                while(foodID.next()){
                    int currentFood = foodID.getInt(1);
                    getFromMenu = conn.createStatement();
                    ResultSet fromMenu = getFromMenu.executeQuery("select food_name from menu where food_id = " + currentFood);
                    fromMenu.next();
                    allFood.append(fromMenu.getString(1)+" ");
                }
                model.addRow(new Object[]{allOrders.getInt(1), allFood.toString(), allOrders.getInt(2)});
            }
        } catch(Exception e){
            System.err.println(e);
        } finally{
            try { statement.close(); } catch (Exception e) { }
            try { getOrderID.close(); } catch (Exception e) { }
            try { getFood.close(); } catch (Exception e) { }
            try { getFromMenu.close(); } catch (Exception e) { }
			try { conn.close(); } catch (Exception e) { }
        }

		table.setBounds(50, 100, 400, 100);
        JPanel panel = new JPanel();
         panel.add(new JScrollPane(table));
         panel.setBounds(0,0,500, 400);
        JScrollPane jpane = new JScrollPane(panel);
        jpane.setBounds(1,50,480,250);
        add(jpane);

		JButton backButton = new JButton("Back");
		backButton.setBounds(200, 310, 100, 40);
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
                new StaffPage(currentUser);
                dispose();
			}
		});
		add(backButton);

		setLayout(null);
		setSize(500,400);
        setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
