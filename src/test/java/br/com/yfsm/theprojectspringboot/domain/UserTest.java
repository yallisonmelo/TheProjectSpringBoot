package br.com.yfsm.theprojectspringboot.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTest {

    User user;

    @Before
    public void setup(){
      user = new User();
      user.setName("myname");
      user.setEmail("myemail@email.com");
      user.setPassword("mypassword");
      user.setId(1l);
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("myname",user.getName());
    }

    @Test
    public void testGetEmail(){
        Assert.assertEquals("myemail@email.com",user.getEmail());
    }

    @Test
    public void testGetPassword(){
        Assert.assertEquals("mypassword",user.getPassword());
    }

    @Test
    public void testGetId(){
        Assert.assertEquals(Optional.of(1l),Optional.of(user.getId()));
    }


    @Test
    public void testSetName(){
        user.setName("MyNameTest");
        Assert.assertEquals("MyNameTest",user.getName());
    }

    @Test
    public void testSetEmail(){
        user.setEmail("mytestemaill@email.com");
        Assert.assertEquals("mytestemaill@email.com",user.getEmail());
    }

    @Test
    public void testSetPassword(){
        user.setPassword("myTestPassW0rd");
        Assert.assertEquals("myTestPassW0rd",user.getPassword());
    }

    @Test
    public void testSetId(){
        user.setId(2l);
        Assert.assertEquals(Optional.of(2l),Optional.of(user.getId()));
    }
}
