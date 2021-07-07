package pages;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginPage extends BasePage {
	WebDriverWait wait;
	String fname = "LoginTEST_";

	// Mapa dos elementos do fluxo de Login
	By btnLogin = By.xpath("//a[@id='menuUserLink']");
	By cmpUsername = By.xpath("//input[@name='username']");
	By cmpSenha = By.xpath("//input[@name='password']");
	By btnSignIn = By.xpath("//button[.='SIGN IN']");
	By lblMsgLoginErro = By.xpath(".//*[@id='signInResultMessage']");
	By lblUserLoginSucesso = By.xpath(".//*[contains (@class, 'containMiniTitle')]");
	By loader = By.xpath(".//*[@class='loader']");

	public LoginPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 20);
	}

	// Criação dos métodos com Wait + Elementos

	public void setBtnLogin() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
			driver.findElement(btnLogin).click();
		} catch (Exception e) {
			setScFalha();

		}
	}

	public void setAcessoSite(String site) throws Exception {
		try {
			driver.get(site);
			driver.manage().window().maximize();
		} catch (Exception e) {
			setScFalha();
		}
	}

	public void setCmpUsername(String username) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(cmpUsername));
			driver.findElement(cmpUsername).sendKeys(username);
		} catch (Exception e) {
			setScFalha();

		}
	}

	public void setCmpSenha(String senha) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(cmpSenha));
			driver.findElement(cmpSenha).sendKeys(senha);

		} catch (Exception e) {
			setScFalha();
		}
	}

	public void setBtnSignIn() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnSignIn));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			driver.findElement(btnSignIn).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

		} catch (Exception e) {
			setScFalha();
		}
	}

	public void setValidaLoginSucesso(String username) throws Exception {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			wait.until(ExpectedConditions.visibilityOfElementLocated(lblUserLoginSucesso));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			String titleLoginSucesso = driver.findElement(lblUserLoginSucesso).getText();
			System.out.println(titleLoginSucesso);
			assertEquals(username, titleLoginSucesso = driver.findElement(lblUserLoginSucesso).getText());
			takeScreenShot(fname + "SUCESSO AO LOGAR_");
		} catch (Exception e) {
			setScFalha();
		}
	}

	public void setValidaMsgErro() throws Exception {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			wait.until(ExpectedConditions.visibilityOfElementLocated(lblMsgLoginErro));
			String msgStatusLogin = driver.findElement(lblMsgLoginErro).getText();
			System.out.println(msgStatusLogin);
			assertEquals("Incorrect user name or password.", msgStatusLogin);
			takeScreenShot(fname + "FALHA AO LOGAR_");
		} catch (Exception e) {
			setScFalha();
		}
	}

	public void setScFalha() throws Exception {
		takeScreenShot(fname + "FALHOU");
	}

}
