package OnlineAuctionSystem;

public class Demo {
    public static void main(String[] args) {
        System.out.println("\n###### Mediator Design Pattern ######");
        System.out.println("\n===> Welcome to the Auction House!\n");

        AuctionMediator auctionHouse = new AuctionHouse("Vintage Boxer", 10000.0);

        IColleague bidder1 = new Bidder("akki", auctionHouse);
        IColleague bidder2 = new Bidder("Makki", auctionHouse);
        IColleague bidder3 = new Bidder("Sukki", auctionHouse);

        bidder1.placeBid(15000);
        bidder2.placeBid(20000);
        bidder3.placeBid(25000);
        bidder1.placeBid(30000);
        bidder2.placeBid(35000);

        auctionHouse.closeAuction();
    }
}