package sit707_week5;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static double[] hourlyTemperatures;
    
	@Test
	public void testStudentIdentity() {
		String studentId = "s222196167";
		Assert.assertNotNull(studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Apurv Gurudatta Sapar";
		Assert.assertNotNull(studentName);
	}

	 @BeforeClass
	    public static void setUp() {
	        wController = WeatherController.getInstance();
	        int nHours = wController.getTotalHours();
	        hourlyTemperatures = new double[nHours];
	        for (int i = 0; i < nHours; i++) {
	            hourlyTemperatures[i] = wController.getTemperatureForHour(i + 1);
	        }
	    }

	    @AfterClass
	    public static void tearDown() {
	        wController.close();
	    }

	    @Test
	    public void testTemperatureMin() {
	        System.out.println("+++ testTemperatureMin +++");
	        double minTemperature = Arrays.stream(hourlyTemperatures).min().orElse(Double.MAX_VALUE);
	        Assert.assertEquals(minTemperature, wController.getTemperatureMinFromCache(), 0);
	    }

	    @Test
	    public void testTemperatureMax() {
	        System.out.println("+++ testTemperatureMax +++");
	        double maxTemperature = Arrays.stream(hourlyTemperatures).max().orElse(Double.MIN_VALUE);
	        Assert.assertEquals(maxTemperature, wController.getTemperatureMaxFromCache(), 0);
	    }

	    @Test
	    public void testTemperatureAverage() {
	        System.out.println("+++ testTemperatureAverage +++");
	        double sumTemp = Arrays.stream(hourlyTemperatures).sum();
	        double averageTemp = sumTemp / hourlyTemperatures.length;
	        Assert.assertEquals(averageTemp, wController.getTemperatureAverageFromCache(), 0);
	    }
	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}
