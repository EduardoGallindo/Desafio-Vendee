package stepsDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import actions.VendeeActions;
import core.DSL;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class StepsDefinition {
	
	WebDriver driver;
	String Email;
	String Senha;
	String Etapa;
	String NomeNovoNegócio;
	
	VendeeActions actions;
	DSL dsl;
	
	@Before
	public void Inicializar() {
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
		options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dsl = new DSL(driver);
		actions = new VendeeActions(driver, dsl);
	}
	
	@After
	public void Finalizar() {
		driver.quit();
	}
	
	@Dado("que possuo cadastro com o email {string} e a senha {string}")
	public void que_possuo_cadastro_com_meu_e(String email, String senha) {
		Email = email;
		Senha = senha;
	}

	@Dado("que desejo acessar minha conta no site Vendee")
	public void que_desejo_acessar_minha_conta_no_site_vendee() {
		dsl.acessarSite("https://vendee-back.firebaseapp.com/");
	}

	@Quando("acessar o site")
	public void acessar_o_site() {
		dsl.validaTitulo("Vendee");
	}

	@Então("devo realizar o login")
	public void devo_realizar_o_login() {
		actions.realizarLogin(Email, Senha);
	}

	@Então("validar que acessei minha conta")
	public void validar_que_acessei_minha_conta() {
		actions.validarAcesso();
	}
	
	@Dado("que desejo cadastrar um novo negócio na etapa {string}")
	public void que_desejo_cadastrar_um_novo_negócio_na_etapa(String etapa) {
		Etapa = etapa;
	}
	
	@Quando("acessar aba Negócios")
	public void acessar_aba_negócios() {
		actions.acessarAbaNegócios();
	}

	@Quando("selecionar o Funil Padrão")
	public void selecionar_o_funil_padrão() {
		actions.selecionarFunilPadrão();
	}
	
	@Então("devo selecionar a opção referente a etapa desejada")
	public void selecionar_a_opção_referente_a_etapa_desejada() {
		actions.selecionarEtapa(Etapa);
	}

	@Então("devo preencher os dados desse novo negócio de nome {string} e clicar em salvar")
	public void devo_preencher_os_dados_dessa_nova_oportunidade_e_clicar_em_salvar(String nomeNovoNegócio) {
		NomeNovoNegócio = nomeNovoNegócio;
		actions.preencherDadosNegocio(NomeNovoNegócio);
	}

	@Então("validar que o novo negócio foi criado")
	public void validar_que_a_nova_oportunidade_foi_criada() {
		actions.validarCriacaoNegocio(Etapa, NomeNovoNegócio);
	}
}
