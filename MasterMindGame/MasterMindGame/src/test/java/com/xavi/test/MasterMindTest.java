package com.xavi.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xavi.entity.Moves;
import com.xavi.service.ServiceGame;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" })
public class MasterMindTest {

    @Autowired
    private ServiceGame serviceGame;

    @Test
    public void validateCodeTest() {
        boolean result = serviceGame.validate("PYRB");
        assertTrue(result);
        
        result = serviceGame.validate("bgyo");
        assertTrue(result);

        result = serviceGame.validate("agyop");
        assertFalse(result);
    }

    @Test
    public void boardATest() {
        String secet = "GBRP";
        String[] user = { "Y", "Y", "B", "B" };
         Moves move = new Moves();
        move = serviceGame.checkCode(secet, user);
        assertEquals(0, move.getRed());
        assertEquals(1, move.getWhite());

        user[0] = "P";
        user[1] = "R";
        user[2] = "R";
        user[3] = "Y";
        move = serviceGame.checkCode(secet, user);
        assertEquals(1, move.getRed());
        assertEquals(1, move.getWhite());

        user[0] = "G";
        user[1] = "P";
        user[2] = "G";
        user[3] = "Y";
        move = serviceGame.checkCode(secet, user);
        assertEquals(1, move.getRed());
        assertEquals(1, move.getWhite());

        user[0] = "R";
        user[1] = "R";
        user[2] = "P";
        user[3] = "Y";
        move = serviceGame.checkCode(secet, user);
        assertEquals(0, move.getRed());
        assertEquals(2, move.getWhite());

        user[0] = "B";
        user[1] = "R";
        user[2] = "G";
        user[3] = "P";
        move = serviceGame.checkCode(secet, user);
        assertEquals(1, move.getRed());
        assertEquals(3, move.getWhite());

        user[0] = "G";
        user[1] = "B";
        user[2] = "R";
        user[3] = "P";
        move = serviceGame.checkCode(secet, user);
        assertEquals(4, move.getRed());
        assertEquals(0, move.getWhite());
    }

    @Test
    public void boardBTest() {
         Moves move = new Moves();
        String secet = "BYGO";
        String[] user = { "O", "O", "R", "G" };
        move = serviceGame.checkCode(secet, user);
        assertEquals(0, move.getRed());
        assertEquals(2, move.getWhite());
        
        user[0] = "O";
        user[1] = "O";
        user[2] = "G";
        user[3] = "R";
        move = serviceGame.checkCode(secet, user);
        assertEquals(1, move.getRed());
        assertEquals(1, move.getWhite());
        
        user[0] = "O";
        user[1] = "O";
        user[2] = "G";
        user[3] = "B";
        move = serviceGame.checkCode(secet, user);
        assertEquals(1, move.getRed());
        assertEquals(2, move.getWhite());
        
        user[0] = "O";
        user[1] = "B";
        user[2] = "G";
        user[3] = "O";
        move = serviceGame.checkCode(secet, user);
        assertEquals(2, move.getRed());
        assertEquals(1, move.getWhite());
        
        user[0] = "O";
        user[1] = "B";
        user[2] = "G";
        user[3] = "P";
        move = serviceGame.checkCode(secet, user);
        assertEquals(1, move.getRed());
        assertEquals(2, move.getWhite());
        
        user[0] = "P";
        user[1] = "B";
        user[2] = "G";
        user[3] = "O";
        move = serviceGame.checkCode(secet, user);
        assertEquals(2, move.getRed());
        assertEquals(1, move.getWhite());
    
        user[0] = "B";
        user[1] = "P";
        user[2] = "G";
        user[3] = "O";
        move = serviceGame.checkCode(secet, user);
        assertEquals(3, move.getRed());
        assertEquals(0, move.getWhite());
       
        user[0] = "R";
        user[1] = "P";
        user[2] = "G";
        user[3] = "O";
        move = serviceGame.checkCode(secet, user);
        assertEquals(2, move.getRed());
        assertEquals(0, move.getWhite());
        
        user[0] = "B";
        user[1] = "B";
        user[2] = "G";
        user[3] = "O";
        move = serviceGame.checkCode(secet, user);
        assertEquals(3, move.getRed());
        assertEquals(0, move.getWhite());
    
        user[0] = "B";
        user[1] = "B";
        user[2] = "G";
        user[3] = "O";
        move = serviceGame.checkCode(secet, user);
        assertEquals(3, move.getRed());
        assertEquals(0, move.getWhite());
     
        user[0] = "B";
        user[1] = "O";
        user[2] = "G";
        user[3] = "O";
        move = serviceGame.checkCode(secet, user);
        assertEquals(3, move.getRed());
        assertEquals(0, move.getWhite());
        
        user[0] = "B";
        user[1] = "Y";
        user[2] = "G";
        user[3] = "O";
        move = serviceGame.checkCode(secet, user);
        assertEquals(4, move.getRed());
        assertEquals(0, move.getWhite());
    }
    
    @Test
    public void testEspecialOne() {
         Moves move = new Moves();
        String secet = "RRPP";
        String[] user = { "B", "P", "R", "R" };
        move = serviceGame.checkCode(secet, user);
        Assert.assertEquals(0, move.getRed());
        Assert.assertEquals(3, move.getWhite());
    }
    
    @Test
    public void testEspecialDos() {
         Moves move = new Moves();
        String secet = "RRPP";
        String[] user = { "G", "R", "P", "R" };
        move = serviceGame.checkCode(secet, user);
        Assert.assertEquals(2, move.getRed());
        Assert.assertEquals(1, move.getWhite());
    }
    
    @Test
    public void testEspecialTres() {
        Moves move = new Moves();
        String secet = "RRPP";
        String[] user = { "P", "P", "P", "P" };
        move = serviceGame.checkCode(secet, user);
        Assert.assertEquals(2, move.getRed());
        Assert.assertEquals(0, move.getWhite());
    }
}
