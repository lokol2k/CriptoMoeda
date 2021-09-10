package br.com.cryptoProject.Commons;

public class Market_Data {
	/*Total Volume*/
	private Total_Volume total_volume;	
	/*High_24h*/
	private High_24h high_24h;	
	/*Low_24h*/
	private Low_24h low_24h;
	private Float price_change_24h;
	private Float price_change_percentage_24h;
	private String price_change_percentage_7d;	
	private Float price_change_percentage_14d;
	private Float price_change_percentage_30d;
	private Float price_change_percentage_60d;
	private Float price_change_percentage_200d;
	private Float price_change_percentage_1y;
	private Float market_cap_change_24h;
	private Float market_cap_change_percentage_24h;
	
	public Total_Volume getTotal_volume() {
		return total_volume;
	}

	public void setTotal_volume(Total_Volume total_volume) {
		this.total_volume = total_volume;
	}

	public String getPrice_change_percentage_7d() {
		return price_change_percentage_7d;
	}

	public void setPrice_change_percentage_7d(String price_change_percentage_7d) {
		this.price_change_percentage_7d = price_change_percentage_7d;
	}

	public High_24h getHigh_24h() {
		return high_24h;
	}

	public void setHigh_24h(High_24h high_24h) {
		this.high_24h = high_24h;
	}

	public Low_24h getLow_24h() {
		return low_24h;
	}

	public void setLow_24h(Low_24h low_24h) {
		this.low_24h = low_24h;
	}

	public Float getPrice_change_24h() {
		return price_change_24h;
	}

	public void setPrice_change_24h(Float price_change_24h) {
		this.price_change_24h = price_change_24h;
	}

	public Float getPrice_change_percentage_24h() {
		return price_change_percentage_24h;
	}

	public void setPrice_change_percentage_24h(Float price_change_percentage_24h) {
		this.price_change_percentage_24h = price_change_percentage_24h;
	}

	public Float getPrice_change_percentage_14d() {
		return price_change_percentage_14d;
	}

	public void setPrice_change_percentage_14d(Float price_change_percentage_14d) {
		this.price_change_percentage_14d = price_change_percentage_14d;
	}

	public Float getPrice_change_percentage_30d() {
		return price_change_percentage_30d;
	}

	public void setPrice_change_percentage_30d(Float price_change_percentage_30d) {
		this.price_change_percentage_30d = price_change_percentage_30d;
	}

	public Float getPrice_change_percentage_60d() {
		return price_change_percentage_60d;
	}

	public void setPrice_change_percentage_60d(Float price_change_percentage_60d) {
		this.price_change_percentage_60d = price_change_percentage_60d;
	}

	public Float getPrice_change_percentage_200d() {
		return price_change_percentage_200d;
	}

	public void setPrice_change_percentage_200d(Float price_change_percentage_200d) {
		this.price_change_percentage_200d = price_change_percentage_200d;
	}

	public Float getPrice_change_percentage_1y() {
		return price_change_percentage_1y;
	}

	public void setPrice_change_percentage_1y(Float price_change_percentage_1y) {
		this.price_change_percentage_1y = price_change_percentage_1y;
	}

	public Float getMarket_cap_change_24h() {
		return market_cap_change_24h;
	}

	public void setMarket_cap_change_24h(Float market_cap_change_24h) {
		this.market_cap_change_24h = market_cap_change_24h;
	}

	public Float getMarket_cap_change_percentage_24h() {
		return market_cap_change_percentage_24h;
	}

	public void setMarket_cap_change_percentage_24h(Float market_cap_change_percentage_24h) {
		this.market_cap_change_percentage_24h = market_cap_change_percentage_24h;
	}
	
	
}
