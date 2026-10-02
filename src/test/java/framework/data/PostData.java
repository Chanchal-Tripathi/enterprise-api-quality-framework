package framework.data;

import org.testng.annotations.DataProvider;

public final class PostData {
    private PostData() {}

    @DataProvider(name = "validPostIds")
    public static Object[][] validPostIds() {
        return new Object[][] {{1}, {10}, {50}, {100}};
    }
}
