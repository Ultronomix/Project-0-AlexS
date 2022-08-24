package Controller;

import Models.Bike;
import Service.BikeService;
import org.eclipse.jetty.http.HttpStatus;

import java.util.List;
import java.util.logging.Handler;

public class BikeController {
    private final BikeService bikeService = new BikeService();

    private Handler createNewBike = ctx -> {
        Bike newBike = ctx.bodyAsClass(Bike.class);
        boolean success = bikeService.createBike(newBike);
        if (success) {
            ctx.status(HttpStatus.CREATED_201).result("Bike created");
        } else {
            ctx.status(400).result("could not create bike");
        }
    };
    public Handler getAllBikes = ctx -> {
        List<Bike> bikes = bikeService.getAllBikes();
        ctx.status(200).json(bikes);

    };
}
