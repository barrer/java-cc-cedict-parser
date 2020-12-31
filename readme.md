# A Java parser for the CC-CEDICT Chinese-English dictionary

## API

```java
public static class Entry {
        private String traditionalChineseWord;
        private String simplifiedChineseWord;
        private String mandarinPinyin;
        private List<String> englishDefinitions;
        ...
}
```

`Entry getEntry(String line)` Get the entry object from a line of CC-CEDICT format file.

`String getHtml(Entry entry)` CC-CEDICT entry object to HTML.

`String[] convertPinyin(String pinyin)` Converts the CC-CEDICT pinyin to accented pinyin.

### How to use

```java
com.github.barrer.cccedict.CCCEDictParserTest
```

## Java Version

JDK 1.5 and above

## Build

`mvn clean compile package -Dmaven.test.skip=true`

### Download the built file

[https://github.com/barrer/java-cc-cedict-parser/releases](https://github.com/barrer/java-cc-cedict-parser/releases)

date|`sha256sum cccedict.jar`
---|---
2019-12-20|`51d1b6c2c1bde40160760c143c027663177572619ba074d1f043c3949dd2a01c`

## MDict

### Create MDict source files (support both traditional Chinese and simplified Chinese headword search)

`java -Dfile.encoding=UTF-8 -jar cccedict.jar ~/Downloads/cedict_ts.u8`

#### Windows Users

First install java: [AdoptOpenJDK](https://adoptopenjdk.net/)

Then place the following three files in the same directory.

* build-mdict.bat
* cccedict.jar
* cedict_ts.u8

Finally, double-click build-mdict.bat.

### GoldenDict screenshot

![screenshot](mdict/screenshot.png)
