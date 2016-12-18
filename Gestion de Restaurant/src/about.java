import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
public class about extends JFrame {

    ImageIcon aboutimg = new ImageIcon("icons/k.jpg");
    JLabel lbl = new JLabel(aboutimg);
    Font fontlbl = new Font("Verdana",Font.BOLD,18);
    Color col = new Color(0,0,213);
    JLabel lbl2 = new JLabel("Notre projet Java");
    JLabel lbl3 = new JLabel("Gestion de restaurant");
    JLabel lbl4 = new JLabel("[FAST FOOD]");
    JLabel lbl5 = new JLabel("Coded by :");
    JLabel lbl6 = new JLabel("FAKHRI BRAHEM");
    JLabel lbl7 = new JLabel("&");
    JLabel lbl8 = new JLabel("Med AMINE KAABI");
    Font fontlbl2 = new Font("Verdana",Font.BOLD,22);

    

    


	
	public about()
	{
		this.setTitle("ABOUT : ");
		this.setSize(360, 480);
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setResizable(false);
		this.setLayout(null);

		
		
		lbl2.setFont(fontlbl); lbl2.setForeground(col); lbl2.setBounds(10, 25, 200, 25);  this.add(lbl2);
		lbl3.setFont(fontlbl); lbl3.setForeground(col); lbl3.setBounds(10, 50, 250, 25);  this.add(lbl3);
		lbl4.setFont(fontlbl); lbl4.setForeground(col); lbl4.setBounds(10, 75, 250, 25); this.add(lbl4);
		lbl5.setFont(fontlbl); lbl5.setForeground(Color.RED); lbl5.setBounds(160, 280, 250, 25);this.add(lbl5);
		lbl6.setFont(fontlbl2); lbl6.setForeground(col); lbl6.setBounds(120, 310, 250, 25); this.add(lbl6);
		lbl7.setFont(fontlbl); lbl7.setForeground(Color.RED); lbl7.setBounds(170, 330, 250, 25);this.add(lbl7);
		lbl8.setFont(fontlbl2); lbl8.setForeground(col); lbl8.setBounds(120, 350, 250, 25); this.add(lbl8);
		
		lbl.setSize(360,480);
		this.add(lbl);
	

	}
}
