package in.co.rays.mapping;

import java.util.Set;

public class AuctionItem {
	private int id ;
	private String Description ;
	private  Set<bid> Bid;
	
	public AuctionItem() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Set<bid> getBid() {
		return Bid;
	}

	public void setBid(Set<bid> bid) {
		Bid = bid;
	}
	
}
