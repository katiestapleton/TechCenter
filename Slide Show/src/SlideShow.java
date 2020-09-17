import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;


public class SlideShow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1522289118557214884L;
	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.WHITE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
        // *****ISSUE WITH LOOP. NEED TO RESET i ONCE REACHES 5. if 0-4/else5.
		//logic to add each of the slides and text
		for (int i = 0; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		
		textField = new JTextField();
		slidePane.add(textField, "name_58117724097200");
		textField.setColumns(10);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 * I found images from the internet (accredited to source) and imported into resource folder
	 * I reassigned new images to appropriate slot, removing the test images.
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==0){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Ananda.jpg") + "'</body></html>";
		} else if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/SpaEastman.jpg") + "'</body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Aquadome.jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Amannemu.jpg") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Tabacon.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 * The font size and break lines were apply uniformly for all 5 locations
	 * I researched the internet for locations and descriptions, replacing the default or black text with a proper description.
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==0){
			text = "<html><body><font size='5'>#1 Ananda Spa in the Himalayas.</font> <br> Ananda is wellness spa resort located on a beautiful 100 acre palace in northern India, surrounded by forests, with a beautiful overview of both humanity and nature. Your wellness retreat is based on the wonders of Eastern Medicine and Culture. Image: Ananda Spa </body></html>";
		} else if (i==1){
			text = "<html><body><font size='5'>#2 Spa Eastman in Canada.</font> <br> Spa Eastman is located in Quebec with over 300 arces overlooking Mont Orford. It offers specialities such as Nordiac Spas, hot and cold hydrotherapy, and so much more. Image: </body></html>";
		} else if (i==2){
			text = "<html><body><font size='5'>#3 Aqua Dome in Austria.</font> <br> Aqua Dome, located in Alps mountain range, provides a modern design to its wellness atmosphere. This wonderous resort offers fitness, exploration, wellness, and relaxation all in at one location. Enjoy your time in the hot springs, mountains, or indoors. Image: Aqua Dome Management</body></html>";
		} else if (i==3){
			text = "<html><body><font size='5'>#4 Amanemu in Japan.</font> <br> Located in Shima-shi, Japan, the Amanemu offers a scenic view of the Japanese countryside within Shima National Park, including a gorgeous overlook of Ago Bay. Amanemu is a well-rounded resort including natural hot springs, spas, gardens, shrines, fine cuisine and more. Image: Amanemu</body></html>";
		} else if (i==4){
			text = "<html><body><font size='5'>#5 Tabacon Thermal Resort in Costa Rica.</font> <br> Completely surrounded by a lush tropical rainforest,  Tabacon is home to the largest natural network of thermal springs, rich in numerous minerals. This report provides an embodiment of culture, wellness, and relaxation. Image: TripAdvisor</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}