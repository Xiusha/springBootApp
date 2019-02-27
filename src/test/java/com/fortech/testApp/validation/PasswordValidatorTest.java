package com.fortech.testApp.validation;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fortech.testApp.dtos.UserDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordValidatorTest {

	private static UserDTO user;

	@BeforeClass
	public static void initData() throws Exception {
		user = new UserDTO();
		user.setGivenLastName("Simon");
		user.setGivenName("Oxana");
		user.setPhone("0756288390");
		user.setUsername("xiusha");
	}

	public List<String> getValidPasswords() {
		return Arrays.asList("testT123&df", "T123&dftest", "123&dftestT", "&dftestT123");
	}

	public List<String> getInvalidPasswors() {
		return Arrays.asList("mkyong", "mkyong12", "mkyong123", "mkyong123@", "mkyong123@oxana", "mkyong123@simon",
				"mkyong123@xiusha", "mkyong123@0756288390");
	}

	@Test
	public void shouldPassEmailValidation() {
		for (String password : getValidPasswords()) {
			user.setPassword(password);
			boolean valid = PasswordValidator.isValid(user);
			Assert.assertEquals(valid, true);
		}

	}

	@Test
	public void shouldNotPassEmailValidation() {
		for (String password : getInvalidPasswors()) {
			user.setPassword(password);
			boolean valid = PasswordValidator.isValid(user);
			Assert.assertEquals(valid, false);
		}
	}

}
