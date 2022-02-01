/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
public class WeddingUI {
    public static void main(String[] args) {
        VenueManager vm = new VenueManager("2016weddings.txt");
        System.out.println(vm.processBooking());
        System.out.println(vm.bookingProcessing2());
        BookingDay.getSome();
    }
}
