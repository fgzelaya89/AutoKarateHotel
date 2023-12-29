package ejecutable;

import com.intuit.karate.junit5.Karate;

public class Runner {
    @Karate.Test
    Karate testFullPath(){
        return Karate.run("src/test/resources/features/testSoap.feature").tags("@casoPost");
    }

}