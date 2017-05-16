package com.capgemini;

import com.capgemini.Model.Guests.Guest;
import com.capgemini.controller.GuestController;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Basis integratietest voor Spring boot applicatie
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IntegrationTest {
    
    @Autowired
    private GuestController guestController;
    
    @Test
    public void testGuestRetrieval() throws Exception {
        final List<Guest> guests = Lists.newArrayList(guestController.getGuestList());
        assertNotNull(guests);
        assertEquals(10, guests.size());
    }

    @Test
    public void testAddGuest() throws Exception {
        final Guest guest = new Guest("Jarno", "Straat 1", "1234 AB", "Amersfoort", "NL", "112", "");
        Guest result = guestController.addGuestList(guest);
        
        assertNotNull(guest);
        assertTrue(guest.getGuestID() > 0);

        System.out.println(guest.getGuestID());
        
        final Guest lookup = guestController.getGuest(guest.getGuestID());
        assertNotNull(lookup);
        assertEquals(result.getGuestID(), lookup.getGuestID());
        
        guestController.removeGuest(guest.getGuestID());
    }
}
