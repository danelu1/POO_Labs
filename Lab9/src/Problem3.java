import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

class Problema3 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JTextField quiz;
    JCheckBox[] r;
    JButton button;

    public Problema3(String fis) {
        super("Problema 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        quiz = new JTextField(150);
        quiz.setEditable(false);

        r = new JCheckBox[4];

        for (int i = 0; i < 4; i++) {
        	r[i] = new JCheckBox();
        }
        
        JPanel rb=new JPanel();
        rb.setLayout(new GridLayout(4,1));
        rb.add(r[0]);
        rb.add(r[1]);
        rb.add(r[2]);
        rb.add(r[3]);

        button = new JButton("Raspunde");
        button.setEnabled(false);
        button.addActionListener(this);

        add(quiz, BorderLayout.NORTH);
        add(rb, BorderLayout.CENTER);
        add(button,BorderLayout.SOUTH);

        for (int i = 0; i < 4; i++) {
        	r[i].addActionListener(this);
        }

        pack();
        setVisible(true);
        try {
            RandomAccessFile br = new RandomAccessFile(fis,"r");
            quiz.setText(br.readLine());
            r[0].setText(br.readLine());
            r[1].setText(br.readLine());
            r[2].setText(br.readLine());
            r[3].setText(br.readLine());

        } catch (IOException ex) {
            System.err.println("Exceptie");
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JCheckBox) {
            button.setEnabled(true);
        } else if(e.getSource() instanceof JButton) {
            if(r[0].isSelected() && r[2].isSelected()) {
                r[0].setForeground(Color.green);
                r[2].setForeground(Color.green);
            } else {
                r[0].setForeground(Color.red);
                r[2].setForeground(Color.red);
            }
            button.setEnabled(false);
        }
    }
    public static void main(String args[]) {
        Problema3 pb2 = new Problema3("intrebare.txt");

    }
}