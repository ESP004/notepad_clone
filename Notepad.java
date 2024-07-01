
package notepad_clone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.filechooser.*;
import java.io.*;

public class Notepad extends JFrame implements ActionListener{
    
    JTextArea textarea;
    String text;//for copy pasete
    
    Notepad()
    {
        
        //deploy the menu bar
        JMenuBar bar = new JMenuBar();
        bar.setLayout(new FlowLayout(FlowLayout.LEFT));
        bar.setBackground(new Color(237, 240, 238));
        add(bar , BorderLayout.PAGE_START);
        
        //add menu option on the bar(file)
        JMenu file = new JMenu("File");
        file.setFont(new Font("AERIAL" , Font.BOLD , 14));
        bar.add(file);
        //add option for file(new)
        JMenuItem new_file = new JMenuItem("New");
        new_file.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N , ActionEvent.CTRL_MASK));
        new_file.addActionListener(this);
        file.add(new_file);
        //add option for file(open)
        JMenuItem open = new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O , ActionEvent.CTRL_MASK));
        open.addActionListener(this);
        file.add(open);
        //add option for file(save)
        JMenuItem save = new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S , ActionEvent.CTRL_MASK));
        save.addActionListener(this);
        file.add(save);
        //add option for file(print)
        JMenuItem print = new JMenuItem("Print");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , ActionEvent.CTRL_MASK));
        print.addActionListener(this);
        file.add(print);
        //add option for file(exit)
        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE , ActionEvent.CTRL_MASK));
        exit.addActionListener(this);
        file.add(exit);
        
        
        //add menu option on the bar(edit)
        JMenu edit = new JMenu("Edit");
        edit.setFont(new Font("AERIAL" , Font.BOLD , 14));
        bar.add(edit);
        //add option for edit(copy)
        JMenuItem copy = new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C , ActionEvent.CTRL_MASK));
        exit.addActionListener(this);
        edit.add(copy);
        //add option for edit(paste)
        JMenuItem paste = new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , ActionEvent.CTRL_MASK));
        paste.addActionListener(this);
        edit.add(paste);
        //add option for edit(cut)
        JMenuItem cut = new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X , ActionEvent.CTRL_MASK));
        cut.addActionListener(this);
        edit.add(cut);
        //add option for edit (select_all)
        JMenuItem select_all = new JMenuItem("Select all");
        select_all.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A , ActionEvent.CTRL_MASK));
        select_all.addActionListener(this);
        edit.add(select_all);
        
        //add menu option on the bar(help)
        JMenu help = new JMenu("Help");
        help.setFont(new Font("AERIAL" , Font.BOLD , 14));
        bar.add(help);
        
        //add option for edit (about)
        JMenuItem about = new JMenuItem("About");
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y , ActionEvent.CTRL_MASK));
        about.addActionListener(this);
        help.add(about);
        
        
        //add main text area
        textarea = new JTextArea(" ");
        textarea.setFont(new Font("SEN_SERIF" , Font.PLAIN , 18));
        //crouser moved on the next line when row is full
        textarea.setLineWrap(true);
        //if any word is spilt due to next line shift this function will autometicly move the word on the next line
        textarea.setWrapStyleWord(true);
        add(textarea , BorderLayout.CENTER );
        
        JScrollPane sp = new JScrollPane(textarea);
        add(sp );
        
        //deploy the frame
        setTitle("Notepad");
        //set icon on the title bar
        ImageIcon notepad_img = new ImageIcon(ClassLoader.getSystemResource("icons/notepad.png"));
        Image image = notepad_img.getImage();
        setIconImage(image);
        //get the full screen size of the window
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(165, 100 ,1200 , 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        //action performed on new item click
        if(ae.getActionCommand().equals("New"))
        {
            textarea.setText("");
        }
        //action performed on open item click
        else if(ae.getActionCommand().equals("Open"))
        {
            //JFileChooser is use to open dialog box of local harddrive
            JFileChooser choser = new JFileChooser();
            //apply restiction to accept all files
            choser.setAcceptAllFileFilterUsed(false);
            //create permission which file gonna be chose
            FileNameExtensionFilter restict = new FileNameExtensionFilter("Only .txt files" , "txt");
            //add the permission on choser
            choser.addChoosableFileFilter(restict);
            //method for open the dialog box
            int action = choser.showOpenDialog(this);
            //if user not open any file if statement will hit
            if(action != JFileChooser.APPROVE_OPTION)
            {
                return;
            }
            else
            {
                //if file is selected store it in a file type object
                File file = choser.getSelectedFile();
                try {
                    //then use bufferreader to read the file
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    try {
                        //set the content in textarea
                        textarea.read(reader, null);
                    } catch (IOException ex) {
                       ex.printStackTrace();
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
        //action performed on save item click
        else if(ae.getActionCommand().equals("Save"))
        {
            JFileChooser save = new JFileChooser();
            //this method is use to change the open button to save button
            save.setApproveButtonText("Save");
            int action = save.showOpenDialog(this);
            if(action != JFileChooser.APPROVE_OPTION)
            {
                return;
            }
            else
            {
                File filename = new File(save.getSelectedFile() + ".txt");
                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new FileWriter(filename));
                    try{
                        textarea.write(writer);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        //action performed on print item click
        else if(ae.getActionCommand().equals("Print"))
        {
            try {
                //print function is use to open print window of system
                textarea.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
        //action performed on exit item click
        else if(ae.getActionCommand().equals("Exit"))
        {
            System.exit(0);
        }
        //action performed on copy item click
        else if(ae.getActionCommand().equals("Copy"))
        {
            text = textarea.getSelectedText();
        }
        //action performed on paste item click
        else if(ae.getActionCommand().equals("Paste"))
        {
            textarea.insert(text, textarea.getCaretPosition());
        }
        else if(ae.getActionCommand().equals("Cut"))
        {
            text = textarea.getSelectedText();
            textarea.replaceRange("", textarea.getSelectionStart(), textarea.getSelectionEnd());
        }
        else if(ae.getActionCommand().equals("Select all"))
        {
            textarea.selectAll();
        }
        else if(ae.getActionCommand().equals("About"))
        {
            new About();
        }
        
    }
    
    
    public static void main(String args[])
    {
        new Notepad();
    }
}
