package com.example.shopping.controller;

import com.example.shopping.dto.CartDto;
import com.example.shopping.entity.Product;
import com.example.shopping.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {
    @Autowired
    IProductService productService;

    @ModelAttribute("cart")
    public CartDto setupCart() {
        return new CartDto();
    }
    @GetMapping
    public String showCart(@SessionAttribute(name = "cart",required = false) CartDto cartDto, Model model){
        model.addAttribute("cartDto",cartDto);
        return "cart";
    }
    @GetMapping("/add/{id}")
    public String addCart(@PathVariable Integer id,@SessionAttribute(name = "cart") CartDto cartDto,@RequestParam(name = "action",required = false) String action){
        Product product=productService.findById(id);
        if (product!=null){
            cartDto.addProduct(product);
        }
        if ("details".equals(action)) {
            return "redirect:/shop/details/" + id;
        }
        return "redirect:/shop";
    }

    @PostMapping("/update")
    public String updateCart(@RequestParam("productId") Integer productId,@RequestParam("quanlity") Integer quantity,@SessionAttribute("cart") CartDto cartDto){
        Product product=productService.findById(productId);
        if (product != null) {
            cartDto.changeQuantity(product, quantity);
        }
        return "redirect:/cart";
    }
    @GetMapping("/delete/{id}")
    public String deleteFromCart(@PathVariable Integer id, @SessionAttribute("cart") CartDto cart) {
        Product product = productService.findById(id);
        if (product != null) {
            cart.changeQuantity(product, 0);
        }
        return "redirect:/cart";
    }
    @GetMapping("/checkout")
    public String checkout(@SessionAttribute("cart") CartDto cart, RedirectAttributes redirectAttributes) {
        cart.getProducts().clear();
        redirectAttributes.addFlashAttribute("successMessage", "Thanh toán thành công! Cảm ơn bạn đã mua hàng.");
        return "redirect:/cart";
    }
}
