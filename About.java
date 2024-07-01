
package notepad_clone;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    
    JButton ok;
    
    About()
    {
        //add windows image
        ImageIcon windows = new ImageIcon(ClassLoader.getSystemResource("icons/windows.png"));
        Image windows_scaled = windows.getImage().getScaledInstance(380, 100, Image.SCALE_DEFAULT);
        ImageIcon windows_icon = new ImageIcon(windows_scaled);
        JLabel image = new JLabel(windows_icon);
        add(image , BorderLayout.PAGE_START);
        
        //add panel for main section
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        add(panel , BorderLayout.CENTER);
        
        //add panel for main section
        JPanel p1 = new JPanel();
        p1.setBackground(Color.WHITE);
        p1.setLayout(new BorderLayout());
        panel.add(p1 , BorderLayout.LINE_START);
        
        //add panel for main section
        JPanel p2 = new JPanel();
        p2.setBackground(Color.WHITE);
        p2.setLayout(new BorderLayout());
        panel.add(p2 , BorderLayout.CENTER);
        
        
        //add notepad image
        ImageIcon notepad = new ImageIcon(ClassLoader.getSystemResource("icons/notepad.png"));
        Image notepad_scaled = notepad.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        JLabel image2 = new JLabel(new ImageIcon(notepad_scaled));
        p1.add(image2 , BorderLayout.PAGE_START);
        
        Box vertical = Box.createVerticalBox();
        JLabel text = new JLabel("<html>Microsoft Windows<br>Version 0.0.0.1(os build 19045-3086)<br>Microsoft Copration all rides reserved</html>");
        vertical.add(text);
        
        vertical.add(Box.createVerticalStrut(30));
        
        JLabel text2 = new JLabel("<html>It is a replica of notepad and the iterface,<br>is try to make similar.The target is to provide,<br>same exprience and convience with all of its users.</html>");
        vertical.add(text2);
        
        vertical.add(Box.createVerticalStrut(30));
        
        JLabel text3 = new JLabel("<html>The product is lincenced under microsoft corprocetion.</html>");
        vertical.add( text3);
        p2.add(vertical , BorderLayout.PAGE_START);
        
        //add panel for main section
        JPanel p3 = new JPanel();
        p3.setBackground(Color.WHITE);
        p3.setLayout(new BorderLayout());
        panel.add(p3 , BorderLayout.PAGE_END);
        
        Box vertical2 = Box.createVerticalBox();
        ok = new JButton("Ok");
        ok.addActionListener(this);
        ok.setForeground(Color.black);
        vertical2.add( ok);
        vertical2.add(Box.createVerticalStrut(20));
        vertical.add(Box.createHorizontalStrut(20));
        p3.add(vertical2 , BorderLayout.LINE_END);
        
        //deploy the frame
        getContentPane().setBackground(Color.WHITE);
        setBounds(250 ,150 , 600 , 500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
    }
    
    public static void main(String args[])
    {
        new About();
    }
    
}
