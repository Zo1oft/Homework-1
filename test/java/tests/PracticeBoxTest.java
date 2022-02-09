package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeBoxTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Max");
        $("#lastName").setValue("Zhurkin");
        $("#userEmail").setValue("max@guru.com");
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue("9630479505");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__month-select").selectOption("January");
        $(byText("27")).click();
        $("#subjectsInput").setValue("History");
        $("#hobbies-checkbox-1").doubleClick();
        $("#uploadPicture").uploadFile(new File("src/test/java/data/student.jpg"));
        $("#currentAddress").setValue("Ekaterinburg");
        $("#state").click();
        $(byText("NCR")).scrollTo().click();
        $("#city").click();
        $(byText("Delhi")).scrollTo().click();
        $("#submit").click();


        $(".table-responsive").shouldHave(text("Max Zhurkin"));
        $(".table-responsive").shouldHave(text("max@guru.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("27 January,1990"));
        $(".table-responsive").shouldHave(text("History"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("student.jpg"));
        $(".table-responsive").shouldHave(text("Ekaterinburg"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));

    }
}