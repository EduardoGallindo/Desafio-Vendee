package pageObject;

import org.openqa.selenium.By;

public class VendeePageObject {

	public static final By campoEmail = By.xpath("//input[@placeholder='E-mail']");
	public static final By campoSenha = By.xpath("//input[@placeholder='Senha']");
	public static final By botãoEntrar = By.xpath("//button/span[text()='Entrar']");
	public static final By botãoNovaAtividade = By.xpath("//button/span[text()='Nova atividade']");
	public static final By botãoAbaNegócios = By.xpath("//li[@data-tip='Negócios']/a[@href='/negocios']");
	public static final By selecionarFunil = By.xpath("//div[@class='contentSelect']/select");
	public static final By botãoNovoNegócio = By.xpath("//button/span[text()='Novo negócio']");
	public static final By campoObservações = By.xpath("//span[text()='Observações']/../textarea");
	public static final By botãoSalvar = By.xpath("//span[text()='Salvar']/..");

	public static By botãoEtapa(String etapa) {
		return By
				.xpath("//div[@class='headerStage flex center divSpanText min pointer smallMarginBottom']/span[text()='"
						+ etapa + "']");
	}

	public static By campoPopupNovonegócio(String campo, int indice) {
		return By.xpath("(//span[text()='" + campo + "']/../input)[" + indice + "]");
	}

	public static By selecionarCampoPopupNovonegócio(String campo) {
		return By.xpath("//span[text()='" + campo + "']/..//select");
	}

	public static By selecionarCampoPopupNovoNegocioEspecial(String campo) {
		return By.xpath("//span[text()='" + campo + "']/../..//input");
	}


	public static By textoNovaOportunidade(String etapa, String nomeOportunidade) {
		return By.xpath("//span[text()='" + etapa + "']/../.././/span[text()='" + nomeOportunidade + "']");
	}

	public static By botãoAutoCompletar(String nome) {
		return By.xpath("//*[contains(text(),'" + nome +"')]");
	}

}
