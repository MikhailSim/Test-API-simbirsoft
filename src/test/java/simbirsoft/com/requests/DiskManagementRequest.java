package simbirsoft.com.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.io.IOException;

public class DiskManagementRequest extends BaseRequest {
    private final String path = "/v1/disk/resources";

    public DiskManagementRequest() throws IOException {
    }

    @Step("GET Запрос: Получение метаинформации о диске пользователя")
    public Response getDiskMetaInfo() {
        return givenWithAuth()
                .spec(getRequestBuilder(host + "/v1/disk").build())
                .when()
                .get()
                .then()
                .extract()
                .response();
    }

    @Step("GET Запрос: Получение метаинформации о диске пользователя")
    public Response getFileOrFolderMetaInfo(String pathToFileOrFolder) {
        return givenWithAuth()
                .spec(getRequestBuilder(host + path).build())
                .when()
                .get(host + path + "?path=" + pathToFileOrFolder)
                .then()
                .extract()
                .response();
    }
}
