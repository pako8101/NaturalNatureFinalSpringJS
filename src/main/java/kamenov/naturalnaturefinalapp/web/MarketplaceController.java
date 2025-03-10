package kamenov.naturalnaturefinalapp.web;


import kamenov.naturalnaturefinalapp.entity.Product;
import kamenov.naturalnaturefinalapp.service.MarketplaceService;
import kamenov.naturalnaturefinalapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/marketplace")

public class MarketplaceController {
private final ProductService productService;
    private final MarketplaceService service;
    @Autowired
    public MarketplaceController(ProductService productService, MarketplaceService service) {
        this.productService = productService;
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> searchProducts(@RequestParam String name) {
        return service.searchProducts(name);
    }
    @GetMapping("/marketplace")
    public String marketplace(Model model) {
        model.addAttribute("products", service.getAllProducts());
        return "marketplace";
    }

    @GetMapping("/marketplace/product/{id}")
    public String productDetails(@PathVariable Long id, Model model) {
        model.addAttribute("product", service.getProductById(id));
        return "product-details";
    }
    @GetMapping("/admin/add-product")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/admin/add-product")
    public String addProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/marketplace";
    }
}
