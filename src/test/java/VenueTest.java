import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

public class VenueTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Venue_Instantiates_true() {
    Venue myVenue = new Venue("Marquee Theatre");
    assertEquals(true, myVenue instanceof Venue);
  }

  @Test
  public void getVenueeInfo_VenueInstantiates_String() {
    Venue myVenue = new Venue("Marquee Theatre");
    assertEquals("Marquee Theatre", myVenue.getName());
  }

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Venue.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Venue firstVenue = new Venue("Marquee Theatre");
    Venue secondVenue = new Venue("Marquee Theatre");
    assertTrue(firstVenue.equals(secondVenue));
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Venue myVenue = new Venue("Marquee Theatre");
    myVenue.save();
    assertTrue(Venue.all().get(0).equals(myVenue));
  }

  @Test
  public void save_assignsIdToObject() {
    Venue myVenue = new Venue("Marquee Theatre");
    myVenue.save();
    Venue savedVenue = Venue.all().get(0);
    assertEquals(myVenue.getId(), savedVenue.getId());
  }

  @Test
  public void find_findVenueInDatabase_true() {
    Venue myVenue = new Venue("Marquee Theatre");
    myVenue.save();
    Venue savedVenue = Venue.find(myVenue.getId());
    assertTrue(myVenue.equals(savedVenue));
  }

  @Test
  public void update_updatesVenue_true() {
    Venue myVenue = new Venue("Marquee Theatre");
    myVenue.save();
    myVenue.update("Kodiak Theatre");
    assertEquals("Kodiak Theatre", Venue.find(myVenue.getId()).getName());
  }

  @Test
  public void addRecipe_addsBandToVenue_true() {
    Venue myVenue = new Venue("Marquee Theatre");
    myVenue.save();
    Band myBand = new Band("Blink-182");
    myBand.save();
    myVenue.addBand(myBand);
    Band savedBand = myVenue.getBands().get(0);
    assertTrue(myBand.equals(savedBand));
  }

  @Test
  public void getRecipes_returnsAllBands_List() {
    Venue myVenue = new Venue("Marquee Theatre");
    myVenue.save();
    Band myBand = new Band("Blink-182");
    myBand.save();
    myVenue.addBand(myBand);
    List savedBands = myVenue.getBands();
    assertEquals(1, savedBands.size());
  }

  @Test
  public void delete_deletesAllBandsAndVenuesAssociations() {
    Venue myVenue = new Venue("Marquee Theatre");
    myVenue.save();
    Band myBand = new Band("Blink-182");
    myVenue.addBand(myBand);
    myVenue.delete();
    assertEquals(0, myBand.getVenues().size());
  }
}
