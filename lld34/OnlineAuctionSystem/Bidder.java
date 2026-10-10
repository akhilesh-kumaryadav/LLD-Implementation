package OnlineAuctionSystem;

public class Bidder implements IColleague {
    protected String name;
    protected AuctionMediator auctionMediator;

    public Bidder(String name, AuctionMediator auctionMediator) {
        this.name = name;
        this.auctionMediator = auctionMediator;
        auctionMediator.registerBidder(this);
    }

    @Override
    public void placeBid(double amount) {
        System.out.println("\n===> [Placing Bid] " + name + " is attempting to bid $" + amount);
        auctionMediator.placeBid(this, amount);
    }

    @Override
    public void receiveBidNotification(double bidAmount) {
        System.out.println("[+] Bidder " + name + " has received a new bid notification of: " + bidAmount);
    }

    @Override
    public String getName() {
        return name;
    }
}