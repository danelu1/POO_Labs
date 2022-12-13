import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

class Problem4 extends JFrame implements ChangeListener {
	private static final long serialVersionUID = 1L;
	JSlider slider1, slider2, slider3;
	JTextField text;
	
	public Problem4(String name) {
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(500, 500));
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		slider1 = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		slider1.setBackground(Color.BLUE);
		slider2 = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		slider2.setBackground(Color.GREEN);
		slider3 = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		slider3.setBackground(Color.RED);
		
		text = new JTextField("samasjvndjvndsjnv");
		
		panel.add(slider1);
		panel.add(slider2);
		panel.add(slider3);
		panel.add(text);
		add(panel);
		
		slider1.addChangeListener(this);
		slider2.addChangeListener(this);
		slider3.addChangeListener(this);
		
		pack();
		setVisible(true);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		text.setBackground(new Color(slider1.getValue(), slider2.getValue(), slider3.getValue()));
	}
	
	public static void main(String[] args) {
		Problem4 pb4 = new Problem4("Problem4");
	}
}