import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import pojos.UserPojoFull;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class RestTest {

    private static final int TARGET_NUM = 6;

    @Test
    public void getUsers() {
        List<UserPojoFull> users = given()
                    .baseUri("https://reqres.in/api")
                    .basePath("/users")
                    .contentType(ContentType.JSON)
                    .when().get()
                    .then().statusCode(200)
                    .extract().jsonPath().getList("data", UserPojoFull.class);

        assertThat(users.size()).isEqualTo(TARGET_NUM);
    }
}
