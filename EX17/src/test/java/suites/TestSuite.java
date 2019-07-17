package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.ArticleTest;
import tests.AssertElemPresentTest;
import tests.GetStartedTest;
import tests.SearchTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ArticleTest.class,
        AssertElemPresentTest.class,
        GetStartedTest.class,
        SearchTest.class
})
public class TestSuite { }
