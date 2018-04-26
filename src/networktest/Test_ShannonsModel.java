package networktest;

//import statements

import network.ShannonsModel;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test_ShannonsModel {


	ShannonsModel model = new ShannonsModel();


	DecimalFormat df = new DecimalFormat("#.##");

     @Before
	public void setUp() throws Exception{
		assertNotNull(model);
	}

	@After
	public void tearDown() throws Exception{
		model = null;
	}
	

	@Test

	public void testConstructors() {

		new ShannonsModel();

	}
	
	@Test

	public void testSetBandwidth() {

		model.setBandwidth(3000);

		assertEquals(3000, model.getBandwidth(), 0);

	}


	@Test

	public void tesGetBandwidth() {

		model.setBandwidth(1000);

		assertEquals(1000, model.getBandwidth(), 0);

	}


	@Test

	public void testSetSignalToNoise() {

		model.setSignalToNoise(30);

		assertEquals(30, model.getSignalToNoise(), 0);

	}

	@Test

	public void testGetSignalToNoise() {

		model.setSignalToNoise(10);

		assertEquals(10, model.getSignalToNoise(), 0);

	}
	
	@Test

	public void testGetMaximumDataRate() {

		model.setBandwidth(3000);

		model.setSignalToNoise(30);

		assertEquals(29901.68, Double.parseDouble(df.format(model.getMaximumDataRate())), 0);

	}

} // end class ShannonsTheoremTest