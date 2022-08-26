package Controller;

import Models.Bike;
import Service.BikeService;
import io.javalin.http.Handler;

import java.util.List;


public class BikeController {
    private final BikeService bikeService = new BikeService();

    public Handler createNewBike = ctx -> {
        Bike newBike = ctx.bodyAsClass(Bike.class);
        try {
            ctx.json(bikeService. createBike(newBike));
        }catch (NullPointerException e){
            ctx.status(400).result("Could not create bike");

        }
    };
    public Handler getAllBikes = ctx -> {
        List<Bike> bikes = bikeService.getAllBikes();
        ctx.status(200).json(bikes);

    };
}
