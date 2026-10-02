# Architecture

## Layers

```text
tests -> clients -> request/response specifications -> environment config
          |
          +-> typed request/response models
          +-> JSON Schema contracts
          +-> reusable test data
```

### Why this structure?

- **Tests express intent** rather than HTTP plumbing.
- **Clients own endpoint interaction**, keeping tests readable.
- **Specifications centralize cross-cutting concerns** such as base URI, content type, logging and response-time expectations.
- **Models make payloads type-safe** and easier to refactor.
- **Schemas detect contract drift** beyond individual field assertions.
- **Environment configuration is externalized**, allowing CI or local overrides without code changes.
- **TestNG groups and data providers** support risk-based and data-driven execution.

## Reliability principles

Retries are deliberately not enabled globally. A failed API assertion should remain visible unless a specific transient dependency has an understood retry policy. Logging is captured at the HTTP layer to make failures diagnosable.

## Portfolio safety

The framework targets a public demo API and contains no employer/client endpoints, credentials, production data or proprietary business logic.
