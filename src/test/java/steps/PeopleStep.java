package steps;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class PeopleStep {
    String endpoint;
    Response resposta;


    @Dado("que exista o endpoint: {string}")
    public void queExistaOEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Quando("fizer uma requisição do tipo GET na pessoa com código: {int}")
    public void fizerUmaRequisicaoDoTipoGETNaPessoaComCodigo(int codigoPessoa) {
        endpoint = endpoint+"/"+codigoPessoa;
        resposta =  given()
                .log().all()
                .when()
                .get(endpoint);

    }

    @Entao("valido que a resposta contem o nome: {string}")
    public void validoQueARespostaContemONome(String nome) {
         resposta.then()
                 .assertThat()
                .body(containsString(nome));

    }

    @Entao("valido que o codigo de retorno é: {int}")
    public void validoQueOCodigoDeRetorno(int codigo) {
        resposta.then().assertThat()
                .statusCode(codigo);
    }
}
