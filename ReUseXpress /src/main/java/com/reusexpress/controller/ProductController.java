package com.reusexpress.controller;
import com.reusexpress.model.Product; import com.reusexpress.model.User; import com.reusexpress.service.ProductService; import com.reusexpress.service.UserService;
import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*; import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession; import java.io.File; import java.io.IOException; import java.util.List;
@Controller @RequestMapping("/product")
public class ProductController {
    @Autowired private ProductService productService; @Autowired private UserService userService;
    private final String UPLOAD_DIR = "resources/uploads";
    @GetMapping("/list") public String list(Model model) { model.addAttribute("products", productService.findAll()); return "productList"; }
    @GetMapping("/add") public String addForm(Model model) { model.addAttribute("product", new Product()); return "productForm"; }
    @PostMapping("/save") public String save(@ModelAttribute Product product, @RequestParam("image") MultipartFile image, HttpSession session) throws IOException {
        User user = (User) session.getAttribute("user"); if (user == null) user = userService.findAll().stream().findFirst().orElse(null);
        product.setSeller(user);
        if (image != null && !image.isEmpty()) {
            String filename = System.currentTimeMillis() + "_" + StringUtils.cleanPath(image.getOriginalFilename());
            String fullPath = session.getServletContext().getRealPath("/") + UPLOAD_DIR;
            File dir = new File(fullPath); if(!dir.exists()) dir.mkdirs();
            File dest = new File(dir, filename); image.transferTo(dest);
            product.setImagePath(UPLOAD_DIR + "/" + filename);
        }
        if (product.getId() == null) productService.save(product); else productService.update(product);
        return "redirect:/";
    }
    @GetMapping("/details/{id}") public String details(@PathVariable Integer id, Model model) { model.addAttribute("product", productService.findById(id)); return "productDetails"; }
    @GetMapping("/delete/{id}") public String delete(@PathVariable Integer id) { com.reusexpress.model.Product p = productService.findById(id); if(p!=null) productService.delete(p); return "redirect:/"; }
    @GetMapping("/search") public String search(@RequestParam("q") String q, Model model) { model.addAttribute("products", productService.search(q)); return "productList"; }
}
