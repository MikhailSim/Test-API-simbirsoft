package simbirsoft.com.test;

import simbirsoft.com.requests.DiskManagementRequest;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import java.io.IOException;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class YandexDisk {

    private final String folderName = RandomStringUtils.randomAlphanumeric(12);
    private final String responsePath = "https://cloud-api.yandex.net/v1/disk/resources?path=test API";
    private final DiskManagementRequest request;
    private final String testName = "secretName";
    private final String testDataName = "secretDataName";
    private Response response;

    public YandexDisk() throws IOException {
        request = new DiskManagementRequest();
    }

    @Test(description = "Получить метаинформацию о диске пользователя")
    public void testGetMetaInfoAboutUsersDisk() {
        response = request.getDiskMetaInfo();
        response.then()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("getMetaInfo.json"));
    }

    @Test(description = "Получить метаинформацию о корневом каталоге")
    public void testGetFileOrFolderMetaInfo() {
        response = request.getFileOrFolderMetaInfo("/");
        response.then()
                .statusCode(200);
    }
}
