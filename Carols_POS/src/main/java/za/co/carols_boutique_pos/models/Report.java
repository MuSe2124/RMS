package za.co.carols_boutique_pos.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import za.co.carols_boutique.models.EmpSale;
import za.co.carols_boutique.models.ProdStore;
import za.co.carols_boutique.models.ProductReport;
import za.co.carols_boutique.models.Review;
import za.co.carols_boutique.models.SaleReport;
import za.co.carols_boutique.models.StoreSale;
import za.co.carols_boutique_pos.rest_clients.RestReport;
import za.co.carols_boutique_pos.service.ReportS;

public class Report implements Serializable {

	private ReportS service;
	private List<StoreSale> storeSales;
	private List<EmpSale> empSales;
	private List<ProdStore> prodStores;
	private List<Sale> sales;
	private ProductReport productReport;
	private List<SaleReport> saleReports;
	private List<Review> reviews;

	public Report() {
		service = new RestReport();
		reviews = new ArrayList<Review>();
		storeSales = new ArrayList<>();
		empSales = new ArrayList<>();
		prodStores = new ArrayList<>();
		sales = new ArrayList<>();
		saleReports = new ArrayList<>();
	}


	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}
	

	public List<Sale> getSales() {
		return sales;
	}

	public ProductReport getProductReport() {
		return productReport;
	}

	public void setProductReport(ProductReport productReport) {
		this.productReport = productReport;
	}

	public void setStoresSales(List<Sale> sales) {
		this.sales = sales;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<StoreSale> getStoreSales() {
		return storeSales;
	}

	public void setStoreSales(List<StoreSale> storeSales) {
		this.storeSales = storeSales;
	}

	public List<EmpSale> getEmpSales() {
		return empSales;
	}

	public void setEmpSales(List<EmpSale> empSales) {
		this.empSales = empSales;
	}

	public List<ProdStore> getProdStores() {
		return prodStores;
	}

	public void setProdStores(List<ProdStore> prodStores) {
		this.prodStores = prodStores;
	}

	public List<SaleReport> getSaleReports() {
		return saleReports;
	}

	public void setSaleReports(List<SaleReport> saleReports) {
		this.saleReports = saleReports;
	}

	@Override
	public String toString() {
		String s = "Report{" + "\nservice=" + service + "\nreviews=" + reviews.size() + "\nstoreSales=" + storeSales.size() + "\nempSales=" + empSales.size() + "\nprodStores=" + prodStores.size() + "\nsales=" + sales.size() + "\nsaleReports=" + saleReports.size() + "\n";
		if (productReport != null) {
			s += "\nproductReport= " + productReport.toString();
		}
		return s;
	}

}
