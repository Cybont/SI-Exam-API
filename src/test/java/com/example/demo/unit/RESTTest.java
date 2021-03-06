package com.example.demo.unit;


import com.example.demo.Service.BookingService;
import dto.CreateBookingDTO;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class RESTTest {

    @Mock BookingService bookingServiceMock;
    @Mock CreateBookingDTO createBookingMock;

    @Test
    public void testREST() throws IOException {

        HttpUriRequest request =
                new HttpGet("http://ec2-3-139-98-176.us-east-2.compute.amazonaws.com/");
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        assertThat(

                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.OK.value())

        );
    }
  /*  @Test
    public void mustReturnTrueWhenABookingIsMade() {

        HotelController ht = new HotelController(bookingServiceMock);
        String passPortNumber = "abc123";
        verify(bookingServiceMock, times(1)).createBooking(argThat(b->b.getPassportNumber().equals(passPortNumber)));
        boolean result = ht.hotel();
        when(bookingServiceMock.createBooking(createBookingMock)).thenReturn(true);


    
    }*/
}
