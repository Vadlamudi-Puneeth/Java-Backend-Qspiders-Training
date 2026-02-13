package com.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class UserServiceTest {
	@Test
	public void typeOfUser() {
		UserDao daomock = mock(UserDao.class);
		
		User fakeObject = new User();
		fakeObject.setId(1);
		fakeObject.setName("puneeth");
		fakeObject.setBalance(1000);
		
		when(daomock.findById(1)).thenReturn(fakeObject);
		UserService service = new UserService(daomock);
		String res = service.typeOfUser(1);
		
		assertEquals("premium user", res);
		
	}
}
