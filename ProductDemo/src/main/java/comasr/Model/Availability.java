package comasr.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Availability {

    @Column(nullable = false)
    private boolean inStock;

    @Column(nullable = false)
    private int quantity;

	public Availability() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Availability(boolean inStock, int quantity) {
		super();
		this.inStock = inStock;
		this.quantity = quantity;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Availability [inStock=" + inStock + ", quantity=" + quantity + "]";
	}
    
    


}
