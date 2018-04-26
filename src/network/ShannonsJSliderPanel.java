
package network;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ShannonsJSliderPanel extends JPanel {

	private static final long serialVersionUID = 1619047577451673769L;

	private ShannonsController controller;

	private JSlider maxDataRateJTextField;

	private JSlider bandwidthJTextField;

	private JSlider signalToNoiseJTextField;

	//ShannonsModel model;

	ShannonsJSliderPanel(ShannonsController controller) {
		this.controller = controller;
		createPanel();

	}

	public void createPanel() {

		maxDataRateJTextField = new JSlider();
		bandwidthJTextField = new JSlider();
		signalToNoiseJTextField = new JSlider();
		
		maxDataRateJTextField.setBackground(Color.BLACK);
		bandwidthJTextField.setBackground(Color.BLACK);
		signalToNoiseJTextField.setBackground(Color.BLACK);

		
		JPanel labelsJPanel = new JPanel(new GridLayout(3, 1));
		labelsJPanel.setBackground(Color.red);

		labelsJPanel.add(new JLabel("Bandwidth (hertz)"));

		labelsJPanel.add(new JLabel("Signal to Noise (db)"));

		labelsJPanel.add(new JLabel("Maximum Data Rate (bps)"));

		JPanel fieldsJPanel = new JPanel(new GridLayout(3, 1));

		fieldsJPanel.add(bandwidthJTextField);

		fieldsJPanel.add(signalToNoiseJTextField);

		fieldsJPanel.add(maxDataRateJTextField);

		this.setLayout(new BorderLayout());

		this.add(labelsJPanel, BorderLayout.WEST);

		this.add(fieldsJPanel, BorderLayout.CENTER);

		bandwidthJTextField.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent arg0) {

				controller.setBandwidth((double) bandwidthJTextField.getValue());

			}

		});

		signalToNoiseJTextField.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent arg0) {

				controller.setSignalToNoise((double) signalToNoiseJTextField.getValue());

			}

		});

	}


	public void bandwidth(double MDR) {

		bandwidthJTextField.setValue((int) MDR);
	}
	public void signalToNoise(double MDR) {

		signalToNoiseJTextField.setValue((int) MDR);
	}
	public void updateMDR(double MDR) {

		maxDataRateJTextField.setValue((int) MDR);
	}
}
