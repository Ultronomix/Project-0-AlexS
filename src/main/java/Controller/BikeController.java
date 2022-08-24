package Controller;

import Models.Bike;
import Service.BikeService;


import java.util.List;
import java.util.logging.Handler;

public class BikeController {
    public final BikeService bikeService = new BikeService();

    public Handler createNewBike = ctx -> {
        Bike newBike = ctx.bodyAsClass(Bike.class);
        Boolean success = bikeService.createBike(newBike);
        if (success) {
            ctx.status(HttpStatus.CREATED_201);
        } else {
            ctx.status(400).result("could not create bike");
        }
    };
    public Handler getAllBikes = ctx -> {
        List<Bike> bikes = bikeService.getAllBikes();
        ctx.json(200).json(bikes);

    };
}
