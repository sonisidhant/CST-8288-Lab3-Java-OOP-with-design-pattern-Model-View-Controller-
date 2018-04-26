package network;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ShannonsView extends JFrame implements Observer {

	private static final long serialVersionUID = -7219663478303192380L;
	private ShannonsController controller;
	ShannonsJTextFieldPanel text;
	ShannonsJSliderPanel slider;
	ShannonsJScrollBar scrollbar;
	int width = 1000;
    int height = 1000;
    

	public ShannonsView() {
	}

	/**
	 * start gui
	 */
	public void run() {
	       getContentPane().setBackground(new Color(70, 80, 70));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(createContentPane());
		setLocationRelativeTo(null);
//		setSize(width, height);
		this.getContentPane().setBackground(Color.yellow); 
        pack();
		setVisible(true);
	}

	public JPanel createContentPane() {
		text = new ShannonsJTextFieldPanel(controller);
		slider = new ShannonsJSliderPanel(controller);
		//scrollbar = new ShannonsJScrollBar(controller);

		JPanel contentPane = new JPanel();

		contentPane.add(text);
		contentPane.add(slider);
		//contentPane.add(scrollbar);


		return contentPane;

	}

	public void setController(ShannonsController Controller) {
		this.controller = Controller;
	}

	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof ShannonsModel) {

			ShannonsModel model = (ShannonsModel) o;

			Double rate = model.getMaximumDataRate();
			Double bandwidth = model.getBandwidth();
			Double signal = model.getSignalToNoise();

			text.updateMDR(rate);
			slider.updateMDR(rate);
			text.bandwidth(bandwidth);
			slider.updateMDR(bandwidth);
			text.signalToNoise(signal);
			slider.signalToNoise(signal);

		}

	}
}
