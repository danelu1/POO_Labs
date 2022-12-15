import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class Book {
    private String name;
    private String author;
    private String iconName;
 
    public Book(String name, String author, String iconName) {
        this.name = name;
        this.author = author;
        this.iconName = iconName;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getAuthor() {
        return author;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }
 
    public String getIconName() {
        return iconName;
    }
 
    public void setIconName(String iconName) {
        this.iconName = iconName;
    }
    public String toString()
    {
        return iconName + name + author;
    }
}

@SuppressWarnings("rawtypes")
class BookRenderer extends JPanel implements ListCellRenderer {
	private static final long serialVersionUID = 1L;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	
	public BookRenderer() {
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		add(label1);
		add(label2);
		add(label3);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// TODO Auto-generated method stub
		Book book = (Book) value;
		
		label2.setText(book.getName());
		label3.setText(book.getAuthor());
		
		label1.setIcon(new ImageIcon("Imagini/" + book.getIconName() + ".jpg"));
		
		int aux = 0;
		
		if (isSelected) {
			setBackground(Color.red);
		} else {
			aux = list.getSelectedIndex();
			if (index % 2 == 0) {
				setBackground(Color.green);
			} else {
				setBackground(Color.yellow);
			}
		}
		
		return this;
	}
}

class Problem1 extends JFrame implements ListSelectionListener, ActionListener {
	private static final long serialVersionUID = 1L;
	Vector<Book> books;
	@SuppressWarnings("rawtypes")
	JList list;
	JScrollPane scrollPane;
	DefaultListModel<Book> defList;
	JTextField text1;
	JTextField text2;
	JLabel label1;
	JLabel label2;
	JPanel panel1;
	JPanel panel2;
	JSplitPane split;
	JButton button;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Problem1(String message) {
		super(message);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(500, 100));
		
		books = new Vector<>();
		books.add(new Book("C/C++", "Marcel Sevraj", "cpp"));
		books.add(new Book("Java", "Matei Rebenciuc", "java"));
		books.add(new Book("C#", "Andrei Ramon", "cs"));
		books.add(new Book("IOS", "Alehandro Pascani", "ios"));
		books.add(new Book("Windows Phone", "Cornel Boris", "wp"));
		books.add(new Book("Android", "Cretu Pavel", "android"));
		
		defList = new DefaultListModel<>();
		
		for (int i = 0; i < books.size(); i++) {
			defList.add(i, books.get(i));
		}
		
		list = new JList(defList);
		list.setCellRenderer(new BookRenderer());
		list.addListSelectionListener(this);
		
		scrollPane = new JScrollPane(list);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel1 = new JPanel();
		panel1.add(scrollPane);
		panel1.setBackground(Color.orange);
		
		label1 = new JLabel("Name");
		label2 = new JLabel("Author");
		
		text1 = new JTextField("");
		text2 = new JTextField("");
		
		panel2 = new JPanel(new GridLayout(3, 2));
		panel2.add(label1);
		panel2.add(text1);
		panel2.add(label2);
		panel2.add(text2);
		panel2.setBackground(Color.BLUE);
		
		button = new JButton("PRESS ME");
		button.addActionListener(this);
		
		panel2.add(button);
		
		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, panel2);
		
		add(split);
		
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Problem1 pb1 = new Problem1("Problema 1");
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (list.isSelectionEmpty()) {
			return;
		} else {
			Object value = list.getSelectedValue();
			Book book = (Book) value;
			text1.setText(book.getName());
			text2.setText(book.getAuthor());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button) {
			int index = list.getSelectedIndex();
			defList.remove(index);
		}
	}
}