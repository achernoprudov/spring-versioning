package ru.naumen.springversioning.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.naumen.springversioning.core.annotation.RestVersion;
import ru.naumen.springversioning.core.model.ApiVersion;

/**
 * @author achernoprudov
 * @since 26/12/2017
 */
@Controller
public class FooController
{
    public static final String FOO = "foo";
    public static final String OLD_FOO = "old one foo";

    @RestVersion(version = ApiVersion.V2)
    @RequestMapping("{version}/foo")
    public ResponseEntity<String> foo(final @PathVariable String version)
    {
        return ResponseEntity.ok(FOO);
    }

    @RestVersion(version = ApiVersion.V1)
    @RequestMapping("{version}/foo")
    public ResponseEntity<String> foo_v1(final @PathVariable String version)
    {
        return ResponseEntity.ok(OLD_FOO);
    }
}
