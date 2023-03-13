package APISteps1;

import io.cucumber.java.en.When;
import org.junit.Assert;
import static APISteps1.getLocation.lastCharLocation;
import static APISteps1.getLocation.mortyLocation;
import static APISteps1.getSpecies.lastCharSpecies;
import static APISteps1.getSpecies.mortySpecies;


public  class compare {

    @When("Сравниваем локации")
    public static void compareLocation()
    {Assert.assertEquals("Локации не совпадают", mortyLocation, lastCharLocation); }

    @When("Сравниваем расы")
    public static void compareSpecies()
    {Assert.assertEquals("Расы не совпадают", mortySpecies, lastCharSpecies);}


}
