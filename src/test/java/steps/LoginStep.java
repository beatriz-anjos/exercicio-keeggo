package steps;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.LoginPage;

public class LoginStep {
	ChromeDriver driver = new ChromeDriver();
	LoginPage loginPage = new LoginPage(driver);
	
	@Dado("^que eu acesse o site para login \"([^\"]*)\"$")
	public void que_sesu_acesse_o_site(String site) throws Throwable {
		loginPage.setAcessoSite(site);
	}

	@E("^clico no icone de login$")
	public void clico_no_icone_de_login() throws Throwable {
		loginPage.setBtnLogin();
	}

	@E("^insiro username \"([^\"]*)\" e senha \"([^\"]*)\" incorretos$")
	public void insiro_username_e_senha_incorretos(String username, String senha) throws Throwable {
		loginPage.setCmpUsername(username);
		loginPage.setCmpSenha(senha);
	}

	@Quando("^insiro username \"([^\"]*)\" e senha \"([^\"]*)\"$")
	public void insiro_username_e_senha(String username, String senha) throws Throwable {
		loginPage.setCmpUsername(username);
		loginPage.setCmpSenha(senha);
	}

	@Quando("^clico em 'Sign In'$")
	public void clico_em_Sign_In() throws Throwable {
		loginPage.setBtnSignIn();
	}

	@Entao("^valido que o Login nao pode ser efetuado com a mensagem 'Incorrect user name or password\\.'$")
	public void valido_que_o_Login_nao_pode_ser_efetuado_com_a_mensagem_Incorrect_user_name_or_password() throws Exception {
		loginPage.setValidaMsgErro();
	}

	@Entao("^valido que o Login foi efetuado com sucesso com o \"([^\"]*)\"$")
	public void valido_que_o_Login_foi_efetuado_com_sucesso_com_o(String username) throws Throwable {
		loginPage.setValidaLoginSucesso(username);
	}

	@After
	public void bfechaBrowser() throws InterruptedException {
		driver.quit();
	}

}
