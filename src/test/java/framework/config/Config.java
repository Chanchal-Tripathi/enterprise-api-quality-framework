package framework.config;

public final class Config {
    private Config() {}

    public static String baseUrl() {
        return System.getProperty("baseUrl",
                System.getenv().getOrDefault("BASE_URL", "https://jsonplaceholder.typicode.com"));
    }
}
