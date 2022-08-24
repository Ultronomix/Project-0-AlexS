import io.javalin.Javalin;

public class Driver {
    public static void main(String[]args){
        BikeController bikeController = new BikeController();

        Javalin app = Javalin.create().start(8080);

        app.get("/bikes",bikeController.getAllBikes);
        app.post("/bikes",bikeController.createNewBike);


            }

    }
