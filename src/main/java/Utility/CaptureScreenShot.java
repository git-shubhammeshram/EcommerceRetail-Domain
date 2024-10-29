package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;

public class CaptureScreenShot extends TestBase {


	public static void getScreenShots(String filename) throws IOException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date();
        String START = "Screenshot Captured Dated -" + formatter.format(date); 
		
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\IJ-PROJECTS\\EcommerceRetail-Domain\\src\\main\\resources\\ScreenShots\\"+ START + filename +".png");

		FileHandler.copy(source, dest);
	}

}
