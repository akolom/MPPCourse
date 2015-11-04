package business;

import java.io.Serializable;

public class LibraryMember extends Person implements Serializable {

	private static final long serialVersionUID = -8629914350456629837L;
	private String memberID;
	private CheckoutRecord record = new CheckoutRecord();

	public LibraryMember(String f, String l, String t, Address a,
			String memberID) {
		super(f, l, t, a);
		this.memberID = memberID;

	}

	public CheckoutRecord getRecord() {
		return record;
	}

	public String getMemberID() {
		return memberID;
	}

	@Override
	public String toString() {
		return "First Name: " + getFirstName() + ", Last Name: "
				+ getLastName() + ", Phone No: " + getTelephone()
				+ "Address - " + getAddress()+" Checkout Record "+getRecord();
	}
}
