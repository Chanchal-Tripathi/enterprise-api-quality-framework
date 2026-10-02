package tests;

import framework.ai.FailureTriagePrompt;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FailureTriagePromptTest {
    @Test(groups = "ai")
    public void triagePromptRequiresEvidenceBasedAnalysis() {
        String prompt = FailureTriagePrompt.build(
                "create order", 201, 500, "{\"error\":\"internal error\"}");

        assertTrue(prompt.contains("Do not invent root causes"));
        assertTrue(prompt.contains("Expected HTTP status: 201"));
        assertTrue(prompt.contains("Actual HTTP status: 500"));
        assertTrue(prompt.contains("next debugging steps"));
    }
}
