package com.lexach.ClothingFeed.controller;

import com.lexach.ClothingFeed.model.Product;
import com.lexach.ClothingFeed.model.ProductImage;
import com.lexach.ClothingFeed.model.User;
import com.lexach.ClothingFeed.model.UserBookmark;
import com.lexach.ClothingFeed.service.ProductCategoryService;
import com.lexach.ClothingFeed.service.ProductService;
import com.lexach.ClothingFeed.service.UserBookmarkService;
import com.lexach.ClothingFeed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private UserBookmarkService userBookmarkService;

    @GetMapping("/summary")
    public String summary(Model model, @RequestParam Long productId) {

        // Adding categories to model, so they are showed on sidebar.
        productCategoryService.addCategoriesToModel(model);

        Optional<Product> productOptional = productService.findById(productId);

        if(productOptional.isPresent()) {

            Product product = productOptional.get();

            model.addAttribute("product", product);

            ArrayList<ProductImage> productImages = new ArrayList<ProductImage>(product.getProductImages());

            model.addAttribute("productImages", productImages);

            Authentication existingAuth = SecurityContextHolder.getContext().getAuthentication();

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            if (!(auth instanceof AnonymousAuthenticationToken)) {

                User user = userService.getCurrentUser();

                UserBookmark userBookmark = userBookmarkService.findByUserAndProduct(user, product);

                model.addAttribute("userBookmark", userBookmark);
            }


        }
        return "/product/summary";
    }

    /**
     * Method bookmarks @param product.
     */
    // TODO this method should work for only authorised users.
    @GetMapping("/bookmark")
    public String bookmark( @RequestParam Long productId, @RequestParam String action) {

        Optional<Product> productOptional = productService.findById(productId);

        if(productOptional.isPresent()) {

            Product product = productOptional.get();

            User user = userService.getCurrentUser();

            if(action.equals("add")) {
                UserBookmark userBookmark = userBookmarkService.findByUserAndProduct(user, product);
                if(Objects.isNull(userBookmark)) {
                    userBookmark = new UserBookmark(user, product);

                    userBookmarkService.save(userBookmark);
                }
            } else if(action.equals("delete")) {
                UserBookmark userBookmark = userBookmarkService.findByUserAndProduct(user, product);

                userBookmarkService.delete(userBookmark);
            }

        }

        return ("redirect:/product/summary?productId=" + productId);
    }


}
