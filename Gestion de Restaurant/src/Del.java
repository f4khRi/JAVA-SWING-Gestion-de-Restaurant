import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Del extends JFrame implements ActionListener
{
    Font fontbtn = new Font("Courier", Font.BOLD,18);
    Font fonttxt = new Font("Verdana", Font.BOLD,14);
    Color col = new Color(0,0,213);  //Blue
	
	 JTextArea txtar = new JTextArea(30, 60);
     JButton read = new JButton("Read");
     JButton btndel = new JButton("Delete");
     JButton btnQuit = new JButton("Quitter");
     JPanel p1=new JPanel();
	 JLabel chemin = new JLabel("Chemin du fichier                      : ");
	 JLabel ligDep = new JLabel("Entrer la ligne de départ ici      : ");
	 JLabel nbLig = new JLabel("Entrez le nombre de lignes ici :");
	 JTextField chemin_txt = new JTextField("Chemin du fichier",44);
	 JTextField ligDeptxt = new JTextField("Entrer la ligne de départ ici",44);
	 JTextField nbligtxt = new JTextField("Entrez le nombre de lignes ici",44);
	 
	 String chemi;
	 int ldep,nlig;
	
	
	public Del(){
	
		this.setTitle("Delete From a file :");
        this.getContentPane().add( new JScrollPane(txtar), BorderLayout.NORTH );
        this.getContentPane().add(p1, BorderLayout.SOUTH);
        this.getContentPane().add(read, BorderLayout.WEST);
    	read.setPreferredSize(new Dimension(130, 100));
        this.getContentPane().add(btndel, BorderLayout.EAST);
        this.getContentPane().add(btnQuit, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo( null );
        this.setVisible(true);
    	p1.setLayout(new GridLayout (3,2));
    	p1.add(chemin);
    	p1.add(chemin_txt);
    	p1.add(ligDep);
    	p1.add(ligDeptxt);
    	p1.add(nbLig);
    	p1.add(nbligtxt);
        txtar.setText("Hello");
        txtar.append("\nFirst : READ THE FILE WITH BUTTON READ\nHOW ? \n\n1-saisir le chemin\n2-cliquez sur read"
        		+ "\n==================\nSecond : DELETE FROM THE FILE \nHOW? \n\n1-Entrer la ligne de départ \n 2-Entrez le nombre de lignes \n3- Cliquez sur delete");
        
        txtar.setEditable(false);
        read.setFont(fontbtn);
        btndel.setFont(fontbtn);
        btnQuit.setFont(fontbtn);
        chemin.setFont(fontbtn);
        ligDep.setFont(fontbtn);
        nbLig.setFont(fontbtn);
        chemin_txt.setFont(fonttxt);
        chemin_txt.setForeground(col);
        ligDeptxt.setFont(fonttxt);
        ligDeptxt.setForeground(col);
        nbligtxt.setFont(fonttxt);
        nbligtxt.setForeground(col);
        
       btnQuit.addActionListener(this);
    
	
       //READ
        
        read.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    chemi = chemin_txt.getText();
                    FileReader reader1 = new FileReader(chemi);
                    BufferedReader br1 = new BufferedReader(reader1);
                    txtar.read( br1, null );
                    br1.close();
                    txtar.requestFocus();
                }
                catch(Exception e2) { System.out.println(e2); }
            }
        });
        
        
        //DELETE
        
        btndel.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	try
            	{
	          chemi = chemin_txt.getText();
	          ldep = Integer.valueOf(ligDeptxt.getText());
	          nlig = Integer.valueOf(nbligtxt.getText());
		      
			   BufferedReader br2=new BufferedReader(new FileReader(chemi));
 
			   StringBuffer sb=new StringBuffer("");
 
			   //Keep tracking the line number
			   int linenumber=1;
			   String line;
 
			   while((line=br2.readLine())!=null)
			   {
				//Storing ay valid line fil string buffer
				if(linenumber<ldep||linenumber>=ldep+nlig)
					sb.append(line+"\n");
				linenumber++;
			   }
			   if(ldep+nlig>linenumber)
				System.out.println("End of file reached.");
			   br2.close();
 
			FileWriter fw=new FileWriter(new File(chemi));
			//Write entire string buffer into the file
			fw.write(sb.toString());
			fw.close();
		}
		catch (Exception ee)
		          {
			      System.out.println("Something went horribly wrong: "+ee.getMessage());
		          }
	         }
        }
        );
        
	}
	
	
	//QUIT
	public void actionPerformed(ActionEvent ae) {
		//Button Quitter
		if(ae.getSource().equals(btnQuit)) {
			System.out.println("why?");
	        ldep = Integer.valueOf(ligDep.getText());
            this.setVisible(false);
                                }
	}

     
	
	
        
}