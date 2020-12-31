package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.DSL;
import org.junit.Assert;
import pageObject.VendeePageObject;

public class VendeeActions {
	WebDriver driver;
	DSL dsl;
	WebDriverWait wait;

	public VendeeActions(WebDriver driver, DSL dsl) {
		this.driver = driver;
		this.dsl = dsl;
		wait = new WebDriverWait(driver, 20);
	}

	public void realizarLogin(String email, String senha) {
		dsl.escrever(VendeePageObject.campoEmail, email);
		dsl.escrever(VendeePageObject.campoSenha, senha);
		dsl.clicar(VendeePageObject.botãoEntrar);
	}

	public void validarAcesso() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(VendeePageObject.botãoNovaAtividade));
		dsl.validaUrl("https://vendee-back.firebaseapp.com/atividades");
		driver.findElement(VendeePageObject.botãoNovaAtividade);
	}

	public void acessarAbaNegócios() {
		dsl.clicar(VendeePageObject.botãoAbaNegócios);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VendeePageObject.botãoNovoNegócio));
		dsl.validaUrl("https://vendee-back.firebaseapp.com/negocios");
	}

	public void selecionarFunilPadrão() {
		dsl.selecionarElementoporTexto(VendeePageObject.selecionarFunil, "Funil padrão");
	}

	public void selecionarEtapa(String etapa) {
		dsl.clicar(VendeePageObject.botãoNovoNegócio);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(VendeePageObject.campoPopupNovonegócio("Nome do negócio", 1)));
		dsl.clicar(VendeePageObject.botãoEtapa(etapa));
	}

	public void preencherDadosNegocio(String nomeNovoNegócio) {
		dsl.escrever(VendeePageObject.campoPopupNovonegócio("Nome do negócio", 1), nomeNovoNegócio);
		dsl.escrever(VendeePageObject.selecionarCampoPopupNovoNegocioEspecial("Empresa"), "Empresa Teste");
		dsl.clicar(VendeePageObject.botãoAutoCompletar("Empresa Teste"));
		dsl.selecionarElementoporTexto(VendeePageObject.selecionarCampoPopupNovonegócio("Segmento de mercado"),
				"Outros");
		dsl.escrever(VendeePageObject.campoPopupNovonegócio("Site", 1), "Teste.com.br");
		dsl.escrever(VendeePageObject.campoPopupNovonegócio("E-mail", 1), "Teste@mailinator.com");
		dsl.escrever(VendeePageObject.campoPopupNovonegócio("Telefone principal", 1), "11996826338");
		dsl.escrever(VendeePageObject.campoPopupNovonegócio("Rede social", 1), "Teste");
		dsl.escrever(VendeePageObject.selecionarCampoPopupNovoNegocioEspecial("Contato"), "Contato Teste");
		dsl.clicar(VendeePageObject.botãoAutoCompletar("Contato Teste"));
		dsl.escrever(VendeePageObject.campoPopupNovonegócio("Cargo", 1), "Teste");
		dsl.escrever(VendeePageObject.campoPopupNovonegócio("E-mail", 2), "Teste@mailinator.com");
		dsl.escrever(VendeePageObject.campoPopupNovonegócio("Telefone principal", 2), "11996826338");
		dsl.escrever(VendeePageObject.campoPopupNovonegócio("Telefone secundário", 1), "11996826339");
		dsl.escrever(VendeePageObject.campoPopupNovonegócio("Whatsapp", 1), "11996826338");
		dsl.selecionarElementoporTexto(VendeePageObject.selecionarCampoPopupNovonegócio("Responsável"), "Douglas QA");
		dsl.escrever(VendeePageObject.campoPopupNovonegócio("Data prevista do negócio", 1), "03052021");
		dsl.selecionarElementoporTexto(VendeePageObject.selecionarCampoPopupNovonegócio("Origem do lead"),
				"Base de clientes");
		dsl.selecionarElementoporTexto(VendeePageObject.selecionarCampoPopupNovonegócio("Dores"), "Preço");
		dsl.escrever(VendeePageObject.campoPopupNovonegócio("Valor único", 1), "21000");
		dsl.escrever(VendeePageObject.campoPopupNovonegócio("Valor recorrente", 1), "2000");
		dsl.escrever(VendeePageObject.campoObservações, "N/A");
		dsl.clicar(VendeePageObject.botãoSalvar);
	}

	public void validarCriacaoNegocio(String etapa, String nomeNovoNegócio) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(VendeePageObject.textoNovaOportunidade(etapa, nomeNovoNegócio)));
		Assert.assertEquals(nomeNovoNegócio,
				dsl.obterTexto(VendeePageObject.textoNovaOportunidade(etapa, nomeNovoNegócio)));
	}

}
