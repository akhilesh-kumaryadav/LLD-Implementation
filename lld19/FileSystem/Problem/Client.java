package FileSystem.Problem;

public class Client {
    public static void main(String[] args) {
        Directory movieDirectory = new Directory("Movies");

        File rentalReceipts = new File("RentalReceipt");
        movieDirectory.add(rentalReceipts);

        Directory comedyMovieDirectory = new Directory("ComedyMovies");
        File dumbAndDumber = new File("DumbAndDumber");
        comedyMovieDirectory.add(dumbAndDumber);
        movieDirectory.add(comedyMovieDirectory);

        movieDirectory.printContents();
    }
}