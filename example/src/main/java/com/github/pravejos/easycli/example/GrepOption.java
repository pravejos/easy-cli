package com.github.pravejos.easycli.example;

import com.github.pravejos.easycli.Option;
import com.github.pravejos.easycli.Parameter;

@SuppressWarnings("unused")
public class GrepOption {
  @Option(
          shortName = 'E',
          longName = "extended-regexp",
          defaultValue = "false",
          desc = "PATTERNS are extended regular expressions")
  private boolean isExtendedRegExp;

  @Option(
          shortName = 'F',
          longName = "fixed-strings",
          defaultValue = "false",
          desc = "PATTERNS are strings")
  private boolean isFixedStrings;

  @Option(shortName = 'e', longName = "regexp", desc = "use PATTERNS for matching")
  private String regExp;

  @Option(shortName = 'f', longName = "file", desc = "take PATTERNS from FILE")
  private String file;

  @Option(
          shortName = 'i',
          longName = "ignore-case",
          defaultValue = "false",
          desc = "ignore case distinctions in patterns and data")
  private boolean isIgnoreCase;

  @Option(shortName = 'm', longName = "max-count", desc = "stop after NUM selected lines")
  private long maxCount;

  @Parameter(
          position = 1,
          required = true,
          desc = "contain multiple patterns separated by newlines")
  private String patterns;

  @Parameter(
          position = 2,
          defaultValue = ".",
          desc = "File (1) to check the pattern")
  private String file1;

  @Parameter(position = 3, desc = "File (2) to check the pattern")
  private String file2;

  @Parameter(position = 4, desc = "File (3) to check the pattern")
  private String file3;

  public boolean isExtendedRegExp() {
    return isExtendedRegExp;
  }

  public Boolean getFixedStrings() {
    return isFixedStrings;
  }

  public String getRegExp() {
    return regExp;
  }

  public String getFile() {
    return file;
  }

  public boolean isIgnoreCase() {
    return isIgnoreCase;
  }

  public long getMaxCount() {
    return maxCount;
  }

  public String getPatterns() {
    return patterns;
  }

  public String getFile1() {
    return file1;
  }

  public String getFile2() {
    return file2;
  }

  public String getFile3() {
    return file3;
  }

  @Override
  public String toString() {
    return "GrepOption{" +
            "isExtendedRegExp=" + isExtendedRegExp +
            ",\n\t isFixedStrings=" + isFixedStrings +
            ",\n\t regExp=" + regExp +
            ",\n\t file=" + file +
            ",\n\t isIgnoreCase=" + isIgnoreCase +
            ",\n\t maxCount=" + maxCount +
            ",\n\t patterns=" + patterns +
            ",\n\t file1=" + file1 +
            ",\n\t file2=" + file2 +
            ",\n\t file3=" + file3 +
            "\n}";

  }
}
