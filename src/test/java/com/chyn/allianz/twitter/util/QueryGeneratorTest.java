package com.chyn.allianz.twitter.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.chyn.allianz.rawjson.twitter.RawRetweetJson;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SpringBootTest
class QueryGeneratorTest {

	
	private static Gson gson;
	
	private static RawRetweetJson rawRetweetJson;
	
	@Autowired
	private QueryGenerator queryGenerator;
	
	@BeforeAll
	static void init() {
		gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		String rawString = "{\"created_at\":\"Sun Mar 31 17:04:24 +0000 2019\",\"id\":1112400262684135424,\"id_str\":\"1112400262684135424\",\"text\":\"Tomorrow!\\nMa\\u00f1ana te espera @TWUBeso . No te lo puedes perder. #LaTiendita #haciendoruido\",\"source\":\"\\u003ca href=\\\"http:\\/\\/twitter.com\\/download\\/iphone\\\" rel=\\\"nofollow\\\"\\u003eTwitter for iPhone\\u003c\\/a\\u003e\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":771415824158625792,\"id_str\":\"771415824158625792\",\"name\":\"Jorge F. Figueroa (Dr. J)\",\"screen_name\":\"jfigueroaflores\",\"location\":\"Denton, TX\",\"url\":\"https:\\/\\/www.twu.edu\\/teacher-education\\/\",\"description\":\"\\u201cLa unidad de nuestros pueblos no es simple quimera de los hombres, sino inexorable decreto del destino\\\" -Sim\\u00f3n Bol\\u00edvar\",\"translator_type\":\"none\",\"protected\":false,\"verified\":false,\"followers_count\":369,\"friends_count\":1157,\"listed_count\":4,\"favourites_count\":2010,\"statuses_count\":2239,\"created_at\":\"Thu Sep 01 18:33:59 +0000 2016\",\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":true,\"lang\":\"es\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"000000\",\"profile_background_image_url\":\"http:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_image_url_https\":\"https:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_tile\":false,\"profile_link_color\":\"19CF86\",\"profile_sidebar_border_color\":\"000000\",\"profile_sidebar_fill_color\":\"000000\",\"profile_text_color\":\"000000\",\"profile_use_background_image\":false,\"profile_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_images\\/786667135128961024\\/s_auKfIX_normal.jpg\",\"profile_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_images\\/786667135128961024\\/s_auKfIX_normal.jpg\",\"profile_banner_url\":\"https:\\/\\/pbs.twimg.com\\/profile_banners\\/771415824158625792\\/1552001234\",\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":{\"id\":\"f77b0bf942a40070\",\"url\":\"https:\\/\\/api.twitter.com\\/1.1\\/geo\\/id\\/f77b0bf942a40070.json\",\"place_type\":\"city\",\"name\":\"Denton\",\"full_name\":\"Denton, TX\",\"country_code\":\"US\",\"country\":\"Estados Unidos\",\"bounding_box\":{\"type\":\"Polygon\",\"coordinates\":[[[-97.187543,33.128938],[-97.187543,33.276053],[-97.041998,33.276053],[-97.041998,33.128938]]]},\"attributes\":{}},\"contributors\":null,\"quoted_status_id\":1111613346170703878,\"quoted_status_id_str\":\"1111613346170703878\",\"quoted_status\":{\"created_at\":\"Fri Mar 29 12:57:29 +0000 2019\",\"id\":1111613346170703878,\"id_str\":\"1111613346170703878\",\"text\":\"In exactly 3 days we will bring \\u201cLa Tiendita\\u201d to @twustudentu \\ud83e\\udd29 during #MarketingMonday from 11:30-1pm Come enjoy s\\u2026 https:\\/\\/t.co\\/U6hisTP55C\",\"display_text_range\":[0,140],\"source\":\"\\u003ca href=\\\"http:\\/\\/twitter.com\\/download\\/iphone\\\" rel=\\\"nofollow\\\"\\u003eTwitter for iPhone\\u003c\\/a\\u003e\",\"truncated\":true,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":3511723153,\"id_str\":\"3511723153\",\"name\":\"TWU BESO\",\"screen_name\":\"TWUBeso\",\"location\":null,\"url\":null,\"description\":null,\"translator_type\":\"none\",\"protected\":false,\"verified\":false,\"followers_count\":101,\"friends_count\":44,\"listed_count\":3,\"favourites_count\":102,\"statuses_count\":183,\"created_at\":\"Thu Sep 10 04:32:27 +0000 2015\",\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":true,\"lang\":\"en\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"C0DEED\",\"profile_background_image_url\":\"http:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_image_url_https\":\"https:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_tile\":false,\"profile_link_color\":\"1DA1F2\",\"profile_sidebar_border_color\":\"C0DEED\",\"profile_sidebar_fill_color\":\"DDEEF6\",\"profile_text_color\":\"333333\",\"profile_use_background_image\":true,\"profile_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_images\\/1045030658760880129\\/0e9JznvQ_normal.jpg\",\"profile_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_images\\/1045030658760880129\\/0e9JznvQ_normal.jpg\",\"profile_banner_url\":\"https:\\/\\/pbs.twimg.com\\/profile_banners\\/3511723153\\/1537989859\",\"default_profile\":true,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":{\"id\":\"bd331d141f66eead\",\"url\":\"https:\\/\\/api.twitter.com\\/1.1\\/geo\\/id\\/bd331d141f66eead.json\",\"place_type\":\"city\",\"name\":\"Little Elm\",\"full_name\":\"Little Elm, TX\",\"country_code\":\"US\",\"country\":\"Estados Unidos\",\"bounding_box\":{\"type\":\"Polygon\",\"coordinates\":[[[-96.983818,33.140885],[-96.983818,33.199847],[-96.881861,33.199847],[-96.881861,33.140885]]]},\"attributes\":{}},\"contributors\":null,\"is_quote_status\":false,\"extended_tweet\":{\"full_text\":\"In exactly 3 days we will bring \\u201cLa Tiendita\\u201d to @twustudentu \\ud83e\\udd29 during #MarketingMonday from 11:30-1pm Come enjoy snacks from our culture, &amp; enter for a chance to win free BESO gear!\\n#haciendoruido https:\\/\\/t.co\\/PBZdF2eqIR\",\"display_text_range\":[0,201],\"entities\":{\"hashtags\":[{\"text\":\"MarketingMonday\",\"indices\":[71,87]},{\"text\":\"haciendoruido\",\"indices\":[187,201]}],\"urls\":[],\"user_mentions\":[{\"screen_name\":\"TWUStudentU\",\"name\":\"TWU Student Union\",\"id\":1225222711,\"id_str\":\"1225222711\",\"indices\":[49,61]}],\"symbols\":[],\"media\":[{\"id\":1111613343234707456,\"id_str\":\"1111613343234707456\",\"indices\":[202,225],\"media_url\":\"http:\\/\\/pbs.twimg.com\\/media\\/D20-cjMW0AAFG7Q.jpg\",\"media_url_https\":\"https:\\/\\/pbs.twimg.com\\/media\\/D20-cjMW0AAFG7Q.jpg\",\"url\":\"https:\\/\\/t.co\\/PBZdF2eqIR\",\"display_url\":\"pic.twitter.com\\/PBZdF2eqIR\",\"expanded_url\":\"https:\\/\\/twitter.com\\/TWUBeso\\/status\\/1111613346170703878\\/photo\\/1\",\"type\":\"photo\",\"sizes\":{\"large\":{\"w\":750,\"h\":535,\"resize\":\"fit\"},\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"small\":{\"w\":680,\"h\":485,\"resize\":\"fit\"},\"medium\":{\"w\":750,\"h\":535,\"resize\":\"fit\"}}}]},\"extended_entities\":{\"media\":[{\"id\":1111613343234707456,\"id_str\":\"1111613343234707456\",\"indices\":[202,225],\"media_url\":\"http:\\/\\/pbs.twimg.com\\/media\\/D20-cjMW0AAFG7Q.jpg\",\"media_url_https\":\"https:\\/\\/pbs.twimg.com\\/media\\/D20-cjMW0AAFG7Q.jpg\",\"url\":\"https:\\/\\/t.co\\/PBZdF2eqIR\",\"display_url\":\"pic.twitter.com\\/PBZdF2eqIR\",\"expanded_url\":\"https:\\/\\/twitter.com\\/TWUBeso\\/status\\/1111613346170703878\\/photo\\/1\",\"type\":\"photo\",\"sizes\":{\"large\":{\"w\":750,\"h\":535,\"resize\":\"fit\"},\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"small\":{\"w\":680,\"h\":485,\"resize\":\"fit\"},\"medium\":{\"w\":750,\"h\":535,\"resize\":\"fit\"}}}]}},\"quote_count\":1,\"reply_count\":0,\"retweet_count\":4,\"favorite_count\":4,\"entities\":{\"hashtags\":[{\"text\":\"MarketingMonday\",\"indices\":[71,87]}],\"urls\":[{\"url\":\"https:\\/\\/t.co\\/U6hisTP55C\",\"expanded_url\":\"https:\\/\\/twitter.com\\/i\\/web\\/status\\/1111613346170703878\",\"display_url\":\"twitter.com\\/i\\/web\\/status\\/1\\u2026\",\"indices\":[117,140]}],\"user_mentions\":[{\"screen_name\":\"TWUStudentU\",\"name\":\"TWU Student Union\",\"id\":1225222711,\"id_str\":\"1225222711\",\"indices\":[49,61]}],\"symbols\":[]},\"favorited\":false,\"retweeted\":false,\"possibly_sensitive\":false,\"filter_level\":\"low\",\"lang\":\"en\"},\"quoted_status_permalink\":{\"url\":\"https:\\/\\/t.co\\/NU7PuRqe6l\",\"expanded\":\"https:\\/\\/twitter.com\\/twubeso\\/status\\/1111613346170703878\",\"display\":\"twitter.com\\/twubeso\\/status\\u2026\"},\"is_quote_status\":true,\"quote_count\":0,\"reply_count\":0,\"retweet_count\":0,\"favorite_count\":0,\"entities\":{\"hashtags\":[{\"text\":\"LaTiendita\",\"indices\":[62,73]},{\"text\":\"haciendoruido\",\"indices\":[74,88]}],\"urls\":[],\"user_mentions\":[{\"screen_name\":\"TWUBeso\",\"name\":\"TWU BESO\",\"id\":3511723153,\"id_str\":\"3511723153\",\"indices\":[27,35]}],\"symbols\":[]},\"favorited\":false,\"retweeted\":false,\"filter_level\":\"low\",\"lang\":\"es\",\"timestamp_ms\":\"1554051864678\"}";
		rawRetweetJson = gson.fromJson(rawString, RawRetweetJson.class);
	}
	
	@Test
	void testQueryGeneratorInjectProperly() {
		assertNotNull(queryGenerator, "queryGenerator null");
	}

	@Test
	void testQueryGenerator() {
		try {
			String query = queryGenerator.generateQuery(rawRetweetJson);
			assertTrue(!query.contains("{0}"), query);
			assertTrue(!query.contains("{1}"), query);
			assertTrue(!query.contains("{2}"), query);
			assertTrue(!query.contains("{3}"), query);
			assertTrue(!query.contains("{4}"), query);
			assertTrue(!query.contains("{5}"), query);
		} catch (UnsupportedEncodingException e) {
			fail(e);
		}
	}

}
