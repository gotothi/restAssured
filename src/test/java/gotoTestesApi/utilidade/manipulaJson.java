package gotoTestesApi.utilidade;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class manipulaJson {

    private void manipulaJsonArrayObject() {
        JSONArray array = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("codigoProduto", "91");
        jsonObj.put("codigoSubProduto", "0999");

        array.put(jsonObj);

        Map PAYLOAD = new HashMap();
        PAYLOAD.put("acessToken", "1234");
        PAYLOAD.put("expireToken", "23");
        PAYLOAD.put("produtos", array);

        System.out.println(PAYLOAD);
    }
}
