package network;
import java.util.Observer;



public interface ShannonsController {

    public void setSignalToNoise(double signalToNoiseRatio);



	public void setBandwidth(double bandwidth);



	public void addObserver(Observer o);

}