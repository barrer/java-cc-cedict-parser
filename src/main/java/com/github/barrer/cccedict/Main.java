package com.github.barrer.cccedict;

import java.io.*;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        System.out.println("Charset: " + Charset.defaultCharset());
        long start = System.currentTimeMillis();
        if (args.length != 1) {
            System.out.println("Parameter error!");
            return;
        }
        String path = args[0];
        File source = new File(path);
        if (!source.exists()) {
            System.out.println("File cannot be read: " + path);
            return;
        }
        String out = path + ".mdict.txt";
        File mdict = new File(out);
        if (mdict.exists()) {
            System.out.println("File already exists: " + out);
            return;
        }
        CCCEDictParser parser = new CCCEDictParser();
        InputStreamReader reader = null;
        FileWriter writer = null;
        try {
            reader = new InputStreamReader(new FileInputStream(source));
            writer = new FileWriter(mdict, true);
            BufferedReader br = new BufferedReader(reader);
            BufferedWriter bw = new BufferedWriter(writer);
            String line = br.readLine();
            StringBuilder about = new StringBuilder();
            int entryCount = 0;
            int linkCount = 0;
            while (line != null) {
                if (line.startsWith("#")) {
                    about.append(line).append("\r\n");
                } else {
                    CCCEDictParser.Entry entry = parser.getEntry(line);
                    StringBuilder sb = new StringBuilder();
                    sb.append(entry.getTraditionalChineseWord()).append("\r\n");
                    sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"CC-CEDICT.css\">")
                            .append(parser.getHtml(entry)).append("\r\n");
                    sb.append("</>").append("\r\n");
                    entryCount++;
                    // LINK
                    if (!entry.getTraditionalChineseWord().equals(entry.getSimplifiedChineseWord())) {
                        sb.append(entry.getSimplifiedChineseWord()).append("\r\n");
                        sb.append("@@@LINK=" + entry.getTraditionalChineseWord()).append("\r\n");
                        sb.append("</>").append("\r\n");
                        linkCount++;
                    }
                    bw.write(sb.toString());
                }
                line = br.readLine();
            }
            System.out.println("--------------------");
            System.out.println(about);
            System.out.println("--------------------");
            System.out.println("Entry Count: " + entryCount);
            System.out.println("Link Count: " + linkCount);
            System.out.println("Total words: " + (entryCount + linkCount));
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("--------------------");
        System.out.println("CREATE SUCCESS");
        System.out.println("--------------------");
        System.out.println("Total time: " + ((System.currentTimeMillis() - start) / 1000D) + "s");
    }
}
