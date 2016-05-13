import java.util.List;
import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public class Venue {
  private int id;
  private String name;


  public Venue(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public static List<Venue> all() {
    String sql = "SELECT id, name FROM venues";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Venue.class);
    }
  }

  // @Override
  // public boolean equals(Object otherVenue) {
  //   if (!(otherVenue instanceof Venue)) {
  //     return false;
  //   } else {
  //     Venue newVenue = (Venue) otherVenue;
  //     return this.getName().equals(newVenue.getName()) &&
  //            this.getId() == newVenue.getId();
  //   }
  // }
  //
  // public void save() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "INSERT INTO venues(name) VALUES (:name)";
  //     this.id = (int) con.createQuery(sql, true)
  //       .addParameter("name", this.name)
  //       .executeUpdate()
  //       .getKey();
  //   }
  // }
  //
  // public static Venue find(int id) {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "SELECT * FROM venues where id=:id";
  //     Venue venue = con.createQuery(sql)
  //       .addParameter("id", id)
  //       .executeAndFetchFirst(Venue.class);
  //     return venue;
  //   }
  // }
  //
  // public void update(String newVenue) {
  //   try(Connection con = DB.sql2o.open()){
  //     String sql = "UPDATE venues SET name = :name WHERE id = :id";
  //     con.createQuery(sql)
  //     .addParameter("name", newVenue)
  //     .addParameter("id", this.id)
  //     .executeUpdate();
  //   }
  // }
  //
  // public void addRecipe(Recipe recipe) {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "INSERT INTO recipe_venue (recipe_id, venue_id) VALUES (:recipe_id, :venue_id)";
  //     con.createQuery(sql)
  //     .addParameter("venue_id", this.getId())
  //     .addParameter("recipe_id", recipe.getId())
  //     .executeUpdate();
  //   }
  // }
  //
  // public List<Recipe> getRecipes() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String joinQuery = "SELECT recipe_id FROM recipe_venue WHERE venue_id = :venue_id";
  //     List<Integer> recipeIds = con.createQuery(joinQuery)
  //       .addParameter("venue_id", this.getId())
  //       .executeAndFetch(Integer.class);
  //
  //     List<Recipe> recipes = new ArrayList<Recipe>();
  //
  //     for (Integer recipeId : recipeIds) {
  //       String recipeQuery = "SELECT * FROM recipes WHERE id = :recipeId";
  //       Recipe recipe = con.createQuery(recipeQuery)
  //         .addParameter("recipeId", recipeId)
  //         .executeAndFetchFirst(Recipe.class);
  //       recipes.add(recipe);
  //     }
  //     // if (recipes.size() == 0) {
  //     //   return null;
  //     // } else {
  //       return recipes;
  //     // }
  //   }
  // }
  //
  // public void delete() {
  // try(Connection con = DB.sql2o.open()) {
  //   String deleteQuery = "DELETE FROM venues WHERE id = :id;";
  //     con.createQuery(deleteQuery)
  //       .addParameter("id", this.getId())
  //       .executeUpdate();
  //
  //   String joinDeleteQuery = "DELETE FROM recipe_venue WHERE venue_id = :venue_id";
  //     con.createQuery(joinDeleteQuery)
  //       .addParameter("venue_id", this.getId())
  //       .executeUpdate();
  //   }
  // }

}
