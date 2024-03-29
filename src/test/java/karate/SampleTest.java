package karate;

import com.intuit.karate.junit5.Karate;
import org.junit.Before;
import org.junit.BeforeClass;
import util.ExcelWriter;

class SampleTest {

    @Karate.Test
    Karate testSample() {
        return Karate.run("sample").relativeTo(getClass());
    }

    @Karate.Test
    Karate testTags() {
        return Karate.run("tags").tags("@second").relativeTo(getClass());
    }

    @Karate.Test
    Karate testTagsWithoutFeatureName() {
        return Karate.run().tags("@second").relativeTo(getClass());
    }

    @Karate.Test
    Karate testFullPath() {

        return Karate.run("classpath:karate/testSoap.feature").tags("@TestJSON");
    }

    @Karate.Test
    Karate testSystemProperty() {
        return Karate.run("classpath:karate/tags.feature")
                .tags("@second")
                .karateEnv("e2e")
                .systemProperty("foo", "bar");
    }

    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }


}
