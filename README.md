# Enterprise API Quality Framework

> **Java + REST Assured + TestNG portfolio project** demonstrating enterprise-style API automation, contract validation, reusable architecture, CI/CD and AI-assisted failure triage.

[![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)](https://www.java.com/)
[![REST Assured](https://img.shields.io/badge/REST%20Assured-API%20Testing-green)](https://rest-assured.io/)
[![CI](https://github.com/Chanchal-Tripathi/enterprise-api-quality-framework/actions/workflows/api-quality.yml/badge.svg)](https://github.com/Chanchal-Tripathi/enterprise-api-quality-framework/actions/workflows/api-quality.yml)

## Why this project

API automation at senior level is not just sending GET and POST requests. A maintainable quality platform needs separation of concerns, reusable specifications, typed payloads, contract checks, meaningful negative coverage, external configuration, diagnosable failures and CI feedback.

This repository demonstrates those engineering decisions using a public demo API so no proprietary application, credentials or client data are exposed.

## Engineering capabilities demonstrated

| Capability | Implementation |
| --- | --- |
| API automation | REST Assured |
| Language | Java 17 |
| Test runner | TestNG |
| Build | Maven |
| Framework architecture | Client + specification + model + test layers |
| Contract testing | JSON Schema validation |
| Test design | Positive, negative, CRUD and data-driven scenarios |
| Maintainability | Reusable request/response specifications |
| Environment strategy | System property / environment-variable configuration |
| Diagnostics | Request/response/error logging |
| Execution | Parallel TestNG suite |
| CI/CD | GitHub Actions |
| Evidence | Surefire/TestNG reports retained as artifacts |
| AI-assisted QE | Evidence-based failure-triage prompt with deterministic guardrail test |

## Architecture

```text
src/test/java/
├── framework/
│   ├── ai/       # AI-assisted failure triage
│   ├── client/   # Endpoint interaction
│   ├── config/   # Environment configuration
│   ├── data/     # Data providers
│   ├── model/    # Typed payloads
│   └── spec/     # Reusable REST Assured specifications
└── tests/
    ├── PostContractTest
    ├── PostCrudTest
    ├── PostDataDrivenTest
    ├── PostNegativeTest
    └── FailureTriagePromptTest
```

For the reasoning behind these layers, see [Architecture & design decisions](docs/ARCHITECTURE.md).

## Quality scenarios

### Contract validation
A successful response is validated against a JSON Schema as well as targeted business assertions. This catches structural drift while keeping important field expectations explicit.

### Positive and CRUD coverage
The suite validates retrieval, creation and deletion behavior with readable assertions.

### Negative coverage
Unknown resources are deliberately exercised to verify the API's error behavior rather than testing only happy paths.

### Data-driven coverage
TestNG data providers exercise representative resource IDs without duplicating test logic.

### AI-assisted failure triage
The framework contains an optional AI-quality pattern for turning test evidence into a structured failure-analysis prompt.

The design explicitly instructs an AI system **not to invent root causes**. AI may assist investigation; deterministic API assertions remain the source of truth for pass/fail.

## Run locally

Prerequisites: **JDK 17+** and **Maven 3.9+**.

```bash
mvn clean test
```

Override the target environment without modifying code:

```bash
mvn clean test -DbaseUrl=https://jsonplaceholder.typicode.com
```

## Risk-based execution

The suite uses TestNG groups such as `smoke`, `contract`, `negative` and `ai`. This provides a foundation for different pipeline stages—for example, fast smoke checks on pull requests and broader regression execution on scheduled runs.

## CI/CD

GitHub Actions runs the API quality suite for pushes and pull requests to `main`.

The pipeline:

1. provisions Java 17,
2. restores Maven dependency cache,
3. runs `mvn clean test`,
4. uploads Surefire/TestNG test evidence even when tests fail.

## Design choices that matter

- **No global retry policy.** API failures stay visible unless a known transient dependency has an explicit retry strategy.
- **No secrets in source.** Environment-specific values belong in CI/environment configuration.
- **No giant base-test class.** Composition through clients and specifications keeps responsibilities clearer.
- **Schema + business assertions.** Schema validation alone does not prove business correctness.
- **AI is assistive, not authoritative.** LLM output never determines whether an automated test passed.

## Roadmap

- OAuth2/Bearer authentication strategy
- Consumer-driven contract example with Pact
- WireMock service virtualization
- richer response DTO deserialization
- Allure reporting
- correlation-ID-aware logging
- API-to-database validation example
- GraphQL quality module
- performance threshold checks
- LLM evaluation fixture for API failure classification

## About the author

Built by **Chanchal Tripathi** as a hands-on Quality Engineering portfolio project focused on **Java, REST Assured, API automation architecture, contract validation, CI/CD and AI-assisted testing**.

The goal is to demonstrate **framework design and quality-engineering judgment**, not simply the number of automated tests.
