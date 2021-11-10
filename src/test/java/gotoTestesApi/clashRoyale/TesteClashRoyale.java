package gotoTestesApi.clashRoyale;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TesteClashRoyale {

    @Test
    @DisplayName("Verifica erro de autorizacao na api do Clash Royale")
    public void verificarErroApi(){

        ClashRoyale clash = new ClashRoyale();
        String resClash = clash.requestApi();

        Assert.assertEquals("fail.. Reason","accessDenied", clash.get_reason());
        Assert.assertTrue("erro na mensagem",clash.get_message().contains("Invalid authorization"));

        // Verifica o contrato
        Assert.assertThat(resClash, matchesJsonSchemaInClasspath("schemas/clashErro.json"));
    }
}
