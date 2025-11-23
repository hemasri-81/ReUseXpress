package com.reusexpress.controller;
import com.reusexpress.model.Product; import com.reusexpress.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
@Controller public class HomeController {
    @Autowired private ProductService productService;
    @GetMapping("/") public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }
}
