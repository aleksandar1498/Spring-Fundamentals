package bg.softuni.shopping.service;

import java.util.List;

import bg.softuni.shopping.common.enums.CategoryType;
import bg.softuni.shopping.domain.service.ProductServiceModel;

public interface ProductService {
	void add(ProductServiceModel product);

	List<ProductServiceModel> getAllProducts();

	void buy(String productId);

	void buyAll();
}
