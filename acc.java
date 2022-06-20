import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;
import java.sql.*; 

class acc extends JFrame implements ActionListener
{
JPanel p1,p1_1,p2,p3,princ,pf,lst ;
JPanel p4,pa ;  
JButton bt1,bt2,bt3,bc1,bc2,bc3,aff ; 
JPasswordField tf;   
public acc()
    {
       // ImageIcon im1 = new ImageIcon(getClass().getResource("fifa2.png"));

        ImageIcon img = new ImageIcon("logo.png");
        setIconImage(img.getImage());

        setLayout(new GridLayout(3,0));
        
        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        JLabel lb1 = new JLabel("Bienvenue",SwingConstants.CENTER);
        JLabel lb21 = new JLabel("COUPE DU MONDE QATAR 2022",SwingConstants.CENTER);
        lb1.setFont(new Font("Italic", Font.BOLD, 20));
        lb21.setFont(new Font("Italic", Font.BOLD, 15));
        p1_1 = new JPanel(new GridLayout(3,1));
        p1_1.add(lb1); 
        p1_1.add(lb21); 
        p1_1.add(new JLabel(new ImageIcon("logo.png"))); 
        p1.add(p1_1); 
        aff = new JButton("Affichage"); 
        p2 = new JPanel(new GridLayout(3,1)); 
         
        bt1 = new JButton("Client"); 
        bt2 = new JButton("Agent FIFA");//,new ImageIcon("fifa2.png")) ; 
        bt2.addActionListener(this);
        JPanel p2_1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bt1.addActionListener(this);

        JPanel p2_2 = new JPanel(new GridLayout(4,0)); 
        p2_2.add(new JLabel("") );
        p2_2.add(bt1);
        p2_2.add(new JLabel("") );
        p2_2.add(bt2);
p2_2.setBackground(new Color(239,209,213));
        p2_1.add(p2_2); 
        
         princ = new JPanel(new BorderLayout());
        JLabel lb10 = new JLabel("LOGIN");
        JPanel p10 = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        lb10.setFont(new Font("Italic", Font.BOLD, 20));
        p10.add(lb10); 

        
        bt3 = new JButton("Connexion"); 
        bt3.addActionListener(this);
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        JLabel lbc = new JLabel("Mot de passe :"); 
         tf = new JPasswordField(10); 
        
        p3.add(lbc); 
        p3.add(tf);
        p3.add(bt3); 

         pa = new JPanel(new BorderLayout()); 
        pa.add(p3,BorderLayout.CENTER); 
        
        
       pf = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
       bc2 = new JButton("Matches"); 
       bc3 = new JButton("Statistique"); 
       bc3.addActionListener(this);
        pf.add(bc2);
        pf.add(bc3);
        pf.add(aff);
bc2.addActionListener(this);
        pa.add(p3,BorderLayout.NORTH); 
          pa.add(princ,BorderLayout.CENTER);
        p1.setBackground(new Color(239,209,213));
        p1_1.setBackground(new Color(239,209,213));
        p2.setBackground(new Color(239,209,213));
        p3.setBackground(new Color(239,209,213));
        princ.setBackground(new Color(239,209,213));
        pf.setBackground(new Color(239,209,213)); ;

          p1.setBackground(new Color(239,209,213));
          p2_1.setBackground(new Color(239,209,213));
 lst= new JPanel();
lst.setBackground(new Color(239,209,213));
          add(p1,BorderLayout.NORTH);
        add(p2_1,BorderLayout.CENTER);
        add(lst,BorderLayout.SOUTH);
aff.addActionListener(this);
        pack();
        setLocationRelativeTo(null);
        setSize(500,620);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Accueil");

    }
    public void actionPerformed(ActionEvent e)
        {
            Object  src = e.getSource(); 
                if(src==bt2) 
                {   
                    remove(lst);
                    remove(pf); 
                    add(pa,BorderLayout.SOUTH);
                    repaint();
                    revalidate() ;
                }
                
                if(src==bt1) 
                {   
                    remove(lst);
                    remove(pa); 

                    add(pf,BorderLayout.SOUTH);
                    repaint();
                    revalidate() ;
                }
                if(src==bt3)
                {
                    String myPass=String.valueOf(tf.getPassword());
                    if (myPass.equals("fifa"))
                        new test() ; 
                    else
                        showMessageDialog(null, "Mot de passe incorrecte");
                }
                if(src==bc2)
                    new qualif(); 
                if(src==bc3)
                    new stat();
                if (src==aff)
                    new affichage();


        }
    public static void main(String[] args) {
        new acc() ;
    }
}