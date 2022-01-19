package base64;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Sample {

	public static void main(String args[]) {
		Base64Sample obj = new Base64Sample();

	//	obj.simpleEncoder();

	// obj.urlEncoder();

	obj.mimeTypeEncoder();

	}

	private void simpleEncoder() {
		//String original = "B";
		String original = "It's a secret that C++ developer are better than Java";

		byte[] bytes = original.getBytes(StandardCharsets.UTF_8);
		System.out.println("+ line" + bytes.length);
		for (int i = 0; i < bytes.length; i++) {
			System.out.print("" + bytes[i]);
		}
		System.out.println();
		String base64Encoded = Base64.getEncoder().encodeToString(bytes);
		System.out.println("original text: " + original);
		System.out.println("Base64 encoded text: " + base64Encoded);

		// Decode
		byte[] asBytes = Base64.getDecoder().decode(base64Encoded);
		String base64Decoded = new String(asBytes, StandardCharsets.UTF_8);
		System.out.println("Base64 decoded text: " + base64Decoded);
	}

	private void urlEncoder() {
		// Base64 encoding using URL encoder
		String basicEncoded = Base64.getEncoder().encodeToString("JavaOrScala?".getBytes(StandardCharsets.UTF_8));
		System.out.println("Using Basic encoding: " + basicEncoded);

		String urlEncoded = Base64.getUrlEncoder().encodeToString("JavaOrScala?".getBytes(StandardCharsets.UTF_8));
		System.out.println("Using URL encoding: " + urlEncoded);

		// Decode
		byte[] asBytes = Base64.getUrlDecoder().decode(urlEncoded);
		String base64Decoded = new String(asBytes, StandardCharsets.UTF_8);
		System.out.println("Base64 url decoded text: " + base64Decoded);
	}

	private void mimeTypeEncoder() {
		// Base64 encoding using MIME encoder
		String text = "Best Credit Card for Student is something which " + "give maximum rebate to Student"
				+ "when they purchase books, courses and other stationary items";
		String mimeEndoded = Base64.getMimeEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
		System.out.println("original string: " + text);
		System.out.println("base65 encoded using MIME encoder: ");
		System.out.println(mimeEndoded);

		// Base64 decoding
		byte[] decodedBytes = Base64.getMimeDecoder().decode(mimeEndoded);
		String mimeDecoded = new String(decodedBytes, StandardCharsets.UTF_8);
		System.out.println("MIME decoded String: " + mimeDecoded);

	}

	public void wrapping() throws IOException {

		String src = "This is the content of any resource read from somewhere"
				+ " into a stream. This can be text, image, video or any other stream.";

		// An encoder wraps an OutputStream. The content of /tmp/buff-base64.txt will be
		// the
		// Base64 encoded form of src.
		try (OutputStream os = Base64.getEncoder().wrap(new FileOutputStream("/home/ggk/Desktop/base64"))) {
			os.write(src.getBytes("utf-8"));
			os.flush();
		}

		// The section bellow illustrates a wrapping of an InputStream and decoding it
		// as the stream
		// is being consumed. There is no need to buffer the content of the file just
		// for decoding it.
		try (InputStream is = Base64.getDecoder().wrap(new FileInputStream("/home/ggk/Desktop/base64"))) {
			int len;
			byte[] bytes = new byte[100];
			while ((len = is.read(bytes)) != -1) {
				System.out.print(new String(bytes, 0, len, "utf-8"));
			}
		}
	}
}
