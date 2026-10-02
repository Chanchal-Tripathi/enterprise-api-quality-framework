package framework.ai;

public final class FailureTriagePrompt {
    private FailureTriagePrompt() {}

    public static String build(String testName, int expectedStatus, int actualStatus, String responseBody) {
        return """
                You are assisting a senior API quality engineer with failure triage.
                Use only the supplied evidence. Do not invent root causes.
                Return: failure category, observed evidence, likely investigation areas,
                next debugging steps, and a concise defect summary.

                Test: %s
                Expected HTTP status: %d
                Actual HTTP status: %d
                Response body: %s
                """.formatted(testName, expectedStatus, actualStatus, responseBody);
    }
}
