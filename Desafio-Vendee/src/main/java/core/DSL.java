package core;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class DSL {

	WebDriverWait wait;
	WebDriver driver;
	Actions builder; 

	public DSL(WebDriver Driver) {
		this.driver = Driver;
		wait = new WebDriverWait(driver, 3);
		builder = new Actions(driver);
	}

	public void acessarSite(String URL) {
		driver.get(URL);
	}

	public void escrever(By by, String texto) {
		for (int j = 0; j < 2; j++) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(by));
				WebElement elemento = driver.findElement(by);
				builder.moveToElement(elemento);
				elemento.click();
				elemento.clear();
				String[] output = texto.split(Pattern.quote(""));
				for (String s : output) {
					elemento.sendKeys(s);
				}
				j = 2;
			} catch (NoSuchElementException e) {
				System.out.println("Erro na ação de input");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			} catch (StaleElementReferenceException s) {
				System.out.println("Erro na ação de input");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String obterTexto(By by) {
		return driver.findElement(by).getText();
	}

	public void clicar(By by) {
		for (int j = 0; j < 3; j++) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(by));
				WebElement elemento = driver.findElement(by);
				builder.moveToElement(elemento);
				elemento.click();
				j = 2;
			} catch (NoSuchElementException e) {
				System.out.println("Erro na ação de click");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			} catch (StaleElementReferenceException s) {
				System.out.println("Erro na ação de click");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void focar(By by) {
		for (int j = 0; j < 2; j++) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(by));
				WebElement elemento = driver.findElement(by);
				builder.moveToElement(elemento);
				j = 2;
			} catch (NoSuchElementException e) {
				System.out.println("Erro na ação de focar");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			} catch (StaleElementReferenceException s) {
				System.out.println("Erro na ação de focar");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[text()='" + texto + "']"));
	}

	public void selecionarElementoporTexto(By by, String Texto) {
		WebElement elemento = driver.findElement(by);
		builder.moveToElement(elemento);
		Select select = new Select(elemento);
		select.selectByVisibleText(Texto);
	}

	public void selecionarElementoporValor(By by, String Valor) {
		WebElement elemento = driver.findElement(by);
		builder.moveToElement(elemento);
		Select select = new Select(elemento);
		select.selectByValue(Valor);
	}

	public void validaTitulo(String Titulo) {
		Assert.assertEquals(Titulo, driver.getTitle());
	}
	
	public void validaUrl(String Url) {
		Assert.assertEquals(Url, driver.getCurrentUrl());
	}

	public void validaTexto(String Texto, By by) {
		Assert.assertEquals(Texto, obterTexto(by));
	}
	
	public void pressionarTeclaEnter() {
        try {
			Robot robot = new Robot();
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

}
