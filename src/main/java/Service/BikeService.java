package Service;

import Models.Bike;
import Repository.BikeRepository;

import java.util.List;

public class BikeService {
    private final BikeRepository bikeRepository = new BikeRepository();

    public Bike createBike(Bike bike){
        return bikeRepository.create(bike);
    }
    public List<Bike> getAllBikes(){
        return bikeRepository.getAll();
    }
}
