package runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(	plugin = "pretty" 
					,monochrome = true 
					,dryRun = false 
					,features = "src/test/java/features/Efetuar-Cadastro-Novo-Negócio.feature"
					,glue={"stepsDefinition"}
)
public class CadastroNegócioVendeeRunner {

}