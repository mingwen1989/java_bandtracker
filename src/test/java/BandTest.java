import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

public class BandTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Band_Instantiates_true() {
    Band myBand = new Band("Blink-182");
    assertEquals(true, myBand instanceof Band);
  }

  @Test
  public void getBandinfo_bandInstantiates_String() {
    Band myBand = new Band("Blink-182");
    assertEquals("Blink-182", myBand.getName());
  }

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Band.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Band firstBand = new Band("Blink-182");
    Band secondBand = new Band("Blink-182");
    assertTrue(firstBand.equals(secondBand));
  }
  //
  @Test
  public void save_savesIntoDatabase_true() {
    Band myBand = new Band("Blink-182");
    myBand.save();
    assertTrue(Band.all().get(0).equals(myBand));
  }

  @Test
  public void save_assignsIdToObject() {
    Band myBand = new Band("Blink-182");
    myBand.save();
    Band savedBand = Band.all().get(0);
    assertEquals(myBand.getId(), savedBand.getId());
  }

  @Test
  public void find_findBandInDatabase_true() {
    Band myBand = new Band("Blink-182");
    myBand.save();
    Band savedBand = Band.find(myBand.getId());
    assertTrue(myBand.equals(savedBand));
  }

  @Test
  public void update_updatesName_true() {
    Band myBand = new Band("Blink-182");
    myBand.save();
    myBand.update("Blink-182");
    assertEquals("Blink-182", Band.find(myBand.getId()).getName());
  }

  // @Test
  // public void addBand_addsBandToAlbum_true() {
  //   Band myBand = new Band("Blink-182");
  //   myBand.save();
  //   Venue myVenue = new Venue("Marquee Theater");
  //   myVenue.save();
  //   myBand.addVenue(myVenue);
  //   Venue savedVenue = myBand.getVenues().get(0);
  //   assertTrue(myVenue.equals(savedVenue));
  // }

  @Test
  public void getVenues_returnsAllVenues_List() {
    Band myBand = new Band("Blink-182");
    myBand.save();
    Venue myVenue = new Venue("Marquee Theater");
    myVenue.save();
    myBand.addVenue(myVenue);
    List savedVenues = myBand.getVenues();
    assertEquals(1, savedVenues.size());
  }


  @Test
  public void delete_deletesAllBandsAndVenuesAssociations() {
    Band myBand = new Band("Blink-182");
    myBand.save();
    Venue myVenue = new Venue("Marquee Theater");
    myBand.addVenue(myVenue);
    myBand.delete();
    assertEquals(0, myVenue.getBands().size());
  }

}
