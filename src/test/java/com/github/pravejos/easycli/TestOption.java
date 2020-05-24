package com.github.pravejos.easycli;

@SuppressWarnings("unused")
public class TestOption {
  @Option(
      shortName = 'l',
      longName = "myLong",
      defaultValue = "100",
      desc = "This is a test Long option")
  private long longWithDefault;

  @Option(
      shortName = 's',
      longName = "myString",
      defaultValue = "dummy",
      desc = "This is a test String option")
  private String stringWithDefault;

  @Option(longName = "myString2", defaultValue = "dummy2", desc = "This is a test String option 2")
  private String string2;

  @Parameter(
      position = 1,
      defaultValue = "10",
      required = true,
      desc = "This is a test Int parameter")
  private int intParamWithDefault;

  public long getLongWithDefault() {
    return longWithDefault;
  }

  public String getStringWithDefault() {
    return stringWithDefault;
  }

  public int getIntParamWithDefault() {
    return intParamWithDefault;
  }

  public String getString2() {
    return string2;
  }
}
