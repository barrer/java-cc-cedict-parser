package com.github.barrer.cccedict;

import org.junit.Test;

public class CCCEDictParserTest {
    @Test
    public void getEntry() {
        CCCEDictParser parser = new CCCEDictParser();
        String lineA = "天台山 天台山 [Tian1 tai1 Shan1] /Mt Tiantai near Shaoxing 紹興|绍兴[Shao4 xing1] in Zhejiang, the center of Tiantai Buddhism 天台宗[Tian1 tai2 zong1]/";
        String lineB = "珍·奧斯汀 珍·奥斯汀 [Zhen1 · Ao4 si1 ting1] /Jane Austen (1775-1817), English novelist/also written 簡·奧斯汀|简·奥斯汀[Jian3 · Ao4 si1 ting1]/";
        CCCEDictParser.Entry entryA = parser.getEntry(lineA);
        CCCEDictParser.Entry entryB = parser.getEntry(lineB);
        System.out.println(entryA.getSimplifiedChineseWord());
        System.out.println(entryB.getSimplifiedChineseWord());
    }

    @Test
    public void convertPinyin() {
        CCCEDictParser parser = new CCCEDictParser();
        String pinyin = "tian1 r5 dong1 xian1 an4 nu:3 er2 liu2 hui1 ma ma5 ma3 r5 lu:2 yun2 Zhen1 · Ao4 si1 ting1";
        for (String py : parser.convertPinyin(pinyin)) {
            System.out.println(py);
        }
        System.out.println(parser.arrayToString(parser.convertPinyin(pinyin)));
    }

    @Test
    public void getHtml() {
        CCCEDictParser parser = new CCCEDictParser();
        String lineA = "天台山 天台山 [Tian1 tai1 Shan1] /Mt Tiantai near Shaoxing 紹興|绍兴[Shao4 xing1] in Zhejiang, the center of Tiantai Buddhism 天台宗[Tian1 tai2 zong1]/";
        String lineB = "珍·奧斯汀 珍·奥斯汀 [Zhen1 · Ao4 si1 ting1] /Jane Austen (1775-1817), English novelist/also written 簡·奧斯汀|简·奥斯汀[Jian3 · Ao4 si1 ting1]/";
        CCCEDictParser.Entry entryA = parser.getEntry(lineA);
        CCCEDictParser.Entry entryB = parser.getEntry(lineB);
        System.out.println(parser.getHtml(entryA));
        System.out.println(parser.getHtml(entryB));
    }
}
