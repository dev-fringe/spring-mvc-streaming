package dev.fringe.springmvcstreaming;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Controller
public class TestController {

	@RequestMapping("/")
	public StreamingResponseBody request() {
		return new StreamingResponseBody() {
			public void writeTo(OutputStream out) throws IOException {
				for (int i = 0; i < 1000; i++) {
					out.write((Integer.toString(i) + " - ").getBytes());
					out.flush();
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		};
	}
}
