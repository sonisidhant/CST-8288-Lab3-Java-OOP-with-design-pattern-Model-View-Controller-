package network;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShannonsJTextFieldPanel extends JPanel {

	private static final long serialVersionUID = 1619047577451673769L;

	private ShannonsController controller;

	private JTextField maxDataRateJTextField;

	private JTextField bandwidthJTextField;

	private JTextField signalToNoiseJTextField;

	//ShannonsModel model = new ShannonsModel();

	ShannonsJTextFieldPanel(ShannonsController controller) {
		this.controller = controller;
		createPanel();

	}

	public void createPanel() {

		maxDataRateJTextField = new JTextField(50/2);
		bandwidthJTextField = new JTextField(50/2);
		signalToNoiseJTextField = new JTextField(50/2);
		
		maxDataRateJTextField.setBackground(Color.GRAY);
		bandwidthJTextField.setBackground(Color.GRAY);
		signalToNoiseJTextField.setBackground(Color.GRAY);


		JPanel labelsJPanel = new JPanel(new GridLayout(3, 1));
		labelsJPanel.setBackground(Color.GREEN);

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

		bandwidthJTextField.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				try {

					controller.setBandwidth(Double.parseDouble(bandwidthJTextField.getText()));

				} catch (NumberFormatException exception) {

					JOptionPane.showMessageDialog(ShannonsJTextFieldPanel.this,
							"Invalid input! Please enter a valid number!", "Error encountered!",
							JOptionPane.ERROR_MESSAGE);

				}

			}

		});

		signalToNoiseJTextField.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				try {

					controller.setSignalToNoise(Double.parseDouble(signalToNoiseJTextField.getText()));

				} catch (NumberFormatException exception) {

					JOptionPane.showMessageDialog(ShannonsJTextFieldPanel.this,
							"Invalid input! Please enter a valid number!", "Error encountered!",
							JOptionPane.ERROR_MESSAGE);

				}

			}

		});

	}

	
	public void bandwidth(double MDR) {

		bandwidthJTextField.setText(Double.toString(MDR));
	}
	public void signalToNoise(double MDR) {

		signalToNoiseJTextField.setText(Double.toString(MDR));
	}
	public void updateMDR(double MDR) {

		maxDataRateJTextField.setText(Double.toString(MDR));
	}

}
