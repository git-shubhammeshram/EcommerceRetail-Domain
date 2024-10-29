package Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {

	public static ExtentReports report;

	public static ExtentReports getExtentReportManager() {

		if (report == null) {

			String reportFileName = formatedDate();

			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					"D:\\IJ-PROJECTS\\EcommerceRetail-Domain\\ExtentReports\\" + reportFileName + ".html");

			report = new ExtentReports();

			report.attachReporter(htmlReporter);

			report.setSystemInfo("OS", "Windows");
			report.setSystemInfo("ENVIRONMENT", "PRODUCTION");
			report.setSystemInfo("BUILD NUMBER", "8.81");
			report.setSystemInfo("BROWSER", "Chrome");

			htmlReporter.config().setDocumentTitle("UI Automation");
			htmlReporter.config().setReportName("UI Test Report");

		}

		return report;

	}

	private static String formatedDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date = new Date();
		String reportFileName = "Extent Report Dated -" + formatter.format(date);
		return reportFileName;
	}

}
