import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;


//Plutot RUD :DD
public class CRUD extends JFrame implements ActionListener  
{
	    Font fontbtn = new Font("Courier", Font.BOLD,18);
	    Font fonttxt = new Font("Verdana", Font.BOLD,14);
	    Color col = new Color(0,0,213);  //Blue

        JTextArea edit = new JTextArea(30, 60);
        JButton read = new JButton("Read File.txt");
        JButton write = new JButton("Update File.txt");
        JButton btnQuit = new JButton("Quitter");
        JPanel p1=new JPanel();
        JLabel chemin = new JLabel("Chemin du fichier : ");
    	JTextField chemintxt = new JTextField("Chemin du fichier",32);
    	
    	String chem;


        
        public CRUD(){
        	this.setTitle("TextArea Load");
            this.getContentPane().add( new JScrollPane(edit), BorderLayout.NORTH );
            this.getContentPane().add(p1, BorderLayout.SOUTH);
            this.getContentPane().add(read, BorderLayout.WEST);
        	read.setPreferredSize(new Dimension(160, 60));
            this.getContentPane().add(write, BorderLayout.EAST);
            this.getContentPane().add(btnQuit, BorderLayout.CENTER);
            //this.getContentPane().add(p1, BorderLayout.SOUTH);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.pack();
            this.setLocationRelativeTo( null );
            this.setVisible(true);
            this.getContentPane().add(p1, BorderLayout.SOUTH);
        	p1.setLayout(new FlowLayout ());
        	p1.add(chemin);
        	p1.add(chemintxt);
        	
        	
        	read.setFont(fontbtn);
        	write.setFont(fontbtn);
        	btnQuit.setFont(fontbtn);
        	chemin.setFont(fontbtn);
        	chemintxt.setFont(fonttxt);
        	chemintxt.setForeground(col);
        	
            edit.setText("The\nFile\nContent");
            edit.append("\nWill\nbe\nshown\nhere");

            btnQuit.addActionListener(this);

        
        read.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    chem = chemintxt.getText();
                    FileReader reader = new FileReader(chem);
                    BufferedReader br = new BufferedReader(reader);
                    edit.read( br, null );
                    br.close();
                    edit.requestFocus();
                }
                catch(Exception e2) { System.out.println(e2); }
            }
        });

        write.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    chem = chemintxt.getText();
                    FileWriter writer = new FileWriter(chem);
                    BufferedWriter bw = new BufferedWriter( writer );
                    edit.write( bw );
                    bw.close();
                    edit.requestFocus();
                }
                catch(Exception e2) {}
            }
        });

        }
    	public void actionPerformed(ActionEvent ae) {
    		//Boutton Quitter
    		if(ae.getSource().equals(btnQuit)) {
                this.setVisible(false);
                                    }

        
                }
}