import org.sql2o.*;
import java.util.*;

public class Planet {
    private String planet_name;
    private String date_time;
    private double azimuth;
    private double elevation;

  public Planet(String name){
    this.planet_name = name;
  }

  public String getName(){
    return planet_name;
  }

  public String getPlanetTime() {
    return date_time;
  }

  public double getAzimuth() {
    return azimuth;
  }

  public double getElevation() {
    return elevation;
  }

  public String capitalize(){
  String str = this.getName();
  String newString = str.substring(0, 1).toUpperCase() + str.substring(1);
  return newString;
  }

  public static Planet find(String dateTime, String planetName){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM " + planetName + " WHERE date_time = :user_time";
      return con.createQuery(sql).addParameter("user_time", dateTime).executeAndFetchFirst(Planet.class);
    }
  }
}
