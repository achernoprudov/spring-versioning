# Spring versioning
Spring REST API versioning through annotations in enum.

This is example that solve problem of versioning Spring REST API in the elegant way.

## Description

Suppose we have API v1 and v2 that could be represented as enum:
```
public enum ApiVersion {
    V1("v1"), V2("v2");
    private final String code;
    ...
}
```

And we want to use this enum in mapping like this:
```
@Controller
public class FooController
{
    @RestVersion(version = ApiVersion.V2)
    @RequestMapping("{version}/foo")
    public ResponseEntity<String> foo(final @PathVariable String version) { ... }
    
    @RestVersion(version = ApiVersion.V1)
    @RequestMapping("{version}/foo")
    public ResponseEntity<String> foo_v1(final @PathVariable String version) { ... }
}
```

We could reach this by `RequestCondition` mechanism.
