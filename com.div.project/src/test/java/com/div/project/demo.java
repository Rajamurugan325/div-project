package com.div.project;

import org.testng.Assert;
import org.testng.annotations.Test;

public class demo {

    @Test
    public void testDemo() {
        String expected = "Hello";
        String actual = "Hello";
        Assert.assertEquals(actual, expected);
    }
}