package pages;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void takeScreenShot(String fname) throws Exception {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("ddMMyyyHHmm");
		LocalDateTime horaAgora = LocalDateTime.now();  
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imageFileDir = "./relatorios/";
		FileUtils.copyFile(scrFile, new File(imageFileDir, fname + dateFormat.format(horaAgora) + ".jpg"));
	}
}