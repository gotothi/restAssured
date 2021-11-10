package gotoTestesApi.clashRoyale;

import gotoTestesApi.BaseRequest;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;

public class ClashRoyale extends BaseRequest {

    private HashMap parametros;
    private HashMap headers;
    private JSONObject resObject;

    public String requestApi() {

        parametros = new HashMap();

        headers = new HashMap();
        headers.put("Accept", "application/json");
        headers.put("authorization", "Bearer eyJ0eXUTvA7hAENQtj877CXnyd0A");

        Response response = requestGet("https://api.clashroyale.com/v1", "/cards", parametros, headers);

        resObject = new JSONObject(response.asString());

        return response.asString();
    }

    public String get_reason() {
        return resObject.get("reason").toString();
    }

    public String get_message() {
        return resObject.get("message").toString();
    }
}
