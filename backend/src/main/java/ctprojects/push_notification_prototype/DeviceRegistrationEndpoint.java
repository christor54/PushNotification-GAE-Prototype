//package com.example.christophe.myapplication.backend;
//
//import com.google.api.server.spi.config.Api;
//import com.google.api.server.spi.config.ApiMethod;
//import com.google.api.server.spi.config.ApiNamespace;
//
//import java.util.logging.Logger;
//
//import javax.inject.Named;
//
///**
// * An endpoint class we are exposing
// */
//@Api(
//        name = "deviceRegistrationApi",
//        version = "v1",
//        resource = "deviceRegistration",
//
//        namespace = @ApiNamespace(
//                ownerDomain = "backend.myapplication.christophe.example.com",
//                ownerName = "backend.myapplication.christophe.example.com",
//                packagePath = ""
//        )
//)
//public class DeviceRegistrationEndpoint {
//
//    private static final Logger logger = Logger.getLogger(DeviceRegistrationEndpoint.class.getName());
//
//    /**
//     * This method gets the <code>DeviceRegistration</code> object associated with the specified <code>id</code>.
//     *
//     * @param id The id of the object to be returned.
//     * @return The <code>DeviceRegistration</code> associated with <code>id</code>.
//     */
//    @ApiMethod(name = "getDeviceRegistration")
//    public DeviceRegistration getDeviceRegistration(@Named("id") Long id) {
//        // TODO: Implement this function
//        logger.info("Calling getDeviceRegistration method");
//        return null;
//    }
//
//    /**
//     * This inserts a new <code>DeviceRegistration</code> object.
//     *
//     * @param deviceRegistration The object to be added.
//     * @return The object to be added.
//     */
//    @ApiMethod(name = "insertDeviceRegistration")
//    public DeviceRegistration insertDeviceRegistration(DeviceRegistration deviceRegistration) {
//        // TODO: Implement this function
//        logger.info("Calling insertDeviceRegistration method");
//        return deviceRegistration;
//    }
//}