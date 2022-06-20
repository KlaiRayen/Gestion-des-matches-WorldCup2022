import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;
import java.sql.*; 
import javax.swing.table.* ;
import javax.swing.text.TableView;

class qualif extends JFrame implements ActionListener 
{
    Object[][] data ; 
    JComboBox<String> jcb ; 
    JButton bt1,bt2 ; 
    JTable table ; 
    DefaultTableModel tableModel;
public qualif()
    {

        String[] columns = new String[] {
            "Date", "Stade", "Nbr spectateurs", "Equipe A", "Equipe B","Resultat"} ;
        
            
         

            String col[] = {"Date", "Stade", "Nbr spectateurs","Equipe A", "Equipe B","Resultat"};


             tableModel = new DefaultTableModel(col,0);
             table = new JTable(tableModel);

             tableModel.addRow(col);

             

            
        JScrollPane scroll = new JScrollPane(table);
        table.setFillsViewportHeight(true);
 
        JLabel labelHead = new JLabel("Liste des employes");
        labelHead.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));
 
        jcb = new JComboBox<String>(); 

        JLabel lb1 = new JLabel("Les matches",SwingConstants.CENTER);
        lb1.setFont(new Font("Italic", Font.BOLD, 20));

        JPanel p1 = new JPanel(new GridLayout(3,0)); 
        p1.add(lb1); 

        setLayout(new BorderLayout()); 
        jcb.addItem("Huitieme de finale");
        jcb.addItem("Quart de finale");
        jcb.addItem("Demi finale");
        jcb.addItem("Finale");

        bt1= new JButton("Rechercher");
        bt2= new JButton("Retour");
        //bt1.addActionListener(this);
        //bt2.addActionListener(this);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p2_1 = new JPanel(new GridLayout(2,0));
        p2_1.add(p2); 
        p2.add(jcb);
        p2.add(bt1);
        
        p1.add(p2); 

        JPanel ls = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        ls.add(bt2);

bt1.addActionListener(this);
bt2.addActionListener(this);

        add(p1,BorderLayout.NORTH); 
        add(table,BorderLayout.CENTER); 
        add(table,BorderLayout.CENTER); 
        add(ls,BorderLayout.SOUTH); 

        pack();
        setLocationRelativeTo(null);
        setSize(700,550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Equipes qualifiees");
        jcb.addActionListener(this); 
    }
    public void actionPerformed(ActionEvent e)
    {
        String col[] = {"Date", "Stade", "Nbr spectateurs","Equipe A", "Equipe B","Resultat"};

        int i=0 ;
        String arr[] = new String[7]; 
        Object  src = e.getSource(); 
        if(src==bt1) 
            {   

                DefaultTableModel dm = (DefaultTableModel)table.getModel();
                while(dm.getRowCount() > 0)
                {
                    dm.removeRow(0);
                }
                tableModel.addRow(col);

                if(jcb.getSelectedItem().toString().equals("Huitieme de finale"))
                {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wc2022","root","");
                      String s= "SELECT * from tournoi where tour="+"\"1/8\"" ;
                      System.out.println(s);
                      PreparedStatement ps = conn.prepareStatement(s);
                      ResultSet rs1 = ps.executeQuery();
                      
                      while(rs1.next() && i<8)
                        {   
                         i++;
                            arr[0]= rs1.getString("date");
                         arr[1]= rs1.getString("stade");
                         arr[2]= rs1.getString("spectateur");
                         arr[3]= rs1.getString("equipe1");
                         arr[4]= rs1.getString("equipe2");
                         arr[5]= rs1.getString("scr_a");
                         arr[6]= rs1.getString("scr_b");
                         Object[] objs = {arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]+"-"+arr[6]};

                         tableModel.addRow(objs);
                        }
                  
                    }catch (Exception e3){e3.printStackTrace();}
                }
                else if(jcb.getSelectedItem().toString().equals("Quart de finale"))
                {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wc2022","root","");
                      String s= "SELECT * from tournoi where tour="+"\"1/4\"" ;
                      PreparedStatement ps = conn.prepareStatement(s);
                      ResultSet rs1 = ps.executeQuery();
                      
                      while(rs1.next() && i<4)
                        {   
                         i++;
                            arr[0]= rs1.getString("date");
                         arr[1]= rs1.getString("stade");
                         arr[2]= rs1.getString("spectateur");
                         arr[3]= rs1.getString("equipe1");
                         arr[4]= rs1.getString("equipe2");
                         arr[5]= rs1.getString("scr_a");
                         arr[6]= rs1.getString("scr_b");
                         Object[] objs = {arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]+"-"+arr[6]};

                         tableModel.addRow(objs);
                        }
                  
                    }catch (Exception e3){e3.printStackTrace();}
                }
                    else if(jcb.getSelectedItem().toString().equals("Demi finale"))
                {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wc2022","root","");
                      String s= "SELECT * from tournoi where tour="+"\"1/2\"" ;
                      PreparedStatement ps = conn.prepareStatement(s);
                      ResultSet rs1 = ps.executeQuery();
                      
                      while(rs1.next() && i<2)
                        {   
                         i++;
                            arr[0]= rs1.getString("date");
                         arr[1]= rs1.getString("stade");
                         arr[2]= rs1.getString("spectateur");
                         arr[3]= rs1.getString("equipe1");
                         arr[4]= rs1.getString("equipe2");
                         arr[5]= rs1.getString("scr_a");
                         arr[6]= rs1.getString("scr_b");
                         Object[] objs = {arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]+"-"+arr[6]};

                         tableModel.addRow(objs);
                        }
                  
                    }catch (Exception e3){e3.printStackTrace();}
                }
                else if(jcb.getSelectedItem().toString().equals("Finale"))
                {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wc2022","root","");
                      String s= "SELECT * from tournoi where tour="+"\"1\"" ;
                      PreparedStatement ps = conn.prepareStatement(s);
                      ResultSet rs1 = ps.executeQuery();
                      
                      while(rs1.next() && i<1)
                        {   
                         i++;
                            arr[0]= rs1.getString("date");
                         arr[1]= rs1.getString("stade");
                         arr[2]= rs1.getString("spectateur");
                         arr[3]= rs1.getString("equipe1");
                         arr[4]= rs1.getString("equipe2");
                         arr[5]= rs1.getString("scr_a");
                         arr[6]= rs1.getString("scr_b");
                         Object[] objs = {arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]+"-"+arr[6]};

                         tableModel.addRow(objs);
                        }
                  
                    }catch (Exception e3){e3.printStackTrace();}
                }
            }
            else if(src==bt2)
            {
                dispose();
            }

        }
    public static void main(String[] args) {
        new qualif();
    }
}