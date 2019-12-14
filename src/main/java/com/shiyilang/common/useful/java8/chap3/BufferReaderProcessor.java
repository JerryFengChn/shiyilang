package com.shiyilang.common.useful.java8.chap3;

import java.io.BufferedReader;

@FunctionalInterface
public interface BufferReaderProcessor {
	public String process(BufferedReader br) throws Exception;
}
