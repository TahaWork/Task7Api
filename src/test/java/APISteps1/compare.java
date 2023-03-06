package APISteps1;

import io.qameta.allure.Step;
import org.junit.Assert;


import static APISteps1.getLocation.lastCharLocation;
import static APISteps1.getLocation.mortyLocation;
import static APISteps1.getSpecies.lastCharSpecies;
import static APISteps1.getSpecies.mortySpecies;


public  class compare {
    @Step("Сравнение локаций")
    public static void compareLocation()
    {Assert.assertEquals("Локации не совпадают", mortyLocation, lastCharLocation); }
    @Step("Сравнение рас")
    public static void compareSpecies()
    {Assert.assertEquals("Расы не совпадают", mortySpecies, lastCharSpecies);}


}
