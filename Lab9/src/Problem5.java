import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Vector;

class Problem5 extends JFrame implements ActionListener {
	JButton button;
	Vector<Color> colors;
	Random random = new Random();
	
	public Problem5(String text) {
		super(text);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(100, 100));
		
		button = new JButton("PRESS");
		
		colors = new Vector<>();
		colors.add(Color.RED);
		colors.add(Color.GREEN);
		colors.add(Color.BLUE);
		colors.add(Color.ORANGE);
		colors.add(Color.MAGENTA);
		colors.add(Color.PINK);
		colors.add(Color.YELLOW);
		
		add(button);
		
		button.addActionListener(this);
		button.setMnemonic(KeyEvent.VK_C);
		
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		Problem5 pb5 = new Problem5("Problem5");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			button.setBackground(colors.get(random.nextInt(7)));
			button.setForeground(colors.get(random.nextInt(7)));
		}
	}
}