package com.bernard;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class WebScraper {

    public static void main(String[] args) throws IOException {

        BufferedReader br = null;
        FileWriter fw = new FileWriter("wb.txt");

        try {

            URL url = new URL("http://zetcode.com/articles/javareadwebpage/");
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            //writes output to screen
            System.out.println(sb);

            //writes output to file
            fw.write(String.valueOf(sb));

        } finally {

            if (br != null) {
                br.close();
            }
        }
    }

}

