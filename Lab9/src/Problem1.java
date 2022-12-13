import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Problem1 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JTextField t1;
	JTextField t2;
	JTextField t3;
	JTextField result;
	JButton button;
	
	public Problem1(String name) {
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(300, 300));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 3));
		t1 = new JTextField(10);
		t2 = new JTextField(10);
		t3 = new JTextField(10);
		
		panel.add(t1);
		panel.add(t2);
		panel.add(t3);
		
		button = new JButton("OK");
		JPanel panel_aux = new JPanel();
		panel_aux.add(button);
		
		result = new JTextField(20);
		JPanel other_panel = new JPanel();
		other_panel.add(result);
		
		add(panel, BorderLayout.NORTH);
		add(panel_aux, BorderLayout.SOUTH);
		add(other_panel, BorderLayout.CENTER);
		
		t1.addActionListener(this);
		t2.addActionListener(this);
		t3.addActionListener(this);
		
		pack();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		result.setText(t1.getText() + "\\" + t2.getText() + "\\" + t3.getText());
	}
	
	public static void main(String[] args) {
		Problem1 obj = new Problem1("Problem1");
	}
}