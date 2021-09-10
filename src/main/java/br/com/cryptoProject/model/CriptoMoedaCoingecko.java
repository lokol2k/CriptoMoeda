package br.com.cryptoProject.model;

import br.com.cryptoProject.Commons.Market_Data;

public class CriptoMoedaCoingecko {

	private String id;
	private String name;
	private String asset_platform_id;
	/*Total Volume
	 *price_change_percentage_7d 
	 *private Low_24h low_24h;
	  price_change_24h;
	  price_change_percentage_24h;
	  price_change_percentage_7d;	
	  price_change_percentage_14d;
	  price_change_percentage_30d;
	  price_change_percentage_60d;
	  price_change_percentage_200d;
	  price_change_percentage_1y;
	  market_cap_change_24h;
	  market_cap_change_percentage_24h; */
	private Market_Data market_data;

	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAsset_platform_id() {
		return asset_platform_id;
	}
	public void setAsset_platform_id(String asset_platform_id) {
		this.asset_platform_id = asset_platform_id;
	}
	
	public Market_Data getMarket_data() {
		return market_data;
	}
	public void setMarket_data(Market_Data market_data) {
		this.market_data = market_data;
	}





	
}
