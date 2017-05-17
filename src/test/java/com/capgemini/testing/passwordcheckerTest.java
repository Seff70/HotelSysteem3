package com.capgemini.testing;

import org.junit.Test;

import static org.junit.Assert.*;


public class passwordcheckerTest {

    @Test
    public void passwordcheckerTrue(){
        assertTrue(passwordchecker.isValid( "Wachtwoord1$" ));
    }

    @Test
    public void passwordcheckerFalse(){
        assertFalse(passwordchecker.isValid( "Wachtwoord1!" )  );
    }

    @Test
    public void passwordanothercheck(){
        assertFalse( passwordchecker.isValid( "") );
    }

    @Test
    public void anothercheck(){
        assertFalse(passwordchecker.isValid( null ));
    }


}