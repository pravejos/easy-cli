package com.github.pravejos.easycli;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentParserTest {
  @Test
  void testParse() {
    // ARRANGE
    String[] args = new String[] {"-l", "101", "-s", "changed", "--myString2", "changed2", "11"};

    // ACT
    TestOption testOption = ArgumentParser.parse(TestOption.class, args);

    // ASSERT
    assertNotNull(testOption);
    assertEquals(101, testOption.getLongWithDefault());
    assertEquals("changed", testOption.getStringWithDefault());
    assertEquals("changed2", testOption.getString2());
    assertEquals(11, testOption.getIntParamWithDefault());
  }

  @Test
  void testParse_ShortPrefixEquals() {
    // ARRANGE
    String[] args = new String[] {"-s=string1", "12"};

    // ACT
    TestOption testOption = ArgumentParser.parse(TestOption.class, args);

    // ASSERT
    assertNotNull(testOption);
    assertEquals("string1", testOption.getStringWithDefault());
    assertEquals(12, testOption.getIntParamWithDefault());
  }

  @Test
  void testParse_LongPrefixEquals() {
    // ARRANGE
    String[] args = new String[] {"--myString2=changed3", "11"};

    // ACT
    TestOption testOption = ArgumentParser.parse(TestOption.class, args);

    // ASSERT
    assertNotNull(testOption);
    assertEquals("changed3", testOption.getString2());
    assertEquals(11, testOption.getIntParamWithDefault());
  }

  @Test
  void testParse_EmptyArgs() {
    // ARRANGE
    String[] args = new String[0];

    // ACT
    assertThrows(ArgumentParserException.class, () -> ArgumentParser.parse(TestOption.class, args));
  }

  @Test
  void testPrintHelp() {
    // ARRANGE
    String expected =
        "Usage: java [JavaOptions] <mainclass> [OPTIONS] [PARAMETERS]\n"
            + "   or  java [JavaOptions] -jar <jarfile> [OPTIONS] [PARAMETERS]\n"
            + "\n"
            + "Options:\n"
            + "  -l, --myLong  This is a test Long option (default \"100\")\n"
            + "  -s, --myString This is a test String option (default \"dummy\")\n"
            + "      --myString2 This is a test String option 2 (default \"dummy2\")\n"
            + "\n"
            + "Parameters:\n"
            + "  Param1 (Mandatory) This is a test Int parameter (default \"10\")\n";

    // ACT
    String help = HelpTextGenerator.generateHelpText(TestOption.class);

    // ASSERT
    assertEquals(expected, help);
  }
}
