import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class Problem6 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JLabel label;
	JTextField text;
	JButton button;
	JScrollPane scroll;
	JTextArea textArea;
	
	public Problem6(String message) {
		super(message);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(300, 300));
		
		label = new JLabel("Path");
		
		text = new JTextField();
		
		button = new JButton("PRESS");
		
		textArea = new JTextArea();
		
		scroll = new JScrollPane(textArea);
		
		button.addActionListener(this);
		
		add(label, BorderLayout.NORTH);
		add(text, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		add(scroll, BorderLayout.EAST);
		add(textArea, BorderLayout.WEST);
		
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			File file = new File(text.getText());
			
			if (file.exists() && !file.isDirectory()) {
				String string = null;
				try {
					string = Files.readString(Path.of(text.getText()));
				} catch (IOException err) {
					err.printStackTrace();
				}
				text.setText(string);
				text.setVisible(true);
			} else {
				text.setVisible(false);
				text.setText("");
			}
		}
	}
	
	public static void main(String[] args) {
		Problem6 pb6 = new Problem6("Ceva");
	}
}