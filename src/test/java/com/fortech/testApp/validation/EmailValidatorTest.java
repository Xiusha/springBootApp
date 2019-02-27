package com.fortech.testApp.validation;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailValidatorTest {

	public List<String> getValidEmails() {
		return Arrays.asList("mkyong@yahoo.com", "mkyong-100@yahoo.com", "mkyong.100@yahoo.com", "mkyong111@mkyong.com",
				"mkyong-100@mkyong.net", "mkyong.100@mkyong.com.au", "mkyong@1.com", "mkyong@gmail.com.com",
				"mkyong+100@gmail.com", "mkyong-100@yahoo-test.com");
	}

	public List<String> getInvalidEmails() {
		return Arrays.asList("mkyong", "mkyong@.com.my", "mkyong123@gmail.a", "mkyong123@.com", "mkyong123@.com.com",
				".mkyong@mkyong.com", "mkyong()*@gmail.com", "mkyong@%*.com", "mkyong..2002@gmail.com",
				"mkyong.@gmail.com", "mkyong@mkyong@gmail.com", "mkyong@gmail.com.1a");
	}

	@Test
	public void shouldPassEmailValidation() {
		for (String temp : getValidEmails()) {
			boolean valid = EmailValidator.isValid(temp);
			Assert.assertEquals(valid, true);
		}

	}

	@Test
	public void shouldNotPassEmailValidation() {

		for (String temp : getInvalidEmails()) {
			boolean valid = EmailValidator.isValid(temp);
			Assert.assertEquals(valid, false);
		}
	}

}
