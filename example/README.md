[![Maven Central](https://img.shields.io/maven-central/v/com.github.pravejos/easy-cli.svg)](https://search.maven.org/artifact/com.github.pravejos/easy-cli)
[![GitHub license](https://img.shields.io/github/license/pravejos/easy-cli.svg)](https://github.com/pravejos/easy-cli/blob/master/LICENSE)

# Usage

1. Build the application
```shell
git clone https://github.com/pravejos/easy-cli.git
./gradlew clean :example:shadowJar
```
2. Run the application using different options passed in
* Missing mandatory parameters
```shell
$ java -jar example/build/libs/easy-cli-example-all.jar
Error parsing arguments. Missing required parameter - patterns
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

* With all valid parameters 
```
$ java -jar example/build/libs/easy-cli-example-all.jar -Ei -e='*.*' --file ./test.txt --fixed-strings=true -m 500 abcd ../temp/ /opt/ .
Arguments parsed successfully.
GrepOption{isExtendedRegExp=true,
	 isFixedStrings=true,
	 regExp=*.*,
	 file=./test.txt,
	 isIgnoreCase=true,
	 maxCount=500,
	 patterns=abcd,
	 file1=../temp/,
	 file2=/opt/,
	 file3=.
}
```
