package com.capgemini.controller;

import org.junit.Test;


import static org.junit.Assert.*;


public class OefeningTest {

    @Test
    public void reverselenghtTestTrue() {

        assertEquals("Hello", Oefening.reverse( "olleH" )  );}

    @Test
       public void reverselengthTrueTest() {

    String input = "olleh";

       assertEquals(input.length(),Oefening.reverse( input ).length()  );

    }

}