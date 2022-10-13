import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class ShowMenu extends JFrame{
    ShowMenu(User currentUser){
        Font  f1  = new Font(Font.DIALOG,  Font.BOLD, 16);
		JLabel title = new JLabel("Menu");
		title.setBounds(200, 22, 80, 20);
		title.setFont(f1);
		add(title);

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		model.addColumn("ID");
      	model.addColumn("Name");
      	model.addColumn("Price");

        PreparedStatement statement = null;
        Statement getMenu = null;
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root", "magesh123");
            getMenu = conn.createStatement();
            ResultSet menu = getMenu.executeQuery("select * from menu");
            while(menu.next()){
                model.addRow(new Object[]{menu.getInt(1), menu.getString(2), menu.getInt(3)});
            }
        } catch(Exception e){
            System.err.println(e);
        } finally{
            try { statement.close(); } catch (Exception e) { }
            try { getMenu.close(); } catch (Exception e) { }
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
