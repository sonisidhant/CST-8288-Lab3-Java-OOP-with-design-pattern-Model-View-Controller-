package network;

import java.lang.Math;

import java.util.Observable;

public class ShannonsModel extends Observable   {

	double bandwidth = 0.0;

	double signalToNoise = 0.0;

	public ShannonsModel() {

		super();

	}

	public double getBandwidth() {
		return bandwidth;
	}

	public double getSignalToNoise() {
		return signalToNoise;
	}

	private double getMaximumDataRate(double hertz, double signalToNoise) {
		return (hertz * (Math.log(1 + Math.pow(10, signalToNoise / 10)) / Math.log(2)));
	}

	public double getMaximumDataRate() {
		return getMaximumDataRate(bandwidth, signalToNoise);
	}

	public void setBandwidth(double bandwidth) {
		if (bandwidth < 0) {
			throw new IllegalArgumentException("The number should be greater than or equal to zero:-> TRY AGAIN");
		}
		this.bandwidth = bandwidth;

		setChanged();

		notifyObservers();

	}

	public void setSignalToNoise(double signalToNoise) {
		if (signalToNoise < 0) {
			throw new IllegalArgumentException("The number should be greater than or equal to zero:-> TRY AGAIN");
		}
		this.signalToNoise = signalToNoise;

		setChanged();

		notifyObservers();

	}

} // end class ShannonsModel