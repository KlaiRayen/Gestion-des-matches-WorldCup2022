import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;
import java.sql.*; 
import javax.swing.table.* ;
import javax.swing.text.TableView;

class stat extends JFrame implements ActionListener 
{
    Object[][] data ; 
    JComboBox<String> jcb ; 
    JButton bt1,bt2 ; 
    JTable table ; 
    DefaultTableModel tableModel;
    String[] equipes = new String[40]; 
public stat()
    {
            String col[] = {"Equipe", "BUTS MARQUÉS", "BUTS ENCAISSÉS"};


             tableModel = new DefaultTableModel(col,0);
             table = new JTable(tableModel);

             tableModel.addRow(col);

             

            
        JScrollPane scroll = new JScrollPane(table);
        table.setFillsViewportHeight(true);
 
        JLabel labelHead = new JLabel("Liste des employes");
        labelHead.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));
 
        jcb = new JComboBox<String>(); 

        JLabel lb1 = new JLabel("Statistique",SwingConstants.CENTER);
        lb1.setFont(new Font("Italic", Font.BOLD, 20));
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p1.add(lb1);
         

        setLayout(new BorderLayout()); 

        int i=0 ;
        String arr[] = new String[3]; 
         
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wc2022","root","");
                  String s1= "SELECT * from tournoi where tour=\"1/8\"" ;

                  PreparedStatement ps = conn.prepareStatement(s1);
                  ResultSet rs1 = ps.executeQuery();
                  i=0;
                  while(rs1.next() && i<8)
                    {   
                        equipes[i]= rs1.getString("equipe1");
                        equipes[i+8]= rs1.getString("equipe2");

                        i++;

                    }
                   
                }catch (Exception e3){e3.printStackTrace();}

                for (int k=0;k<16;k++)
                {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wc2022","root","");
                  String s1= "SELECT sum(scr_a) as a1 from tournoi where equipe1=\""+equipes[k]+"\"" ;
                  String s2= "SELECT sum(scr_b) as a2 from tournoi where equipe2=\""+equipes[k]+"\"" ;
                  String s1en= "SELECT sum(scr_b) as a1en from tournoi where equipe1=\""+equipes[k]+"\"" ;
                  String s2en= "SELECT sum(scr_a) as a2en from tournoi where equipe2=\""+equipes[k]+"\"" ;

                  PreparedStatement ps = conn.prepareStatement(s1);
                  ResultSet rs1 = ps.executeQuery();
                  PreparedStatement ps2 = conn.prepareStatement(s2);
                  ResultSet rs2 = ps2.executeQuery();
                  PreparedStatement ps3 = conn.prepareStatement(s1en);
                  ResultSet rs3 = ps3.executeQuery();
                  PreparedStatement ps4 = conn.prepareStatement(s2en);
                  ResultSet rs4 = ps4.executeQuery();
                  int sm1=0;
                  int sm2=0;
                  if(rs1.next())  
                        sm1= rs1.getInt("a1");
                 if(rs2.next())  
                        sm1+= rs2.getInt("a2");
                  if(rs3.next())  
                        sm2+= rs3.getInt("a1en");
                  if(rs4.next())  
                        sm2+= rs4.getInt("a2en");
                   Object[] objs = {equipes[k], sm1, sm2};
                        tableModel.addRow(objs);
                    
                   
                }catch (Exception e3){e3.printStackTrace();}
            }
        
        bt2= new JButton("Retour");
        //bt1.addActionListener(this);
        //bt2.addActionListener(this);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2.add(table);

        JPanel ls = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        ls.add(bt2);

bt2.addActionListener(this);

        add(p1,BorderLayout.NORTH); 
        add(table,BorderLayout.CENTER); 
        add(ls,BorderLayout.SOUTH); 

        pack();
        setLocationRelativeTo(null);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Statistique");
        jcb.addActionListener(this); 
    }
    public void actionPerformed(ActionEvent e)
    {
                              
        Object  src = e.getSource(); 
            
           if(src==bt2)
            {
                dispose();
            }

        }
    public static void main(String[] args) {
        new stat();
    }
}