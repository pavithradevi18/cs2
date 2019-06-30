package text;

public class health {
	String policyno;
	String cost;
	String expdate;
	String addate;
	String disdate;
	String medspec;
	public String getPolicyno() {
		return policyno;
	}
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getExpdate() {
		return expdate;
	}
	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}
	public String getAddate() {
		return addate;
	}
	public void setAddate(String addate) {
		this.addate = addate;
	}
	public String getDisdate() {
		return disdate;
	}
	public void setDisdate(String disdate) {
		this.disdate = disdate;
	}
	public String getMedspec() {
		return medspec;
	}
	public void setMedspec(String medspec) {
		this.medspec = medspec;
	}
	public health(String policyno,String cost,String expdate,String addate,String disdate,String medspec)
	{
		this.policyno=policyno;
		this.cost=cost;
		this.expdate=expdate;
		this.addate=addate;
		this.disdate=disdate;
		this.medspec=medspec;
	}

}
