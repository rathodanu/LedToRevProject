package comasr.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Attribute {
	

    @Column(nullable = false)
    private String key;

    @Column(nullable = false)
    private String value;

	public Attribute() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attribute(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Attribute [key=" + key + ", value=" + value + "]";
	}
    
}
