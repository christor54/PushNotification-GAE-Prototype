package ctprojects.push_notification_prototype;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;

import java.util.List;
import java.util.logging.Logger;


import javax.inject.Named;

import static ctprojects.push_notification_prototype.OfyService.ofy;

/**
* An endpoint class we are exposing
*/
@Api(
        name = "deviceRegistrationApi",
        version = "v1",
        resource = "deviceRegistration",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.christophe.example.com",
                ownerName = "backend.myapplication.christophe.example.com",
                packagePath = ""
        )
)
public class DeviceRegistrationEndpoint {

    private static final Logger logger = Logger.getLogger(DeviceRegistrationEndpoint.class.getName());

    /**
     * This method gets the <code>DeviceRegistration</code> object associated with the specified <code>id</code>.
     *
     * @param id The id of the object to be returned.
     * @return The <code>DeviceRegistration</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getDeviceRegistration")
    public DeviceRegistration getDeviceRegistration(@Named("id") Long id) {
        // TODO: Implement this function
        logger.info("Calling getDeviceRegistration method");
        ofy().load().entity(DeviceRegistration.class).safe();
        return null;
    }

    /**
     * This inserts a new <code>DeviceRegistration</code> object.
     *
     * @param regId The string of the device to be registered
     * @return The object to be added.
     */
    @ApiMethod(name = "register")
    public void registerDevice(@Named("regId") String regId) {
        // TODO: Implement this function
        if (findRecord(regId) != null) {
            logger.info("Device " + regId + " already registered, skipping register");
            return;
        }
        DeviceRegistration registration = new DeviceRegistration();
        registration.setRegId(regId);
        ofy().save().entity(registration).now();
    }


    @ApiMethod(name = "unregister", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void unregisterDevice(@Named("regId") String regId) {
        DeviceRegistration record = findRecord(regId);
        if (record == null) {
            logger.info("Device " + regId + " not registered, skipping unregister");
            return;
        }
        ofy().delete().entity(record).now();
    }

    /**
     * Return a collection of registered devices
     *
     * @param count The number of devices to list
     * @return a list of Google Cloud Messaging registration Ids
     */
    @ApiMethod(name = "listDevices",
    path = "DeviceRegistration/list")
    public CollectionResponse<DeviceRegistration> listDevices(@Named("count") int count) {
        List<DeviceRegistration> records = ofy().load().type(DeviceRegistration.class).limit(count).list();
        return CollectionResponse.<DeviceRegistration>builder().setItems(records).build();
    }

    private DeviceRegistration findRecord(String regId) {
        return ofy().load().type(DeviceRegistration.class).filter("regId", regId).first().now();
    }
}