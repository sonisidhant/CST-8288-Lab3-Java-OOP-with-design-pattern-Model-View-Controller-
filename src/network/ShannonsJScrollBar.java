
package network;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ShannonsJScrollBar extends JPanel {

	private static final long serialVersionUID = 1619047577451673769L;

	private ShannonsController controller;

	private JScrollBar maxDataRateJTextField;

	private JScrollBar bandwidthJTextField;

	private JScrollBar signalToNoiseJTextField;

	//ShannonsModel model;

	ShannonsJScrollBar(ShannonsController controller) {
		this.controller = controller;
		createPanel();

	}

	public void createPanel() {

		maxDataRateJTextField = new JScrollBar(10);
		bandwidthJTextField = new JScrollBar();
		signalToNoiseJTextField = new JScrollBar();
		JPanel labelsJPanel = new JPanel(new GridLayout(3, 1));
		labelsJPanel.setBackground(Color.CYAN);

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

		bandwidthJTextField.addAdjustmentListener(new AdjustmentListener() {

			public void adjustmentValueChanged(AdjustmentEvent arg0) {

				controller.setBandwidth((double) bandwidthJTextField.getValue());

			}

		});

		signalToNoiseJTextField.addAdjustmentListener(new AdjustmentListener() {

			public void adjustmentValueChanged(AdjustmentEvent arg0) {

				controller.setSignalToNoise((double) signalToNoiseJTextField.getValue());

			}

		});

	}

	public void updateMDR(double MDR) {

		maxDataRateJTextField.setValue((int) MDR);
	}

}
