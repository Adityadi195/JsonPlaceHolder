package starter.stepdef.posts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.placeholder.BodyResponses;
import starter.placeholder.JsonPlaceHolderAPI;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetPostsStepDef {
    @Steps
    JsonPlaceHolderAPI jsonPlaceHolderAPI;

    // Get list post
    @Given("Get list posts")
    public void getListPosts() {
        jsonPlaceHolderAPI.getListPosts();
    }
    @When("Send get list posts")
    public void sendGetListPosts() {
        SerenityRest.when().get(JsonPlaceHolderAPI.LIST_POSTS);
    }

//    @Then("Status code should be {int} OK")
//    public void statusCodeShouldBeOK(int OK) {
//        SerenityRest.then().statusCode(OK);
//    }

    @And("Response body field id, userId, title, body should be exist")
    public void responseBodyFieldIdUserIdTitleBodyShouldBeExist() {
        SerenityRest.and()
                .body(BodyResponses.ID, notNullValue())
                .body(BodyResponses.USER_ID, notNullValue())
                .body(BodyResponses.TITLE, notNullValue())
                .body(BodyResponses.BODY, notNullValue());
    }

// get single post with id
    @Given("Get single posts with valid parameter id {int}")
    public void getSinglePostsWithValidParameterId(int id) {
        jsonPlaceHolderAPI.getPosts(id);
    }

    @When("Send get single posts")
    public void sendGetSinglePosts() {
        SerenityRest.when().get(JsonPlaceHolderAPI.SINGLE_POSTS);
    }

    @And("Response body posts ID should be {int}")
    public void responseBodyPostsIDShouldBe(int id) {
        SerenityRest.and()
                .body(BodyResponses.ID, equalTo(id));
    }


//get single post invalid id
    @Given("Get single posts with invalid parameter id {string}")
    public void getSinglePostsWithInvalidParameterId(String id) {
        jsonPlaceHolderAPI.getPosts(id);
    }

    @When("Send get posts")
    public void sendGetPosts() {
    SerenityRest.when().get(JsonPlaceHolderAPI.SINGLE_POSTS);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int BadReq) {
        SerenityRest.then().statusCode(BadReq);
    }

//Get single post with exceed id
    @Given("Get single posts with exceed parameter id {int}")
    public void getSinglePostsWithExceedParameterId(int id) {
        jsonPlaceHolderAPI.getPosts(id);
    }

//    @Then("Status code should be {int} Not Found")
//    public void statusCodeShouldBeNotFound(int nf) {
//        SerenityRest.then().statusCode(nf);
//    }

}
