package com.xupt.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.removeAllMappings;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

public class MockService {
	public static void main(String[] args) throws IOException {
		configureFor(8888);
		removeAllMappings();
//
		mock("/order/1", "01");
		mock("/order/2", "02");

	}

	private static void mock(String url, String file) throws IOException {
		// TODO Auto-generated method stub
		ClassPathResource rescouse = new ClassPathResource("mock/response/" + file + ".txt");
//		@SuppressWarnings("deprecation")
		StringUtils.join(FileUtils.readLines(rescouse.getFile(), "UTF-8").toArray(), "\n");

		stubFor(get(urlPathEqualTo(url)).willReturn(aResponse().withBody("{\"id\":1}}").withStatus(200)));

	}
}
