package steps;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.CadastroPage;

public class CadastroStep {
	ChromeDriver driver = new ChromeDriver();
	CadastroPage cadastroPage = new CadastroPage(driver);

	@Dado("^que eu acesse o site para cadastro \"([^\"]*)\"$")
	public void que_sesu_acesse_o_site(String site) throws Throwable {
		driver.get(site);
		driver.manage().window().maximize();
	}
	@Dado("^clico no icone de login para cadastrar$")
	public void clico_no_icone_de_login_para_cadastrar() throws Throwable {
		cadastroPage.setBtnLogin();
	}
	@Quando("^clico em 'Create new Account'$")
	public void clico_em_Create_new_Account() throws Exception {
		cadastroPage.setBtnCreateNewAcc();
	}

	@E("^preencho os detalhes da conta com username \"([^\"]*)\" email \"([^\"]*)\" e senha \"([^\"]*)\"$")
	public void preencho_os_detalhes_da_conta_com_username_email_e_senha(String username, String email, String senha) throws Exception {
		cadastroPage.setCmpUsername(username);
		cadastroPage.setCmpEmail(email);
		cadastroPage.setCmpSenha(senha);
		cadastroPage.setCmpConfirmaSenha(senha);
	}

	@E("^preencho os campos de nome \"([^\"]*)\" sobrenome \"([^\"]*)\" e telefone \"([^\"]*)\"$")
	public void preencho_os_campos_de_nome_sobrenome_e_telefone(String primeiroNome, String sobrenome,
			String telefone) throws Exception {
		cadastroPage.setCmpPrimeiroNome(primeiroNome);
		cadastroPage.setCmpSobrenome(sobrenome);
		cadastroPage.setCmpTelefone(telefone);
	}

	@Quando("^clico na checkbox de I Agree$")
	public void clico_na_checkbox_de_I_Agree() throws Exception {
		cadastroPage.setCheckBoxAgree();
	}

	@E("^clico em 'Register'$")
	public void clico_em_Register() throws Exception {
		cadastroPage.setBtnRegister();
	}

	

	@Entao("^valido que a conta foi criada com sucesso com login \"([^\"]*)\"$")
	public void valido_que_a_conta_foi_criada_com_sucesso(String username) throws Throwable {
		cadastroPage.setValidaLoginSucesso(username);
	}

	@Entao("^valido que falhou pois o campo email e obrigatorio$")
	public void valido_que_falhou_pois_o_campo_email_e_obrigatorio() throws Exception {
		cadastroPage.setValidaErroCadastro();
	}

	@After
	public void bfechaBrowser() throws InterruptedException {
		driver.quit();
	}

}
