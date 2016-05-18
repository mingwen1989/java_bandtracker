import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.junit.*;
import java.util.List;
import org.sql2o.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/bandtracker_test", null, null);
  }
  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteBandQuery = "DELETE FROM bands *;";
      String deleteVenueQuery = "DELETE FROM venues *;";
      con.createQuery(deleteBandQuery).executeUpdate();
      con.createQuery(deleteVenueQuery).executeUpdate();
    }
  }

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Band Tracker");
  }
  @Test
  public void gotoVenuesTest(){
    goTo("http://localhost:4567/");
    click("a", withText("View Venues"));
    assertThat(pageSource()).contains("Venues");
  }
  @Test
  public void gotoBandsTest(){
    goTo("http://localhost:4567/");
    click("a", withText("View Bands"));
    assertThat(pageSource()).contains("Bands");
  }
  @Test
  public void gotoVenuesfromBandTest(){
    goTo("http://localhost:4567/");
    click("a", withText("View Bands"));
    click(".btn3");
    assertThat(pageSource()).contains("Venues");
  }
  @Test
  public void gotoBandsfromVenuesTest(){
    goTo("http://localhost:4567/");
    click("a", withText("View Venues"));
    click(".btn3");
    assertThat(pageSource()).contains("Bands");
  }
  @Test
  public void deleteBandsTest(){
    goTo("http://localhost:4567/");
    click("a", withText("View Bands"));
    click(".btn2");
    assertThat(pageSource()).contains("Bands");
  }

  @Test
  public void deleteVenuesTest(){
    goTo("http://localhost:4567/");
    click("a", withText("View Venues"));
    click(".btn2");
    assertThat(pageSource()).contains("Venues");
  }

  @Test
  public void bandIsCreatedTest(){
    goTo("http://localhost:4567/");
    click("a", withText("View Bands"));
    fill("#bandName").with("Social Distortion");
    submit(".btn1");
    assertThat(pageSource()).contains("Social Distortion");
  }

  @Test
  public void addVenueTest(){
    goTo("http://localhost:4567/");
    click("a", withText("View Venues"));
    fill("#venueName").with("Kodiak Theatre");
    submit(".btn1");
    assertThat(pageSource()).contains("Kodiak Theatre");
  }
}
