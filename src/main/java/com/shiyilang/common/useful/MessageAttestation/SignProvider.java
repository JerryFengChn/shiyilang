package com.shiyilang.common.useful.MessageAttestation;

import java.nio.charset.Charset;


public interface SignProvider {
	 public abstract String sign(byte[] paramArrayOfByte, Charset paramCharset)
			    throws Exception;
}
