package network;

import java.util.Observer;

import javax.swing.UIManager;

public class ShannonsTheorem implements ShannonsController {

	ShannonsModel model;

	public ShannonsTheorem() {

		super();

	}

	public double getBandwidth() {

		return model.getBandwidth();

	}

	public double getSignalToNoise() {

		return model.getSignalToNoise();

	}

	public double getMaximumDataRate() {

		return model.getMaximumDataRate();

	}

	@Override

	public void setSignalToNoise(double signalToNoiseRatio) {

		model.setSignalToNoise(signalToNoiseRatio);

	}

	@Override

	public void setBandwidth(double bandwidth) {

		model.setBandwidth(bandwidth);

	}

	@Override

	public void addObserver(Observer o) {

		model.addObserver(o);

	}

	public void setModel(ShannonsModel shannonsmodel) {
		this.model = shannonsmodel;
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		ShannonsTheorem st = new ShannonsTheorem();
		ShannonsModel sm = new ShannonsModel();
		ShannonsView sv = new ShannonsView();
		st.setModel(sm);
		st.addObserver(sv);
		sv.setController(st);

		sv.run();

	}

}
