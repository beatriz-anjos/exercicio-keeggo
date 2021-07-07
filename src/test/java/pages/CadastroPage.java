package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPage extends BasePage {
	WebDriverWait wait;
	String fname = "CadastroTEST_";

	By btnLogin = By.xpath("//a[@id='menuUserLink']");
	By btnCreateNewAcc = By.xpath("//a[.='CREATE NEW ACCOUNT']");
	By cmpUsername = By.xpath("//input[@name='usernameRegisterPage']");
	By cmpEmail = By.xpath("//input[@name='emailRegisterPage']");
	By cmpSenha = By.xpath("//input[@name='passwordRegisterPage']");
	By cmpConfirmaSenha = By.xpath("//input[@name='confirm_passwordRegisterPage']");
	By cmpPrimeiroNome = By.xpath("//input[@name='first_nameRegisterPage']");
	By cmpSobrenome = By.xpath("//input[@name='last_nameRegisterPage']");
	By cmpTelefone = By.xpath("//input[@name='phone_numberRegisterPage']");
	By checkBoxAgree = By.xpath("//input[@name='i_agree']");
	By btnRegister = By.xpath("//button[@id='register_btnundefined']");
	By msgErroEmail = By.xpath("(//label[@class='invalid'])[2]");
	By lblUserLoginSucesso = By.xpath(".//*[contains (@class, 'containMiniTitle')]");
	By loader = By.xpath(".//*[@class='loader']");

	public CadastroPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 20);
	}

	public void setBtnLogin() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
			driver.findElement(btnLogin).click();
		} catch (Exception e) {
			setScFalha();
		}
	}

	public void setBtnCreateNewAcc() throws Exception {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			wait.until(ExpectedConditions.visibilityOfElementLocated(btnCreateNewAcc));
			driver.findElement(btnCreateNewAcc).click();
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

	public void setCmpEmail(String email)  throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(cmpEmail));
			driver.findElement(cmpEmail).sendKeys(email);
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

	public void setCmpConfirmaSenha(String senha) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(cmpConfirmaSenha));
			driver.findElement(cmpConfirmaSenha).sendKeys(senha);
		} catch (Exception e) {
			setScFalha();
		}
	}

	public void setCmpPrimeiroNome(String primeiroNome) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(cmpPrimeiroNome));
			driver.findElement(cmpPrimeiroNome).sendKeys(primeiroNome);
		} catch (Exception e) {
			setScFalha();
		}
	}

	public void setCmpSobrenome(String sobrenome) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(cmpSobrenome));
			driver.findElement(cmpSobrenome).sendKeys(sobrenome);
		} catch (Exception e) {
			setScFalha();
		}
	}

	public void setCmpTelefone(String telefone) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(cmpTelefone));
			driver.findElement(cmpTelefone).sendKeys(telefone);
		} catch (Exception e) {
			setScFalha();
		}
	}

	public void setCheckBoxAgree() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(checkBoxAgree));
			driver.findElement(checkBoxAgree).click();
		} catch (Exception e) {
			setScFalha();
		}
	}

	public void setBtnRegister() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnRegister));
			driver.findElement(btnRegister).click();
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
			assertEquals(username, titleLoginSucesso);
			takeScreenShot(fname + "CADASTRO FEITO COM SUCESSO_");
		} catch (Exception e) {
			setScFalha();
		}
	}

	public void setValidaErroCadastro() throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(btnRegister));
			String msgErroEmailV = driver.findElement(msgErroEmail).getText();
			System.out.println(msgErroEmailV);
			assertEquals("Email field is required", msgErroEmailV);
			takeScreenShot(fname + "ERRO POIS EMAIL ESTA EM BRANCO_");
		} catch (Exception e) {
			setScFalha();
		}
	}

	public void setScFalha() throws Exception {
		takeScreenShot(fname + "FALHOU");
	}

}
