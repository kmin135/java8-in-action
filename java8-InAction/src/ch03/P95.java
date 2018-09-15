package ch03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P95 {
	
	public static void main(String[] args) throws IOException {
		System.out.println(readFile(read -> read.readLine()));
		System.out.println(readFile(read -> read.readLine() + read.readLine() + read.readLine()));
	}

	public static String readFile(BufferedReaderProcessor p) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("src/ch03/Test01.java"))) {
			return p.process(br);
		}
	}
}
