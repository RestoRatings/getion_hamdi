/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_hamdi;

/**
 *
 * @author Hamdi
 */
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilloSMS {
    // Your Twilio credentials and phone number
    public static final String ACCOUNT_SID = "ACcad5c96ec49f6399b9787e86bcc9c70e";
    public static final String AUTH_TOKEN = "9f4028af8e36834c9df6fe6c784b87fb";
    public static final String FROM_PHONE_NUMBER = "+16782937692";

    public static void sendSMS(String toPhoneNumber, String messageBody) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
            new PhoneNumber(toPhoneNumber),
            new PhoneNumber(FROM_PHONE_NUMBER),
            messageBody)
            .create();

        System.out.println("SMS sent with SID: " + message.getSid());
    }
}
