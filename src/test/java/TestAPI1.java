
import APIHooks.APIHook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static APISteps1.getCharacter.getCharacter;
import static APISteps1.getLocation.getLastCharacterLocation;
import static APISteps1.getLocation.getMortyLocation;
import static APISteps1.getSpecies.getLastCharacterSpecies;
import static APISteps1.getSpecies.getMortySpecies;
import static APISteps1.lastCharacter.getLastCharacter;
import static APISteps1.lastCharacter.lastChar;
import static APISteps1.lastEpisode.getEpisode;
import static APISteps1.compare.*;


public class TestAPI1  extends APIHook {
    String name="Morty Smith";
    @Test
    @DisplayName("Собираем данные")
    public void getAll()
    {
        getCharacter(name);
        getEpisode();
        getLastCharacter();
        getMortySpecies();
        getLastCharacterSpecies(lastChar);
        getMortyLocation();
        getLastCharacterLocation(lastChar);
    }
    @Test
    @DisplayName("Сравниваем расы")
    public void compareSpecie()
    {
        getAll();
        compareSpecies();
    }
    @Test
    @DisplayName("Сравниваем локации")
    public void compareLoc()
    {
        getAll();
        compareLocation();
    }


}
