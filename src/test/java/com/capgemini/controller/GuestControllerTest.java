package com.capgemini.controller;

import com.capgemini.Model.Guests.Guest;
import com.capgemini.repository.GuestRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.yaml.snakeyaml.events.Event;

import java.sql.SQLException;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GuestControllerTest {

    @InjectMocks // Tested class
    private GuestController guestController;

    @Mock // dependencies for tested class
    private GuestRepository guestRepository;

    @Test
    public void findAllTrue2() throws Exception {
//        when(guestRepository.findAll()).thenThrow( IllegalArgumentException.class);
//        when(guestRepository.findAll()).thenReturn( new Iterable<Guest>() {
//            @Override
//            public Iterator<Guest> iterator() {
//                return Arrays.asList(new Guest("","","","","","","")).iterator();
//            }
//        } );

        final Iterable<Guest> guests = guestController.getGuestList(); // testing the method

        verify( guestRepository, times( 1 ) ).findAll();
    }

    @Test
    public void findOneGuest() throws Exception{
        when(guestRepository.findOne(1)).thenReturn( new Guest( "","","","","","","") );


        assertNotNull( guestController.getGuest(1));

        verify( guestRepository, times( 1 ) ).findOne( 1 );
        verify( guestRepository, times( 0 ) ).findAll(  );
    }

    @Test(expected = SQLException.class)
    public void findOneGuestNotFound() throws Exception{
        when(guestRepository.findOne(1)).thenThrow( SQLException.class );

        assertNotNull( guestController.getGuest(1));
    }

    @Test
    public void addGuestListTrue() throws SQLException{
        Guest guest = new Guest(  "","","","","","","");
        when(guestRepository.save( guest )).thenReturn( guest );
        assertEquals( guest, guestController.addGuestList(guest));
    }

    @Test
    public void removeGuestTrue() throws SQLException {
        Guest guest = new Guest("","","","","","","");
//        when(guestRepository.delete( guest )).thenReturn(guestController.getGuest( 1 ));
//        assertEquals( guest, guestController.getGuest( null ) );
    }


}