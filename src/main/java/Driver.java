import io.javalin.Javalin;
import Controller.BikeController;

public class  Driver {
    public static void main(String[]args){
        BikeController bikeController = new BikeController();

        Javalin app = Javalin.create().start(5432);

        app.get("/bikes",bikeController.getAllBikes);
        app.post("/bikes",bikeController.createNewBike);


            }

    }
