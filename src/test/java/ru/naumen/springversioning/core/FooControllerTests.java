package ru.naumen.springversioning.core;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import ru.naumen.springversioning.core.controller.FooController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FooControllerTests
{
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test_v1()
    {
        String result = restTemplate.getForObject("/v1/foo", String.class);
        Assert.assertEquals(FooController.OLD_FOO, result);
    }

    @Test
    public void test_v2()
    {
        String result = restTemplate.getForObject("/v2/foo", String.class);
        Assert.assertEquals(FooController.FOO, result);
    }

}
