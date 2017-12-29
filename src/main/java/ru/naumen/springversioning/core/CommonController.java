package ru.naumen.springversioning.core;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.naumen.springversioning.ApiVersion;
import ru.naumen.springversioning.RestVersion;

/**
 * @author achernoprudov
 * @since 26/12/2017
 */
@Controller
public class CommonController
{
    @RestVersion(version = ApiVersion.V1)
    @RequestMapping("{version}/foo")
    public ResponseEntity<String> foo(final @PathVariable String version)
    {
        return ResponseEntity.ok("foo");
    }

    @RestVersion(version = ApiVersion.V2)
    @RequestMapping("{version}/bar")
    public ResponseEntity<String> bar(final @PathVariable String version)
    {
        return ResponseEntity.ok("bar");
    }
}
