[![Examples](https://img.shields.io/badge/demo-here-blue.svg)](https://github.com/pravejos/easy-cli/blob/master/example/)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.pravejos/easy-cli.svg)](https://search.maven.org/artifact/com.github.pravejos/easy-cli)
[![GitHub license](https://img.shields.io/github/license/pravejos/easy-cli.svg)](https://github.com/pravejos/easy-cli/blob/master/LICENSE)

# Overview

**easy-cli** is a java library for easy command line argument parsing. It can also print help message which shows the
options available for the command line tool.

It is annotation based, which makes it easier to define and use the parsed arguments.

#### Features:

* Open source
* **Easy to use**
* Supports different types of options
    * Short and long options (e.g. `ls -r` and `ls --reverse`)
        * POSIX like options (e.g. `ls -ltr Test.java`)
        * GNU like long options (e.g. `ls --reverse --format=commas`)
    * With space separator between the option and value (e.g. `--option value` or `-o value`)
* Generates help message
    
A sample help message displayed by the library is shown below
```
Usage: java [JavaOptions] <mainclass> [OPTIONS] [PARAMETERS]
   or  java [JavaOptions] -jar <jarfile> [OPTIONS] [PARAMETERS]

Options:
  -E, --extended-regexp PATTERNS are extended regular expressions (default "false")
  -F, --fixed-strings PATTERNS are strings (default "false")
  -e, --regexp        use PATTERNS for matching
  -f, --file          take PATTERNS from FILE
  -i, --ignore-case   ignore case distinctions in patterns and data (default "false")
  -m, --max-count     stop after NUM selected lines

Parameters:
  Param1 (Mandatory) contain multiple patterns separated by newlines
  Param2 File (1) to check the pattern (default ".")
  Param3 File (2) to check the pattern
  Param4 File (3) to check the pattern
```